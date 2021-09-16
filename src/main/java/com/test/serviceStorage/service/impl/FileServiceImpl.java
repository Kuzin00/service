package com.test.serviceStorage.service.impl;

import com.test.serviceStorage.repository.ElementsRepository;
import com.test.serviceStorage.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
    private final ElementsRepository repository;
    private static final String EXTERNAL_FILE_PATH = "C:/Users/kuzin/storage.txt";

    @Override
    public boolean saveStorage() {
        File file = new File(EXTERNAL_FILE_PATH);
        final boolean fileSaved = true;

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, String> entry:
                 repository.getStorage().entrySet()) {

                bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            return fileSaved;

        } catch (IOException e) {
            e.printStackTrace();
            return !fileSaved;
        }

    }

    @Override
    public boolean loadStorage() {
        String line;
        final boolean fileLoaded = true;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(EXTERNAL_FILE_PATH));
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(":");
                String key = parts[0];
                String value = parts[1];
                repository.getStorage().put(key, value);

            }

            return fileLoaded;

        } catch (IOException e) {
            e.printStackTrace();
            return !fileLoaded;
        }

    }
}
