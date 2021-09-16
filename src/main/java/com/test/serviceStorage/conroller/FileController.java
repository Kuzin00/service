package com.test.serviceStorage.conroller;

import com.test.serviceStorage.service.impl.FileServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class FileController {

    private final FileServiceImpl fileService;
    private static final String EXTERNAL_FILE_PATH = "C:/Users/kuzin/storage.txt";

    @GetMapping("/dump")
    public ResponseEntity<?> dump(){
        final boolean saved = fileService.saveStorage();
        return saved
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/load")
    public ResponseEntity<?> load(){
        final boolean loaded = fileService.loadStorage();
        return loaded
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }



}
