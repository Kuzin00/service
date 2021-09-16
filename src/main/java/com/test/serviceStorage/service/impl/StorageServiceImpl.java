package com.test.serviceStorage.service.impl;

import com.test.serviceStorage.repository.ElementsRepository;
import com.test.serviceStorage.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final ElementsRepository repository;

    public String getValue(String elementId) {
        String value = repository.getValueForId(elementId);
        if (value == null) throw new IllegalArgumentException();
        return value;
    }

    public void setValue(String elementId, String elementValue) {
        repository.setNewElement(elementId, elementValue);
    }

    public boolean remove(String elementId) {
        final boolean elementRemoved = true;
        String value = repository.getValueForId(elementId);
        repository.removeElement(elementId);
        return value == null ? !elementRemoved : elementRemoved;
    }

}
