package com.example.muzeumfrontendjavafx;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class MuzeumApi {
    public static final String BASE_URL = "http://localhost:8000";
    private static final String FESTMENY_API_URL = BASE_URL + "/api/paintings";
    private static final String SZOBOR_API_URL = BASE_URL + "/api/statues";

    public static List<Festmeny> getFestmenyek()throws IOException{
        Response response = RequestHandler.get(FESTMENY_API_URL);
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
        Response response = RequestHandler.get(SZOBOR_API_URL);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Szobor>>(){}.getType();
        return jsonConvert.fromJson(json, type);
    }

    public static boolean festmenyTorlese(int id) throws IOException {
        Response response = RequestHandler.delete(FESTMENY_API_URL + "/" + id);

        Gson jsonConvert = new Gson();
        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return response.getResponseCode() == 204;
    }

    public static boolean szoborTorlese(int id) throws IOException {
        Response response = RequestHandler.delete(SZOBOR_API_URL + "/" + id);

        Gson jsonConvert = new Gson();
        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return response.getResponseCode() == 204;
    }

    public static Festmeny festmenyHozzaadasa(Festmeny ujFestmeny) throws IOException {
        Gson jsonConvert = new Gson();
        String festmenyJson =  jsonConvert.toJson(ujFestmeny);
        Response response = RequestHandler.post(FESTMENY_API_URL, festmenyJson);

        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json,Festmeny.class);
    }

    public static Szobor szoborHozzaadasa(Szobor ujSzobor) throws IOException {
        Gson jsonConvert = new Gson();
        String szoborJson =  jsonConvert.toJson(ujSzobor);
        Response response = RequestHandler.post(SZOBOR_API_URL, szoborJson);

        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json,Szobor.class);
    }

    public static Festmeny festmenyModositas(Festmeny modositando) throws IOException {
        Gson jsonConvert = new Gson();
        String festmenyJson =  jsonConvert.toJson(modositando);
        Response response = RequestHandler.put(FESTMENY_API_URL + "/" + modositando.getId(), festmenyJson);

        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json,Festmeny.class);
    }

    public static Szobor szoborModositas(Szobor modositando) throws IOException {
        Gson jsonConvert = new Gson();
        String szoborJson =  jsonConvert.toJson(modositando);
        Response response = RequestHandler.put(SZOBOR_API_URL + "/" + modositando.getId(), szoborJson);

        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json,Szobor.class);
    }
}
