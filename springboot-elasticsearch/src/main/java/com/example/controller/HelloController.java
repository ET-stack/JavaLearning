package com.example.controller;

import com.example.model.ShuiMoTangShi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.util.concurrent.ListenableFuture;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class HelloController {
    @Qualifier("elasticsearchRestHighLevelClient")
    @Autowired
    RestHighLevelClient client;
    private static final String TANGSHI_INDEX_NAME = "tangshimodel";

    @GetMapping("Hello/{HelloStr}")
    public void Hello(@PathVariable("HelloStr") String HelloStr) throws IOException {
        CreateIndexRequest user = new CreateIndexRequest("user");
        CreateIndexResponse response = client.indices().create(user, RequestOptions.DEFAULT);

        //响应状态
        boolean acknowleged = response.isAcknowledged();
        System.out.println("索引操作" + acknowleged);

    }

    public List<ShuiMoTangShi> readShuiMoTangShi(){
        File file = new File("E:\\Development\\BackEnd\\Java\\chinese-poetry\\shuimotangshi\\shuimotangshi.json");
        StringBuilder TangshiStr = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = bf.readLine()) != null){
                TangshiStr.append(str);
            }
            bf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> tangShiList;
        try {
            tangShiList = objectMapper.readValue(TangshiStr.toString(),List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<ShuiMoTangShi> returnList = new ArrayList<>();
        tangShiList.forEach( e->{
            ShuiMoTangShi t = new ShuiMoTangShi();
            t.setTitle(e.get("title").toString());
            t.setAuthor(e.get("author").toString());
           ArrayList tList = (ArrayList) e.get("paragraphs");
            StringBuilder sb = new StringBuilder();
            if (tList != null && tList.size() > 0)
            tList.forEach(c->{
                if (c != null)
                sb.append(c);
            });
            t.setParagraphs(sb.toString());
            t.setPrologue(e.get("prologue").toString());
            returnList.add(t);

        });
        return returnList;
    }

    @GetMapping("/insert")
    public void insert() throws IOException {
        List<ShuiMoTangShi> TangShiList = readShuiMoTangShi();
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest(TANGSHI_INDEX_NAME);
//        CreateIndexResponse response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);

//        //响应状态
//        boolean acknowleged = response.isAcknowledged();
//        System.out.println("索引操作" + acknowleged);
//        boolean isSuccess = response.isAcknowledged();
        TangShiList.forEach( e->{

            addTangShi(e);
        });


    }
    public RestStatus addTangShi(ShuiMoTangShi tangShi)  {
        //准备文档
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("title",tangShi.getTitle());
        jsonMap.put("author", tangShi.getAuthor());
        jsonMap.put("prologue", tangShi.getPrologue());
        jsonMap.put("paragraphs", tangShi.getParagraphs());

        //创建请求
        IndexRequest indexRequest = new IndexRequest("tangshimodel", "doc");
        //指定文档内容
        indexRequest.source(jsonMap);
        //通过client进行http请求
        IndexResponse indexResponse = null;
        try {
            indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //响应结果
        DocWriteResponse.Result result = indexResponse.getResult();
        RestStatus status = indexResponse.status();
        return status;
    }
    @GetMapping("/search")
    public String search(String keyWord){
//        GetIndexRequest getIndexRequest = client.indices()
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.should( QueryBuilders.matchQuery("paragraphs", keyWord) );
        try {
            SearchResponse response = client.search( new SearchRequest()
                            .source( new SearchSourceBuilder()
                                    .query(boolQuery) )
                    , RequestOptions.DEFAULT );
            for (SearchHit data : response.getHits()) {
                System.out.println( data.getSourceAsString() );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }


    @GetMapping("/searchHightlight")
    public String searchHightlight(String keyWord){
        SearchRequest searchRequest = new SearchRequest(TANGSHI_INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("paragraphs", keyWord));
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("paragraphs", 10)
                .preTags("<font color='red'>")
                .postTags("</font>");

        searchSourceBuilder.highlighter(highlightBuilder);
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse resp = client.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit hit : resp.getHits().getHits()) {
                System.out.println(hit.getHighlightFields().get("paragraphs"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
