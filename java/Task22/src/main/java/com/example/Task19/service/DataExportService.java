package com.example.Task19.service;

import com.example.Task19.Market;
import com.example.Task19.MarketRepository;
import com.example.Task19.Product;
import com.example.Task19.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class DataExportService {

    private static final Logger logger = LoggerFactory.getLogger(DataExportService.class);

    private final MarketRepository marketRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DataExportService(MarketRepository marketRepository, ProductRepository productRepository) {
        this.marketRepository = marketRepository;
        this.productRepository = productRepository;
    }

    @Scheduled(fixedRate = 1800000) // Метод будет вызываться каждые 30 минут
    public void exportDataAndClearDirectory() {
        // Очистка директории
        clearDirectory();

        // Создание файла для рынков и загрузка данных из базы данных
        List<Market> markets = marketRepository.findAll();
        createAndExportData("markets.txt", markets);

        // Создание файла для продуктов и загрузка данных из базы данных
        List<Product> products = productRepository.findAll();
        createAndExportData("products.txt", products);

        logger.info("Data export completed successfully.");
    }

    private void clearDirectory() {
        try {
            File directory = new ClassPathResource("data").getFile();
            if (!directory.exists()) {
                directory.mkdirs();
            } else {
                for (File file : directory.listFiles()) {
                    file.delete();
                }
            }
        } catch (IOException e) {
            logger.error("Failed to clear directory: {}", e.getMessage());
        }
    }

    private void createAndExportData(String fileName, List<?> dataList) {
        File file = new File(getClass().getClassLoader().getResource("data/" + fileName).getFile());
        try (FileWriter writer = new FileWriter(file)) {
            for (Object data : dataList) {
                writer.write(data.toString() + "\n");
            }
        } catch (IOException e) {
            logger.error("Failed to export data to file {}: {}", fileName, e.getMessage());
        }
    }
}
