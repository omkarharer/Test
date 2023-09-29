package notepadtoexcel;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test implements IAuto{
    public static void main(String[] args) {
        String filePath = inputFilePath;
        String delimiter = "\\|"; // Pipe character as the delimiter.
        List<String[]> data = new ArrayList<>();
        List<String[]> blocks = new ArrayList<>();
        //List<String> currentCRValues = new ArrayList<>(); // To store multiple second "CR" values
        String secondValue;
        StringBuilder finalsecondValueBuilder = new StringBuilder();
        boolean insideBlock = false;
       
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            
            line = br.readLine();
            String[] parts1 = line.split(delimiter);
            blocks.add(parts1);

            while ((line = br.readLine()) != null) {
            	 String[] parts = line.split(delimiter);
                if (parts.length > 0 && parts[0].startsWith("BS") && !insideBlock) {
                    insideBlock = true;
                    blocks.add(parts); // Add the starting line to the block
                } else if (parts.length > 0 && parts[0].startsWith("BS") && insideBlock) {
                    insideBlock = false;
//                   data.addAll(blocks.stream()
//                    	    .map(element -> new String[]{element})
//                    	    .collect(java.util.stream.Collectors.toList())); // Add the completed block to the main list
//                    
                    //NEW
                    for(int i=0; i<blocks.size(); i++)
                    {
                    	 String[] block = blocks.get(i);
                    	if(block.length > 0 && block[0].startsWith("CR"))
                    	{
                    		secondValue = block[1];
                            // Concatenate the second value to the existing list
                            if (finalsecondValueBuilder.length() > 0) {
                                finalsecondValueBuilder.append(",");
                            }
                            finalsecondValueBuilder.append(secondValue);
                    		 
                    	}
                    	
                    }
                    String finalSecondValue = finalsecondValueBuilder.toString();
                    
                    for(int i=0 ;i<blocks.size(); i++)
                    {
                    	String[] block = blocks.get(i);

                    	if(block[0].startsWith("BS"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[28];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 28);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[27] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    	
                    	if(block[0].startsWith("AS"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[18];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 18);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[17] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    	
                    	if(block[0].startsWith("RS"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[40];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 40);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[39] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    	
                    	if(block[0].startsWith("CR"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[46];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 46);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[45] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    	
                    	if(block[0].startsWith("GS"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[39];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 39);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[38] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    	
                    	if(block[0].startsWith("SS"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[8];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 8);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[7] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    	
                    	if(block[0].startsWith("CD"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[9];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 9);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[8] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    	
                    	if(block[0].startsWith("TS"))
                    	{
                        // Create a new array to hold the updated elements (length 14)
                        String[] updatedBlock = new String[5];

                        // Copy the original elements to the updatedBlock array, up to the length of the original block or 14, whichever is smaller
                        int copyLength = Math.min(block.length, 5);
                        System.arraycopy(block, 0, updatedBlock, 0, copyLength);

                        // Add finalSecondValue as the 14th element
                        updatedBlock[4] = finalSecondValue;

                        // Replace the element in the blocks list with the updated block
                        blocks.set(i, updatedBlock);
                    	}
                    }
                    //NEW
                    
                   data.addAll(blocks.stream()
                           .collect(Collectors.toList()));

                        
                    blocks.clear(); // Clear the 'blocks' list for the next block
                    // Clear the contents of finalsecondValueBuilder for the next stage
                    finalsecondValueBuilder.setLength(0);
                    blocks.add(parts);
                    insideBlock = true;
                }

                if (insideBlock) {
                	if(parts.length > 0 && !parts[0].startsWith("BS"))
                	{
                		 blocks.add(parts);
                	}
                	
                }
            }

            br.close();

            // Now, 'data' list contains all the blocks starting with "BS" and ending with the next "BS"

            // You can process the blocks as needed, for example, printing them:
            NotepadDataReader n = new NotepadDataReader();
           // n.writeDataToExcel(data,"./data/Cibiltest.xlsx", "line");
            n.writeDataHD(data, writeexcel, "HD");
            n.writeDataBS(data, writeexcel, "BS");
            n.writeDataAS(data, writeexcel, "AS");
            n.writeDataRS(data, writeexcel, "RS");
            n.writeDataCR(data, writeexcel, "CR");
            n.writeDataGS(data, writeexcel, "GS");
            n.writeDataSS(data, writeexcel, "SS");
            n.writeDataCD(data, writeexcel, "CD");
            n.writeDataTS(data, writeexcel, "TS");
            
            n.saveWorkbook(writeexcel);
//            for (String[] blockData : data) {
//                for (String element : blockData) {
//                    System.out.println(element);
//                }
//            }
            System.out.println("Data uploaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
