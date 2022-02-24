package com.example.muzeumfrontendjavafx;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class MuzeumApi {
    public static final String BASE_URL = "http://localhost:8000";
    private static final String GET_FESTMENY = BASE_URL + "/api/paintings";
    private static final String GET_SZOBOR = BASE_URL + "/api/statues";

    public static List<Festmeny> getFestmenyek()throws IOException{
        Response response = RequestHandler.get(GET_FESTMENY);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Festmeny>>(){}.getType();
        return jsonConvert.fromJson(json, type);
    }

    public static List<Szobor> getSzobrok()throws IOException{
        Response response = RequestHandler.get(GET_SZOBOR);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Szobor>>(){}.getType();
        return jsonConvert.fromJson(json, type);
    }


}
