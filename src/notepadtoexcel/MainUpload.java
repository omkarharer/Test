package notepadtoexcel;

import java.io.IOException;
import java.util.List;

public class MainUpload implements IAuto {
	public static void main(String[] args) {
		NotepadDataReader n = new NotepadDataReader();
		
		
		try {
			

			
			List<String[]> data = n.readDataBS(inputFilePath, delimiter);
			n.writeDataToExcel(data, excelFilePath, "BS");

			
			 //For AS 
			List<String[]> data2 = n.readDataAS(inputFilePath, delimiter);
			 n.writeDataToExcel(data2, excelFilePath,"AS");
			 
			// for RS
			
			  List<String[]> data3 = n.readDataRS(inputFilePath, delimiter);
			  n.writeDataToExcel(data3, excelFilePath,"RS");
			  
			  //for CR  
			  List<String[]> data4 = n.readDataCR(inputFilePath, delimiter);
			  n.writeDataToExcel(data4, excelFilePath,"CR");
			  
			  //for GS 
//			  List<String[]> data5 = n.readDataGS(inputFilePath, delimiter);
//			 n.writeDataToExcel(data5, excelFilePath,"GS");
			  
			  //For SS 
			 List<String[]> data6 = n.readDataSS(inputFilePath, delimiter);
			  n.writeDataToExcel(data6, excelFilePath,"SS");
			  
			  //For CD 
			  List<String[]> data7 = n.readDataCD(inputFilePath, delimiter);
			  n.writeDataToExcel(data7, excelFilePath,"CD");
			  
			  //For TS 
			  List<String[]> data8 = n.readDataTS(inputFilePath, delimiter);
			  n.writeDataToExcel(data8, excelFilePath,"TS");
			  
			  // Save the workbook after writing all sheets.
	            n.saveWorkbook(excelFilePath);

			 

			System.out.println("Data successfully transferred to Excel.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
