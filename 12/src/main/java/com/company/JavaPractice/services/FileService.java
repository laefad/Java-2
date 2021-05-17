package com.company.JavaPractice.services;

import com.company.JavaPractice.settings.FileSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FileService extends FileWorker {

    @Autowired
    private FileSettings settings;

    private String data;

    @PostConstruct
    private void init() {
        File input = new File(settings.getInputFileName());

        try {
            data = FileService.hashFile(input);
        } catch (IOException e) {
            System.out.println("Input file doesn't exist or something goes wrong");
            data = "null";
        }
    }

    @PreDestroy
    void destroy() {
        File output = new File(settings.getOutputFileName());

        try {
            FileService.writeToFile(output, data);
        } catch (FileNotFoundException e) {
            System.out.println("Output file doesn't exist or something goes wrong");
        }

        File input = new File(settings.getInputFileName());

        if (input.exists())
            input.delete();
    }
}
