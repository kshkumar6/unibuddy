package com.unibuddy.qa.testCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;
import com.unibuddy.qa.dataProvider.TestDataProvider;
import com.unibuddy.qa.methods.GenericMethods;
import io.restassured.response.Response;

import net.minidev.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchService extends TestDataProvider {
    static GenericMethods genericMethods = new GenericMethods();


    @Test(description = "Search service",dataProvider = "searchService")
    public void getSearchResult(String query,int results_length) throws JsonProcessingException {
        String service = "search_service";
        String payload = genericMethods.createSearchServiceRequestBody(query,results_length);
        Response response = genericMethods.postRequest(service,payload);
        System.out.println(response.asString());
        Assert.assertTrue(response.getStatusCode()==200,"Status code is not 200");
        Assert.assertNotNull(response);
        JSONArray responseArray = JsonPath.read(response.asString(),"$");
        Assert.assertEquals(results_length,responseArray.size());
    }

    @Test(description = "Search service without query length",dataProvider = "searchServiceWithoutLength")
    public void getSearchResultWithoutLength(String query,int max_Length) throws JsonProcessingException {
        String service = "search_service";
        String payload = genericMethods.createSearchServiceRequestBody(query);
        Response response = genericMethods.postRequest(service,payload);
        System.out.println(response.asString());
        Assert.assertTrue(response.getStatusCode()==200,"Status code is not 200");
        Assert.assertNotNull(response);
        JSONArray responseArray = JsonPath.read(response.asString(),"$");
        Assert.assertEquals(responseArray.size(),max_Length);
    }

    @Test(groups = {"Sanity"},dataProvider = "searchWithoutLengthSanity")
    public void searchWithoutLengthSanity(String query,int max_Length) throws JsonProcessingException {
        getSearchResultWithoutLength(query, max_Length);
    }

    @Test(groups = {"Sanity"},dataProvider = "searchWithLengthSanity")
    public void searchWithLengthSanity(String query,int max_Length) throws JsonProcessingException {
        getSearchResultWithoutLength(query, max_Length);
    }

}
