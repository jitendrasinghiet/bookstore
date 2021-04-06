package com.playzone.bookstore.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.playzone.bookstore.entity.Book;
import com.playzone.bookstore.entity.BookTest;
import com.playzone.bookstore.service.BookstoreService;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(BookstoreController.class)
public class BookstoreControllerTest {

	@Autowired
    WebTestClient webTestClient;

    @MockBean
    private BookstoreService bookstoreService;
    
    @Test
	public void testRetrieveBook() {
		Book book = BookTest.getTestData(1).get(0);				
        Mono<Book> bookMono = Mono.just(book);

        when(bookstoreService.getByIDMono(book.getId())).thenReturn(bookMono);

        webTestClient.get()
                .uri("/v1/book/mono/"+book.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Book.class);
	}
    
/*	
	@Test
	public void testSaveEmployees() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllBooks() {
		fail("Not yet implemented");
	}	

	@Test
	public void testDeleteBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBook() {
		fail("Not yet implemented");
	}
*/
}
