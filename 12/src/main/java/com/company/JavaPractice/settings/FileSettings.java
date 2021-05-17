package com.company.JavaPractice.settings;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FileSettings {
    @Value("${file.input_name}")
    private String inputFileName;

    @Value("${file.output_name}")
    private String outputFileName;
}
