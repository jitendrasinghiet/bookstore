package com.playzone.bookstore;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name: 'default'}")
    private String KEYSPACE;

    @Value("${spring.data.cassandra.contact-points: localhost}")
    private String CONTACT_POINT;

    @Value("${spring.data.cassandra.port: 9042}")
    private int PORT;


    @Override
    public String getContactPoints() {
        return CONTACT_POINT;
    }

    @Override
    protected int getPort() {
        return PORT;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(KEYSPACE)
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication(3L));
    }

    @Override
    protected String getLocalDataCenter() {
        return "DC1";
    }

    //@Override
    //protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
    //    return Collections.singletonList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    //}

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }
   
    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.playzone.bookstore.entity"};
    }   
}
