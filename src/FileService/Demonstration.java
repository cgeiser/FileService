package FileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Demonstration {

    public static void main(String[] args) {
        
        String filePath =
                File.separatorChar + "Users" + 
                File.separatorChar + "chrisgeiser" + 
                File.separatorChar + "Desktop" + 
                File.separatorChar + "temp" + File.separatorChar +
                "test2.txt";
                
        FormatStrategy format = new TxtFormat();
        
        FileService fs = new FileService(filePath, format);
        
        // try reading data from file
        List<String[]> data = new ArrayList<>();
        try {
            data = fs.dataFromFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        for (String[] array : data) {
            for (int a=0; a<array.length; a++) {
                System.out.println(array[a]);
            }
        }
        
        
        
        // try writing data to file
//        List<String[]> l = new ArrayList<>();
//        String[] a1 = {"Terry", "Munchkin", "36"};
//        l.add(a1);
//        String[] a2 = {"Lisa", "Grady", "19"};
//        l.add(a2);
//        String[] a3 = {"Christine", "Young", "22"};
//        l.add(a3);
//        
//        try {
//            fs.dataToFile(l);
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
        
    }
}
