package com.example.task12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileProcessor {

    private final String inputFile;
    private final String outputFile;

    public FileProcessor(@Value("${input.file}") String inputFile,
                         @Value("${output.file}") String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @PostConstruct
    public void init() {
        try {
            File input = new File(inputFile);
            File output = new File(outputFile);

            if (!input.exists()) {
                // Если первый файл отсутствует, создаем второй файл и записываем в него строку "null"
                output.createNewFile();
                try (PrintWriter writer = new PrintWriter(output)) {
                    writer.println("null");
                }
            } else {
                // Читаем данные из первого файла, хешируем и записываем во второй файл
                String data = readDataFromFile(input);
                String hashedData = hashData(data);
                writeDataToFile(output, hashedData);
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void cleanUp() {
        // При остановке приложения удаляем исходный файл
        File input = new File(inputFile);
        input.delete();
    }

    private String readDataFromFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }
    }

    private void writeDataToFile(File file, String data) throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(data);
        }
    }

    private String hashData(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hash) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}