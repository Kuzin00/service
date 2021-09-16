package com.test.serviceStorage.repository;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ElementsRepository {

    private final Map<String, String> storage = new HashMap<>();

    public Map<String, String> getStorage() {
        return storage;
    }

    public String getValueForId(String elementId) {
        return storage.get(elementId);
    }

    public void setNewElement(String elementId, String elementValue){
        storage.put(elementId, elementValue);
    }

    public void removeElement(String elementId) {
        storage.remove(elementId);
    }

}
