package com.unibuddy.qa.testCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;
import com.unibuddy.qa.dataProvider.TestDataProvider;
import com.unibuddy.qa.methods.GenericMethods;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorService extends TestDataProvider {
    static GenericMethods genericMethods = new GenericMethods();

    @Test(description = "Author service",dataProvider = "authorService")
    public void getAuthorSearchResult(int bookId, String author) throws JsonProcessingException {
        String service = "author_service";
        String payload = genericMethods.createAuthorServiceRequestBody(bookId);
        Response response = genericMethods.postRequest(service,payload);
        System.out.println(response.asString());
        Assert.assertTrue(response.getStatusCode()==200,"Status code is not 200");
        Assert.assertNotNull(response);
        Assert.assertEquals(JsonPath.read(response.asString(),"$.author"),author);
        Assert.assertEquals(JsonPath.read(response.asString(),".id").toString().substring(1,2),String.valueOf(bookId));
    }

    @Test(groups = {"Sanity"},dataProvider = "authorSanity")
    public void authorServiceSanity(int bookId, String author) throws JsonProcessingException {
        getAuthorSearchResult(bookId,author);
    }
}
