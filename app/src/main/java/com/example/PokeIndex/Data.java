package com.example.PokeIndex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("count")
    private Integer count;
    @SerializedName("previous")
    private Object previous;
    @SerializedName("results")
    private List<Pokemon> results = null;
    @SerializedName("next")
    private String next;

    public Integer getCount() {
        return count;
    }
    public Object getPrevious() {
        return previous;
    }
    public List<Pokemon> getResults() {
        return results;
    }
    public String getNext() {
        return next;
    }
    public class Pokemon {
        @SerializedName("url")
        private String url;
        @SerializedName("name")
        private String name;

        public String getUrl() {
            return url;
        }
        public String getName() {
            return name;
        }

    }

}