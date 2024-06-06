package com.example.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;


/**
 * @author Yi
 * @date 2020/7/4 19:36
 */
@Configuration
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    //localhost:9200 写在配置文件中就可以了
    @Value("${spring.data.elasticsearch}")
    private String esUrl;


    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(esUrl)
                .build();

        return RestClients.create(clientConfiguration).rest();

    }
}
