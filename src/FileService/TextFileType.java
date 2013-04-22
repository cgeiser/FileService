package FileService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgeiser
 */
public class TextFileType implements FileTypeStrategy {
    private String fileName;
    
    public TextFileType() {
        
    }
    
    public TextFileType(String fileName) {
        this.setFileName(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public List readFromFile() throws IOException {
        BufferedReader in = null;
        List records = new ArrayList();
        
        try { 
	   in = new BufferedReader(new FileReader(fileName));
	   String line = in.readLine();
	   while(line != null){
               
               records.add(line);
               
           line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        return records;
    }
    
    @Override
    public void writeToFile(List data) throws IOException {
        boolean append = false;
        
        PrintWriter out = new PrintWriter(
                                        new BufferedWriter(
					new FileWriter(fileName, append)));
        
        for (Object o : data) {
            out.print(o + "\n");
        }
        out.close();
    }
    
    
    // TEST CODE
//    public static void main(String[] args) throws IOException {
//        FileTypeStrategy c = new TextFileType(File.separatorChar + "Users" + 
//                File.separatorChar + "chrisgeiser" + 
//                File.separatorChar + "Desktop" + 
//                File.separatorChar + "temp" + File.separatorChar 
//          + "numtest2.csv");
//        
//        try {
//        List r = new ArrayList(c.readFromFile());
//        System.out.println(r);
//        } catch (IOException ioe) {
//            System.out.println(ioe);
//        }
        
//        List l = new ArrayList();
//        l.add("Terry,Munchkin,36");
//        l.add("Michael,Buble,44");
//        l.add("Ginny,Weasley,22");
//        try {
//            c.writeFile(l);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
