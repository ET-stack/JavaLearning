package com.example;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootElasticsearchApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private RestHighLevelClient client;

    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test");
        CreateIndexResponse response  = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response );
    }
    @Test
    public void ExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("test");
        boolean exists = client.indices().exists(request,RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    public void  deleteIndex() throws IOException {
        DeleteIndexRequest deleteRequest = new DeleteIndexRequest("test");
        AcknowledgedResponse exists = client.indices().delete(deleteRequest,RequestOptions.DEFAULT);
        System.out.println(exists);
    }


}
