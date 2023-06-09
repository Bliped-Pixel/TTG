package inputs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashSet;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import GUI.*;

public class Input
{
    public static int a[] = new int[2];
    public static LinkedHashSet<String> non_duplicate_staff = new LinkedHashSet<String>();
    static 
    {

        File file = new File("C:/Users/niran/Desktop/Time Table Generator/Time Table Generator/inputs/data.xlsx");
        //File file = new File("C:/Users/munta/Downloads/Telegram Desktop/Time Table Generator/Time Table Generator/inputs/data.xlsx");
        try (FileInputStream fis = new FileInputStream(file)) {
            try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0) ;
                a[0] = workbook.getNumberOfSheets();
                a[1] = sheet.getLastRowNum();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static double Serial_Nos[][] = new double[a[0]][a[1]];
    public static String Subjects[][] = new String[a[0]][a[1]];
    public static String Staff_Name[][] = new String[a[0]][a[1]]; 
    public static double No_of_hours[][] = new double[a[0]][a[1]];
    public static String Set_of_Practicals[][] = new String[a[0]][a[1]];
    public static String Days[][] = new String[a[0]][a[1]];
    public static double Start[][] = new double[a[0]][a[1]];
    public static Dictionary<Integer,String> sheet_names = new Hashtable<Integer,String>();

public static void getinput() throws FileNotFoundException, IOException, InvalidFormatException
 {
    File file = new File("C:/Users/niran/Desktop/Time Table Generator/Time Table Generator/inputs/data.xlsx");
    //File file = new File("C:/Users/munta/Downloads/Telegram Desktop/Time Table Generator/Time Table Generator/inputs/data.xlsx");
   FileInputStream fis = new FileInputStream(file);
   XSSFWorkbook workbook = new XSSFWorkbook(fis);
   Sheet sheet = workbook.getSheetAt(0) ;
   Row row;
   int column_index_1=0;
   int column_index_2=0;
   int column_index_3=0;
   int column_index_4=0;
   int column_index_5=0;
   int column_index_6=0;
   int column_index_7=0;

   for(int i =0;i<workbook.getNumberOfSheets();i++) 
   {
      sheet = workbook.getSheetAt(i);
      row = sheet.getRow(0);
      sheet_names.put(i,sheet.getSheetName());
   for (Cell cell : row) 
   {
       // Column header names.
       switch (cell.getStringCellValue()) 
       {
           case "Serial No":
            column_index_1 = cell.getColumnIndex();
               break;
            case "Subjects":
                column_index_2 = cell.getColumnIndex();
                break;
            case "Staff Name":
                column_index_3 = cell.getColumnIndex();
                break;
            case "No of Hours":
                column_index_4 = cell.getColumnIndex();
                break;
            case "Set of Practicals":            
                column_index_5 = cell.getColumnIndex();
                break;
            case "Days":
                column_index_6 = cell.getColumnIndex();
                break;
            case "Start":   
                column_index_7 = cell.getColumnIndex();
                break;
       }
    }
    int count = 0;
    
   for (Row r1 : sheet) 
   {
      if(r1.getRowNum()==0) continue;
      Cell c_1 = r1.getCell(column_index_1);
      Serial_Nos[i][count]=c_1.getNumericCellValue();
      count++;
   }
   count=0;
   for (Row r2 : sheet) 
   {
      if(r2.getRowNum()==0) continue;
      Cell c_2 = r2.getCell(column_index_2);
      Subjects[i][count]=c_2.getStringCellValue();
      count++;
   }
   count=0;
   for (Row r3 : sheet) 
   {
      if(r3.getRowNum()==0) continue;
      Cell c_3 = r3.getCell(column_index_3);
      if(c_3==null){count++;
        continue;}
      Staff_Name[i][count]=c_3.getStringCellValue();
      count++;
   }
   count=0;
   for (Row r4 : sheet) 
   {

      if(r4.getRowNum()==0) continue;
      Cell c_4 = r4.getCell(column_index_4);
      if(c_4==null) {count++;
        continue;} 
      No_of_hours[i][count]=c_4.getNumericCellValue();
      count++;
   }
   count=0;
   for (Row r5 : sheet) 
   {
      if(r5.getRowNum()==0) continue;
      Cell c_5 = r5.getCell(column_index_5);
      if(c_5==null) {count++;
       continue;}  
      Set_of_Practicals[i][count]=c_5.getStringCellValue();
      count++;
   }
   count=0;
   for (Row r6 : sheet) 
   {
      if(r6.getRowNum()==0) continue;
      Cell c_6 = r6.getCell(column_index_6);
      if(c_6==null){count++;
       continue;}
      Days[i][count]=c_6.getStringCellValue();
      count++;
   }
   count=0;
   for (Row r7 : sheet) 
   {
      if(r7.getRowNum()==0) continue;
      Cell c_7 = r7.getCell(column_index_7);
      if(c_7==null) {count++;
        continue;} 
      Start[i][count]=c_7.getNumericCellValue();
      count++;
   }

}
for(int x =0;x<Staff_Name.length;x++)
    {
            for(int y =0;y<a[1];y++)
            {
                if(Staff_Name[x][y] == ""||Staff_Name[x][y]==null)
                {
                    for(String e : Set_of_Practicals[x][y].split(","))
                        non_duplicate_staff.add(e);
                }
                non_duplicate_staff.add(Staff_Name[x][y]);
            }
    }
        non_duplicate_staff.remove(null);
        System.out.println(non_duplicate_staff.size());
}
}















