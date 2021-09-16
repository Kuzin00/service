package com.test.serviceStorage.conroller;

import com.test.serviceStorage.service.impl.StorageServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class StorageController {

    private final StorageServiceImpl storageService;

    @GetMapping("/get/{elementId}")
    public String getValue(@PathVariable String elementId){
        return storageService.getValue(elementId);
    }

    @PostMapping("/set/{elementId}")
    public ResponseEntity<?> setValue(@PathVariable String elementId, @RequestBody String elementValue){
         storageService.setValue(elementId, elementValue);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{elementId}")
    public ResponseEntity<?> remove(@PathVariable String elementId) {
        final boolean deleted = storageService.remove(elementId);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "Неверный ID";
    }
}
