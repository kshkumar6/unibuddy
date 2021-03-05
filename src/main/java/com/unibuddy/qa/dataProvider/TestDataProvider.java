package com.unibuddy.qa.dataProvider;

import org.testng.annotations.DataProvider;


public class TestDataProvider
{
    @DataProvider(name = "searchService")
    public Object[][] searchService(){
        return new Object[][]{
                {"brain creativity mirror",2},
               {"we extra example",1},
               {"great you from",3}
        };
    }

    @DataProvider(name = "searchWithLengthSanity")
    public Object[][] searchWithLengthSanity(){
        return new Object[][]{
                {"brain creativity mirror",2}
        };
    }

    @DataProvider(name = "authorService")
    public Object[][] authorService(){
        return new Object[][]{
                {1,"Grant Cardone"},
                {2,"Anna Quindlen"},
                {3,"James Webb Young"}
        };
    }
    @DataProvider(name = "authorSanity")
    public Object[][] authorSanity(){
        return new Object[][]{
                {1,"Grant Cardone"}
        };
    }

    @DataProvider(name = "searchServiceWithoutLength")
    public Object[][] searchServiceWithoutLength(){
        return new Object[][]{
                {"we extra example",13},
                { "brain creativity mirror",2},
                {"easy thinking at",12},
                {"great you from",33},
                {"is his at",45},
                {"skills three better",55},
                {"Skills",4},
                {"Book not found",55},
                {"12345",0}
        };
    }
    @DataProvider(name = "searchWithoutLengthSanity")
    public Object[][] searchWithoutLengthSanity() {
        return new Object[][]{
                {"we extra example", 13}
        };
    }
}
