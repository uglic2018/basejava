package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    static final int STORAGE_LIMIT = 10_000;
    static final String ERROR_MESSAGE_OVERFLOW = "Storage overflow";

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected Resume getStorageElement(Object key) {
        return storage[((Integer) key).intValue()];
    }

    @Override
    protected void setStorageElement(Object key, Resume resume) {
        storage[((Integer) key).intValue()] = resume;
    }

    @Override
    protected void doDeleteElement(Object key) {
        reorder(((Integer) key).intValue());
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void doSaveElement(Object key, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException(ERROR_MESSAGE_OVERFLOW, resume.toString());
        }
        storage[reorder(((Integer) key).intValue())] = resume;
        size++;
    }

    /**
     * Reorder storage before add and delete operations.
     * Return index at which need to insert new resume
     * (for addition) or any other value (for deletion).
     * If index below zero (resume absent) - addition.
     * If index above or equal zero (exists) - deletion.
     *
     * @param index getIndex() value before reorder.
     * @return index to insert new resume (for addition)
     */
    protected abstract int reorder(int index);

    protected boolean isKeyExists(Object key) {
        return (((Integer) key).intValue() >= 0);
    }
}