package mscproject.cartelapp.service;

import mscproject.cartelapp.repository.ProductRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
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

    public void createProduct() {
        try {
            FileInputStream file = new FileInputStream("/Users/ERT/Desktop/ProductBook.xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            // Create a session using the Neo4j driver.
            try (Session session = neo4jDriver.session()) {
                // Skip the header row (assuming it's the first row)
                Iterator<Row> rowIterator = sheet.iterator();
                if (rowIterator.hasNext()) {
                    rowIterator.next(); // Skip the first row (header)
                }

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    String name = getStringValue(row.getCell(0));
                    String category = getStringValue(row.getCell(1));
                    String sku = getStringValue(row.getCell(2));

                    // Use a transaction to create the node for each row of data.
                    try (Transaction tx = session.beginTransaction()) {
                        tx.run("CREATE (p:Product {name: $name, category: $category, sku: $sku})",
                                parameters("name", name, "category", category, "sku", sku));
                        tx.commit();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

