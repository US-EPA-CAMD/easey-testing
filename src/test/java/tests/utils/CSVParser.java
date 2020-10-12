package tests.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVParser {

//    private String fileName;
    private String[] header;
    private List<Map<String, String>> data;

    public CSVParser (String fileName) {
//        this.fileName = fileName;

        CSVReader csv;
        try {
            csv = new CSVReader(new FileReader(fileName));
            List<String[]> data = csv.readAll();
            csv.close();
            if (data.size() > 0) {
                header = data.get(0);
                if (data.size() > 1) {
                    List<Map<String, String>> rowArr = new ArrayList<>();
                    for (int row = 1; row < data.size(); row ++) {
                        Map<String, String> colMap = new HashMap<>();
                        for (int col = 0; col < data.get(row).length; col ++) {
                            colMap.put(header[col], data.get(row)[col]);
                        }
                        rowArr.add(colMap);
                    }
                    this.data = rowArr;
                }
            }
        } catch (IOException e) {
            System.err.println("Invalid file: '" + fileName
                    + "', enter a valid one");
            e.printStackTrace();
        } catch (CsvException e) {
            System.err.println("Invalid csv format for file: '" + fileName
                    + "', please fix the format");
            e.printStackTrace();
        }
    }

    public String[] getHeader() { return header; }

    public List<Map<String, String>> getData() { return data; }

    public static void main(String[] args) {
        CSVParser csv = new CSVParser("/home/yefim/EPACAMD/Testing/src/main/resources/sample/sample.csv");

        String[] header = csv.getHeader();
        List<Map<String, String>> data = csv.getData();

        System.out.print("| ");
        for (String col : header) {
            System.out.print(col);
            System.out.print(" | ");
        }
        System.out.println();
        for (Map<String, String> row: data) {
            System.out.print("| ");
            for (String col : header) {
                System.out.print(row.get(col));
                System.out.print(" | ");
            }
            System.out.println();
        }

    }

}
