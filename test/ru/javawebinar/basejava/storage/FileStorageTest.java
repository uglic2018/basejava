package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.storage.strategy.ObjectStreamStorageStrategy;

import java.io.File;

public class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() {
        super(new FileStorage(new File(STORAGE_DIR), new ObjectStreamStorageStrategy()));
    }
}