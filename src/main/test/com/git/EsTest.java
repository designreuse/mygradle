package com.git;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.nd4j.shade.jackson.databind.ObjectMapper;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EsTest {
    public static void main(String... arg) throws Exception {

        TransportAddress address =
                new InetSocketTransportAddress(
                        InetAddress.getByName("10.10.10.6"), 9300);


        Client client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(address);

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user", "kimchy");
        json.put("postDate", new Date());
        json.put("message", "trying out Elasticsearch");

        // instance a json mapper
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

        GetRequestBuilder get = client.prepareGet("instestdb_business_log-2017.09", "instestdb_business_log", "AV7KHPMIDF9uyeK_lXjy");

        GetResponse response = get.get();
        System.out.println(response);

        MultiMatchQueryBuilder qb1 = QueryBuilders.multiMatchQuery("error", "LEVEL");
        SearchResponse reseponse2 = client.prepareSearch("instestdb_business_log-2017.09").setTypes("instestdb_business_log")
                .setQuery(qb1).execute().actionGet();

        SearchHits hits = reseponse2.getHits();
        System.out.println(hits.totalHits);

        if (hits.totalHits > 0) {
            SearchHit[] searchHits = hits.getHits();
            for (int i = 0; i < 1; i++) {
                Map<String, Object> source = searchHits[i].getSource();

                source.forEach((key, value) -> {
                    System.out.println(key + ": " + value);
                });


            }
        }

        System.out.println("---------------------------------");

        //添加数据
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
                .field("user", "kimchy")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
                .endObject();
      System.out.println(builder.string());

        IndexResponse response3 = client.prepareIndex("mytest", "test")
                .setSource(builder).get();

     System.out.println(response3.toString());

     //



    }

}
