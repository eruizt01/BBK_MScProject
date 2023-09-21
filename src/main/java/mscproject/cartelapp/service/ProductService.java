package mscproject.cartelapp.service;

import mscproject.cartelapp.repository.ProductRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

import static org.neo4j.driver.Values.parameters;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Driver neo4jDriver;

    @Autowired
    public ProductService(ProductRepository productRepository, Driver neo4jDriver) {
        this.productRepository = productRepository;
        this.neo4jDriver = neo4jDriver;
    }

    public void createProduct(MultipartFile file) {
        try {
            // Save the uploaded file to a temporary location
            File tempFile = new File("temp.xlsx"); // You should put this in a configurable path
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(file.getBytes());
            }

            // Now read the file from the saved location
            try (InputStream inputStream = new FileInputStream(tempFile);
                 Workbook workbook = new XSSFWorkbook(inputStream)) {
                Sheet sheet = workbook.getSheetAt(0);

                // Create a session using the Neo4j driver
                try (Session session = neo4jDriver.session()) {
                    Iterator<Row> rowIterator = sheet.iterator();
                    if (rowIterator.hasNext()) {
                        rowIterator.next(); // Skip header row
                    }

                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        String name = getStringValue(row.getCell(0));
                        String category = getStringValue(row.getCell(1));
                        String SKU = getStringValue(row.getCell(2));

                        try (Transaction tx = session.beginTransaction()) {
                            tx.run("CREATE (p:Product {name: $name, category: $category, sku: $sku})",
                                    parameters("name", name, "category", category, "SKU", SKU));
                            tx.commit();
                        }
                    }
                }
            }
            // Optionally, delete the temporary file if you wish
            // tempFile.delete();
        } catch (Exception e) {
            e.printStackTrace(); // Consider using logging
        }
    }

    private String getStringValue(Cell cell) {
        if (cell != null) {
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString();
                    } else {
                        return String.valueOf((long) cell.getNumericCellValue());
                    }
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return cell.getCellFormula();
                case BLANK:
                    return "";
                default:
                    return ""; // Return an empty string for other unsupported cell types.
            }
        }
        return "";
    }
}

