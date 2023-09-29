package notepadtoexcel;

import java.io.IOException;
import java.util.List;

public class Upload2 {
	public static void main(String[] args) {
		NotepadDataReader2 n = new NotepadDataReader2();
		
		
		try {
			String inputFilePath = "./data/cibildata.txt"; // Replace with your input file path.
			String excelFilePath = "./data/Cibil.xlsx"; // Replace with your desired Excel file path.
			String delimiter = "\\|"; // Pipe character as the delimiter.

			
			
			List<String[]> data = n.readDataBS(inputFilePath, delimiter);
			n.writeDataToExcel(data, excelFilePath, "BS");
			System.out.println("BS along with CR finished");

			
			 //For AS 
			List<String[]> data2 = n.readDataASAndSecondValueCR3(inputFilePath, delimiter);
			 n.writeDataToExcel(data2, excelFilePath,"AS");
			 
						  
			  // Save the workbook after writing all sheets.
	            n.saveWorkbook(excelFilePath);

			 

			System.out.println("Data successfully transferred to Excel.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
