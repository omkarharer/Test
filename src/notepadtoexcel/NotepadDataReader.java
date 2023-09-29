package notepadtoexcel;

import java.io.BufferedReader;
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

public class NotepadDataReader implements IAuto {
	
	 private Workbook workbook;
	 
	 public NotepadDataReader() {
	        // Create a new Excel workbook when the object is constructed.
	        workbook = new XSSFWorkbook();
	    }

	    public void writeDataToExcel(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        int rowNum = 0;
	        for (String[] rowData : data) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataHD(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, HDheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Member ID")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("HD")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataBS(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, BSheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Member Branch Code")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("BS")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataAS(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, ASheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Borrower Office Location Type")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("AS")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataRS(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, RSheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Relationship DUNS Number")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("RS")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataCR(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, CRheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Account Number")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("CR")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataSS(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, SSheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Value of Security")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("SS")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataCD(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, CDheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Date of Dishonour")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("CD")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    
	    public void writeDataTS(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, TSheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Number of Borrower Segments")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("TS")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    public void writeDataGS(List<String[]> data, String excelFilePath, String sheetName) throws IOException {
	        Sheet sheet = workbook.createSheet(sheetName);

	        data.add(0, GSheader);
	        int rowNum1 = 0;
	        for (String[] rowData : data) {
	        	 if (rowData[1].startsWith("Guarantor DUNS Number")) {
	            Row row = sheet.createRow(rowNum1++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }
	        int rowNum = 1;
	        for (String[] rowData : data) {
	        	
	        	 if (rowData[0].startsWith("GS")) {
	            Row row = sheet.createRow(rowNum++);
	            int cellNum = 0;
	            for (String cellValue : rowData) {
	                Cell cell = row.createCell(cellNum++);
	                cell.setCellValue(cellValue);
	            }
	        	 }
	        }

	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	    
	    // Add similar methods for other sheet types as needed.

	    public void saveWorkbook(String excelFilePath) throws IOException {
	        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	            workbook.write(outputStream);
	        }
	    }
	
    public List<String[]> readData(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                data.add(parts);
            }
        }
        return data;
    }
    
    public List<String[]> readDataBS(String filePath, String delimiter) throws IOException 
    {
        List<String[]> data = new ArrayList<>();
        data.add(BSheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("BS")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    //For second value 
    public List<String[]> readDataBSAndSecondValueCR(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("BS")) {
                    data.add(parts);
                } else if (parts.length > 0 && parts[0].startsWith("CR") && parts.length > 1) {
                    // For lines starting with "CR," add only the 2nd value to the data
                    String[] crData = new String[]{parts[1]};
                    data.add(crData);
                }
            }
        }
        return data;
    }
    
    public List<String[]> readDataBSAndSecondValueCR2(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        String[] currentBSLine = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                
                if (parts.length > 0 && parts[0].startsWith("BS")) {
                    // If we have a current "BS" line, add it to the data list
                    if (currentBSLine != null) {
                        data.add(currentBSLine);
                    }
                    currentBSLine = parts; // Set the current "BS" line
                } else if (parts.length > 0 && parts[0].startsWith("CR") && parts.length > 1 && currentBSLine != null) {
                    // Append the "CR" value to the current "BS" line
                    String[] combinedData = new String[currentBSLine.length + 1];
                    System.arraycopy(currentBSLine, 0, combinedData, 0, currentBSLine.length);
                    combinedData[currentBSLine.length] = parts[1];
                    currentBSLine = combinedData;
                }
            }
            
            // Add the last "BS" line if there is one
            if (currentBSLine != null) {
                data.add(currentBSLine);
            }
        }
        
        return data;
    }
    
    public List<String[]> readDataBSAndSecondValueCR3(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        StringBuilder currentCRValues = new StringBuilder(); // To store multiple "CR" values
        String[] currentBSLine = null;

        data.add(BSheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);

                if (parts.length > 0 && parts[0].startsWith("BS")) {
                    // If we have a current "BS" line, add it to the data list
                    if (currentBSLine != null) {
                        // If we have accumulated "CR" values, add them as a single cell
                        if (currentCRValues.length() > 0) {
                            String[] combinedData = new String[currentBSLine.length + 1];
                            System.arraycopy(currentBSLine, 0, combinedData, 0, currentBSLine.length);
                            combinedData[currentBSLine.length] = currentCRValues.toString();
                            data.add(combinedData);
                            currentCRValues.setLength(0); // Reset the CR values
                        } else {
                            data.add(currentBSLine);
                        }
                    }
                    currentBSLine = parts; // Set the current "BS" line
                } else if (parts.length > 0 && parts[0].startsWith("CR") && parts.length > 1 && currentBSLine != null) {
                    // Append the "CR" value to the current "CR" values, separated by a comma
                    if (currentCRValues.length() > 0) {
                        currentCRValues.append(", ");
                    }
                    currentCRValues.append(parts[1]);
                }
            }

            // Add the last "BS" line if there is one
            if (currentBSLine != null) {
                // If we have accumulated "CR" values, add them as a single cell
                if (currentCRValues.length() > 0) {
                    String[] combinedData = new String[currentBSLine.length + 1];
                    System.arraycopy(currentBSLine, 0, combinedData, 0, currentBSLine.length);
                    combinedData[currentBSLine.length] = currentCRValues.toString();
                    data.add(combinedData);
                } else {
                    data.add(currentBSLine);
                }
            }
        }

        return data;
    }



    
    public List<String[]> readDataAS(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        
        data.add(ASheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("AS")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    public List<String[]> readDataRS(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        data.add(RSheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("RS")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    public List<String[]> readDataCR(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        data.add(CRheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("CR")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    public List<String[]> readDataGS(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        data.add(GSheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("GS")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    public List<String[]> readDataSS(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        data.add(SSheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("SS")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    public List<String[]> readDataCD(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        data.add(CDheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("CD")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    public List<String[]> readDataTS(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        data.add(TSheader);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);
                // Check if the first text (parts[0]) starts with "BS"
                if (parts.length > 0 && parts[0].startsWith("TS")) {
                    data.add(parts);
                }
            }
        }
        return data;
    }
    
    public void writeDataToExcel2(List<String[]> data, String excelFilePath,String name) throws IOException {
         workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(name);

        int rowNum = 1;
        for (String[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String cellValue : rowData) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(cellValue);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }
    
    public void writeDataToExcelBS(List<String[]> data, String excelFilePath,String name) throws IOException {
        workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(name);

        int rowNum = 1;
        for (String[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String cellValue : rowData) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(cellValue);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }
    
   
    
    
    
}
