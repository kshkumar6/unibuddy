package com.unibuddy.qa.RequestPojo;


import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "book_id"
})
public class AuthorServicePojo {

        @JsonProperty("book_id")
        private Integer bookId;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("book_id")
        public Integer getBookId() {
            return bookId;
        }

        @JsonProperty("book_id")
        public void setBookId(Integer bookId) {
            this.bookId = bookId;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
        public AuthorServicePojo withBookId(Integer bookId){
        this.bookId = bookId;
        return this;
    }
}
