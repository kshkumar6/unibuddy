package com.unibuddy.qa.methods;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.unibuddy.qa.RequestPojo.AuthorServicePojo;
import com.unibuddy.qa.RequestPojo.SearchServicePojo;
import com.unibuddy.qa.base.BaseClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GenericMethods extends BaseClass{

    AuthorServicePojo authorServicePojo;
    SearchServicePojo searchServicePojo;


    public Response getRequest(String url){
        RestAssured.baseURI = prop.getProperty("baseUrl");
        RequestSpecification httpRequest = RestAssured.given();
        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Content-Type","application/json");
        httpRequest.log().all();
        Response response = httpRequest.headers(requestHeaders).get();
        return response;
    }

    public String createSearchServiceRequestBody(String query, int results_length) throws JsonProcessingException {
        searchServicePojo = new SearchServicePojo();
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(searchServicePojo.withQuerResLength(query,results_length));
        return payload;
    }

    public String createSearchServiceRequestBody(String query) throws JsonProcessingException {
        searchServicePojo = new SearchServicePojo();
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(searchServicePojo.withQuer(query));
        return payload;
    }

    public String createAuthorServiceRequestBody(int bookId) throws JsonProcessingException {
        authorServicePojo = new AuthorServicePojo();
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(authorServicePojo.withBookId(bookId));
        return payload;
    }

    public Response postRequest(String service,String payload) throws JsonProcessingException {
        RequestSpecification httpRequest=null;
        Response response=null;
        Map<String, String> requestHeaders = new HashMap<String, String>();

        if(!prop.getProperty("baseUrl").equals("localhost")){
            RestAssured.baseURI = prop.getProperty("baseUrl");
        }
        requestHeaders.put("Content-Type","application/json");
        if(prop.getProperty("baseUrl").equals("localhost")){
            httpRequest = RestAssured.given()
                    .port(Integer.parseInt(prop.getProperty(service)))
                    .headers(requestHeaders)
                    .body(payload);
            httpRequest.log().all();
             response= httpRequest.post();
        }
        else{
            httpRequest = RestAssured.given()
                    .baseUri(prop.getProperty("baseUrl"))
                    .port(Integer.parseInt(prop.getProperty(service)))
                    .headers(requestHeaders)
                    .body(payload);
            httpRequest.log().all();
            response = httpRequest.post(prop.getProperty("path"));
        }
        return  response;
    }
}
