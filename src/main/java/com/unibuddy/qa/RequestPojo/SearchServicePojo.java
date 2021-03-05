package com.unibuddy.qa.RequestPojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "query",
        "results_length"
})

public class SearchServicePojo {

        @JsonProperty("query")
        private String query;
        @JsonProperty("results_length")
        private Integer resultsLength;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("query")
        public String getQuery() {
            return query;
        }

        @JsonProperty("query")
        public void setQuery(String query) {
            this.query = query;
        }

        @JsonProperty("results_length")
        public Integer getResultsLength() {
            return resultsLength;
        }

        @JsonProperty("results_length")
        public void setResultsLength(Integer resultsLength) {
            this.resultsLength = resultsLength;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        public SearchServicePojo withQuerResLength(String query, int resLength){
            this.query = query;
            this.resultsLength = resLength;
            return this;
        }
    public SearchServicePojo withQuer(String query){
        this.query = query;
        return this;
    }
    }
