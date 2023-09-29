package notepadtoexcel;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoUpload {
	
    public static List<String[]> processNotepadData(String fileName) {
        List<String[]> dataLines = new ArrayList<>();
        List<String> crValues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");
                dataLines.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dataLines.size(); i++) {
            String[] fields = dataLines.get(i);

            if (fields[0].equals("CR")) {
                crValues.add(fields[2]);
            } else {
                String crValue = String.join(",", crValues);
                fields[1] = fields[1] + "," + crValue;
            }
        }

        return dataLines;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "./data/cibildata.txt"; // Replace with your file path
        List<String[]> processedData = processNotepadData(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("BS");
        int rowNum = 1;
        for (String[] rowData : processedData) {
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String cellValue : rowData) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(cellValue);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("./data/Cibil.xlsx")) {
            workbook.write(outputStream);
        }
        System.out.println("Data successfully tranfered");
        
    }
}
