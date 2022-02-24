package com.example.muzeumfrontendjavafx;

public class Response {
    private int responseCode;
    private String content;

    public Response(int responseCode, String content) {
        this.responseCode = responseCode;
        this.content = content;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getContent() {
        return content;
    }
}
