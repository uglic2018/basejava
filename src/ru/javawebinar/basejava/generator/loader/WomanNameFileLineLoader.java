package ru.javawebinar.basejava.generator.loader;

import java.util.ArrayList;
import java.util.List;

public class WomanNameFileLineLoader extends AbstractNameFileLineLoader {
    private final static String NAMES = "config/women_names.txt";

    public WomanNameFileLineLoader() {
        super(NAMES);
    }

    @Override
    public List<String> defaultList() {
        List<String> list = new ArrayList<>();
        list.add("Анна");
        list.add("Василиса");
        list.add("Наталья");
        list.add("Ольга");
        return list;
    }
}
