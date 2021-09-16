package com.test.serviceStorage.service;

public interface StorageService {

    String getValue(String elementId);
    void setValue(String elementId, String elementValue);
    boolean remove(String elementId);

}
