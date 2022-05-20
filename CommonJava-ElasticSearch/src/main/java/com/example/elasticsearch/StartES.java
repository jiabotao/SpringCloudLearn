package com.example.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.xcontent.XContentType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StartES {

    public static void main(String[] args) throws Exception {
        HttpHost a = new HttpHost("192.168.3.121", 9200, "http");
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(a));

        Map<String, String> config = new HashMap<>();
        config.put("user_name", "date");
        config.put("gender", "keyword");
        config.put("password", "text");
        config.put("age", "long");
        createIndex("user_index",config,client);
    }

    public static void createIndex(String index, Map<String, String> config,RestHighLevelClient client) throws Exception {
        try {
            CreateIndexRequest request = new CreateIndexRequest(index);
            request.settings(Settings.builder()
                    .put("index.number_of_shards", 1)
                    .put("index.number_of_replicas", 0));

            Map<String, Object> properties = new HashMap<>();
            for (Map.Entry<String, String> entry : config.entrySet()) {
                String propertyName = entry.getKey();
                String type = entry.getValue();
                Map<String, Object> property = new HashMap<>();
                property.put("type", type);
                properties.put(propertyName, property);
            }
            Map<String, Object> mapping = new HashMap<>();
            mapping.put("properties", properties);
            request.mapping(mapping);
           // logger.info("create index success，mapping:  " + mapping);
            // 同步方式发送请求
            CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
            boolean acknowledged = createIndexResponse.isAcknowledged();
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();

        } catch (IOException e) {
            String message = String.format("es high level client (%s) create index failed, message %s.", index,
                    e.getMessage());
            System.out.println(message);
            throw new Exception("create index failed, message" + message);
        }
    }
}
