package com.playzone.bookstore.repository;

import static com.playzone.bookstore.Constants.BOOK_TABLE;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.playzone.bookstore.entity.Book;
import com.playzone.bookstore.entity.BookTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreRepositoryTest {

	@Autowired
	ReactiveBookstoreRepository repository;
	
	@Autowired
	CassandraAdminTemplate adminTemplate;
	
	@Before
	public void createTable() {
		adminTemplate.createTable(
  		      true, CqlIdentifier.fromCql(BOOK_TABLE), 
  		      Book.class, new HashMap<String, Object>());
	}

    @Before
    public void setUp() {    	
    	
        Flux<Book> deleteAndInsert = repository.deleteAll()
          .thenMany(repository.saveAll(Flux.just(BookTest.getTestData(4)).flatMap(Flux::fromIterable)));

        StepVerifier
          .create(deleteAndInsert)
          .expectNextCount(4)
          .verifyComplete();
    }
    
    @After
    public void dropTable() {
        adminTemplate.dropTable(CqlIdentifier.fromCql(BOOK_TABLE));
    }

    @Test
    public void givenRecordsAreInserted_whenDbIsQueried_thenShouldIncludeNewRecords() {
        Mono<Long> saveAndCount = repository.count()
          .doOnNext(System.out::println)
          .thenMany(repository.saveAll(Flux.just(BookTest.getTestData(2)).flatMap(Flux::fromIterable)))
          .last()
          .flatMap(v -> repository.count())
          .doOnNext(System.out::println);

        StepVerifier
          .create(saveAndCount)
          .expectNext(6L)
          .verifyComplete();
    }

    //@Test
//    public void givenYearForFilter_whenDbIsQueried_thenShouldReturnFilteredRecords() {
//        StepVerifier
//          .create(repository.findByYear(35))
//          .expectNextCount(4)
//          .verifyComplete();
//    }

}
