package ru.javawebinar.basejava.storage;

import java.nio.file.Paths;

public class PathStorageTest extends AbstractArrayStorageTest {
    public PathStorageTest() {
        super(new PathStorage(Paths.get(STORAGE_DIR), new SerializableStorageStrategy()));
    }
}