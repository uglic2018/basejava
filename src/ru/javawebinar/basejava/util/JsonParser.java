package ru.javawebinar.basejava.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.Writer;
import java.util.EnumMap;
import java.util.Map;

public class JsonParser {
    private static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Map.class, new JsonMapAdapter<EnumMap>())
            .create();

    public static <T> T read(Reader reader, Class<T> clazz) {
        return GSON.fromJson(reader, clazz);
    }

    public static <T> void write(T object, Writer writer) {
        GSON.toJson(object, writer);
    }
}