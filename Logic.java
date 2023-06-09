package Logic;
import java.io.IOException;
import java.util.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import inputs.Input;

class Sections
{
    public String [][] section_table = new String [6][8];
}
class Staff 
{
    public String [][] staff_table = new String [6][8];
    int count=0;
}
public class Logic 
{
    static{try {
        Input.getinput();
    } catch (InvalidFormatException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }}
   
    public static Sections[] section = new Sections[Input.a[0]];
    public static Staff[] staff = new Staff[Input.non_duplicate_staff.size()];
   
    public static final String DEST = "Output/TimeTable.pdf";
    protected void manipulatePdf(String dest,int sec) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);
        // By default column width is calculated automatically for the best fit.
        // useAllAvailableWidth() method makes table use the whole page's width while placing the content.
        
        List<List<List<String>>> largedata = new ArrayList<>();
        for(int i =0;i<sec;i++)
        {   
            List<List<String>> dataset = getData(i);
            largedata.add(dataset);
        }
        AreaBreak ab =new AreaBreak();
        ImageData im = ImageDataFactory.create("C:/Users/munta/Downloads/Telegram Desktop/Time Table Generator/Time Table Generator/GUI/images/smvec.png");
        Image img = new Image(im);
        int h=0;
        for(List<List<String>> data :largedata)
            {Table table = new Table(UnitValue.createPercentArray(9)).useAllAvailableWidth();
               
                Paragraph para = new Paragraph(Input.sheet_names.get(h));
                for (List<String> record : data)
                {
                    for (String field : record)
                        table.addCell(new Cell().add(new Paragraph(field)));
                }
                h++;
                doc.add(img);
                doc.add(para);
                doc.add(table);
                doc.add(ab);
            }
        
        doc.close();
    }

    public static List<List<String>> getData(int sec) {
        List<List<String>> data = new ArrayList<>();
        String[] tableTitleList = {" Day/Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] hour = {"1","2","3","4","5","6","7","8"};
        for (int i = 0; i < 7; i++) {
            List<String> dataLine = new ArrayList<>();
            dataLine.add(tableTitleList[i]);
            for (int j = 0; j < 8; j++) {
                if(i==0)dataLine.add(hour[j]);
                else dataLine.add(section[sec].section_table[i-1][j]);     
            }
            
            data.add(dataLine);
            System.out.println(data);
        }
        return data;
    }
   public static void main (String args[]) throws Exception 
    {

        // Fetch inputs using the inputs package
        
        int tc = Input.a[0];// tc-total no. of classes or the total no. of sheets
        int tr = Input.a[1];// tr-total no.of rows in the data sheet
        

    System.out.println(Input.non_duplicate_staff.size());
        String[] ndsa = (String[]) Input.non_duplicate_staff.toArray(new String[Input.non_duplicate_staff.size()]);
        // Indexor

        Dictionary<String,Integer> staff_index = new Hashtable<>();
        Dictionary<Integer,String> staff_name = new Hashtable<>();
        int ic =0;
        for(int i =0;i<Input.non_duplicate_staff.size();i++)
            {

                if(ndsa[i]== null) continue;
                else
                {
                    staff_index.put(ndsa[ic], ic);
                    staff_name.put(ic,ndsa[ic]);
                    ic++;
                }
            }
        



        for (int i =0;i<Input.non_duplicate_staff.size();i++)
            staff[i] = new Staff();
        
        
        for(int i=0;i<tc;i++)
            section[i] = new Sections();
        
        

        
        Dictionary<String,Integer> dd = new Hashtable<>();
        dd.put("mon", 0);
        dd.put("tue", 1);
        dd.put("wed", 2);
        dd.put("thu", 3);
        dd.put("fri", 4);
        dd.put("sat", 5);
        
        String[] temp1 = Input.Set_of_Practicals[0][9].split(",");
        System.out.println(temp1[0]);
        
    // Practical Assignment
        for(int i =0;i<tc;i++)
            for(int j =0;j<Input.Days[i].length;j++)
            {
                if(Input.Days[i][j]==""||Input.Days[i][j]==null) continue; 
                for(int k =0;k<(int)Input.No_of_hours[i][j];k++)
                {                
                    section[i].section_table[dd.get(Input.Days[i][j])][((int)Input.Start[i][j]-1)+k] =Input.Set_of_Practicals[i][j];
                    String[] temp = Input.Set_of_Practicals[i][j].split(",");
                    for(String l : temp)
                    {  
                        staff[staff_index.get(l)].staff_table[dd.get(Input.Days[i][j])][((int)Input.Start[i][j]-1)+k] = Input.sheet_names.get(i);
                        staff[staff_index.get(l)].count++;
                    }
                }
            }
        
    //OE/PE Assignment
    //format (dept)***_*(year in numbberal)_*(sem in numeral)

    ArrayList<Integer> no_of_secs = new ArrayList<Integer>();
    
        int count1=1;
        for(int i =0;i<tc-1;i++){
            if(Input.sheet_names.get(i).charAt(4)==Input.sheet_names.get(i+1).charAt(4))      
                count1++;
            else{
                no_of_secs.add(count1);
                count1++;
                
            }
        }
        no_of_secs.add(count1);
        System.out.println(no_of_secs);

    
    
    ArrayList<ArrayList<String>> Elective =new ArrayList<>();
    for(int i : no_of_secs){
        ArrayList<String> Each_sec = new ArrayList<>();
        for(int St=0;St<Input.Staff_Name[i-1].length;St++){

            if(Input.Subjects[i-1][St].charAt(5)=='E'){ 
                System.out.println("in");                  
                Each_sec.add(Input.Set_of_Practicals[i-1][St]);
            }
        }
        Elective.add(Each_sec);
    }
    System.out.println(Elective);
    int start =0;
    for(int k =0; k<no_of_secs.size();k++)
    { 
        for(String e : Elective.get(k))
        {
            for(int i =0;i<6;i++)
            {      
                for(int j =0;j<8;j++)
                {                
                    int cunt =0;
                    for(int sec =start;sec<no_of_secs.get(k);sec++)
                    {    
                        if(section[sec].section_table[i][j]==null)
                                cunt++;
                        else break;
                    }
                    if(start !=0)
                    {
                        if(cunt == no_of_secs.get(k)-no_of_secs.get(k-1))
                        {
                            for(int sec =start;sec<no_of_secs.get(k);sec++)
                            {
                                section[sec].section_table[i][j]=e;
                                for(String u : e.split(","))
                                {
                                    staff[staff_index.get(u)].staff_table[i][j]="ELECTIVE";
                                }
                            }
                            break;
                        }
                    }
                    else
                    {
                        if(cunt == no_of_secs.get(k))
                        {
                            for(int sec =start;sec<no_of_secs.get(k);sec++)
                            {
                                section[sec].section_table[i][j]=e;
                                for(String u : e.split(","))
                                {
                                    staff[staff_index.get(u)].staff_table[i][j]="ELECTIVE";
                                    staff[staff_index.get(u)].count++;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        start = no_of_secs.get(k);
    }


 

    // Regular random staff assignment
    


        for(int k =0;k<tc;k++)
        {
            ArrayList<String> random_int = new ArrayList<String>();
            for(int x =0;x<Input.Staff_Name[k].length;x++)
            {
                if(Input.Subjects[k][x].contains("T")){
                    random_int.add(Input.Staff_Name[k][x]);
                    System.out.println(Input.Staff_Name[k][x]);
                }
            }
            
            for(int i =0;i<6;i++)
            {
                for(int j=0;j<8;j++)
                {
                        
                        int si = new Random().nextInt(random_int.size());
                        String ran_temp = random_int.remove(si);
                        int h=0;
                        if(random_int.isEmpty())
                        {
                            System.out.println(h+=1);
                            for(int x =0;x<Input.Staff_Name[k].length;x++)
                                if(Input.Subjects[k][x].contains("T"))
                                    random_int.add(Input.Staff_Name[k][x]);
                        }
                        if(section[k].section_table[i][j] == null)
                        {
                            System.out.println(ran_temp);
                            if(staff[staff_index.get(ran_temp)].staff_table[i][j]==null)
                            {
                                section[k].section_table[i][j] = ran_temp;
                                System.out.println("yes");
                                staff[staff_index.get(ran_temp)].staff_table[i][j]= Input.sheet_names.get(k);
                                staff[staff_index.get(ran_temp)].count+=1;
                            }
                            else
                            {
                                j--;
                            }
                            
                            }

                        }
                }
            }
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Logic().manipulatePdf(DEST,tc);
    }

}
