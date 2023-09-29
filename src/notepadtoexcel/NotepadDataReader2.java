package notepadtoexcel;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NotepadDataReader2 implements IAuto {
	
	 private Workbook workbook;
	 
	 public NotepadDataReader2() {
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
	       // System.out.println(data);
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
    
    // for BS along with CR
    public List<String[]> readDataBSAndSecondValueCR3(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        StringBuilder currentCRValues = new StringBuilder(); // To store multiple "CR" values
        String[] currentBSLine = null;

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
    // for AS along with CR
    public List<String[]> readDataASAndSecondValueCR3(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        String[] currentBSLine = null;
        StringBuilder currentCRValues = new StringBuilder(); // To store "CR" values for the current "BS" line

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);

                if (parts.length > 0 && parts[0].startsWith("AS")) {
                    // If we have a current "BS" line, add it to the data list
                    if (currentBSLine != null) {
                        // Append the second "CR" value to the current "BS" line
                        currentBSLine[currentBSLine.length - 1] += ", " + currentCRValues.toString();
                        data.add(currentBSLine);
                        currentCRValues.setLength(0); // Reset the CR values
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
                currentBSLine[currentBSLine.length - 1] += ", " + currentCRValues.toString();
                data.add(currentBSLine);
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

    public static List<String[]> processNotepadData(String fileName, String delimiter) {
   	 List<String[]> dataLines = new ArrayList<>();
        List<String> crValues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
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
    
    
    //Testing 
    public List<String[]> Test(String filePath, String delimiter) throws IOException {
        List<String[]> data = new ArrayList<>();
        List<String> currentASLines = new ArrayList<>(); // To store lines starting with "AS"
        List<String> currentCRValues = new ArrayList<>(); // To store multiple second "CR" values
        StringBuilder block = new StringBuilder();
        boolean insideBlock = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);

                
               
            }
        return data;
    }
    
    
    
}
}
