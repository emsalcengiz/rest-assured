package com.emsalcengiz.odmbapi;
import java.util.HashMap;
import java.util.Map;


public class Query {

    private final Map<String, String> queryMap = new HashMap<>(6);


    private Query(Builder builder) {
        queryMap.put("t", builder.title);
        queryMap.put("i", builder.imdbID);
        queryMap.put("type", builder.type);
        queryMap.put("y", builder.year);
        queryMap.put("page", builder.page);
    }


    public Map<String, String> getQueryMap() {
        return queryMap;
    }



    public static class Builder {

        private String title = "";
        private String imdbID = "";
        private String type = "";
        private String year = "";
        private String page = "";

        public Builder(String query) {
            if (query.startsWith("tt")) {
                this.imdbID = query;
            } else {
                this.title = query;
            }
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder imdbID(String imdbID) {
            this.imdbID = imdbID;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder page(String page) {
            this.page = page;
            return this;
        }

        public Query build() {
            return new Query(this);
        }

    }

}