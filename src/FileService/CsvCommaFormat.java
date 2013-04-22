package FileService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgeiser
 */
public class CsvCommaFormat implements FormatStrategy {
    private FileTypeStrategy fts = new TextFileType();
    private final String DELIMITER = ",";
    private final String CRT = "\n";
    
    public CsvCommaFormat() {
    
    }

    
    @Override
    public List<String> encodeData(List<String[]> rawData) {
        List<String> encodedData = new ArrayList<String>();
        for (String[] listItem : rawData) {
            StringBuilder tempData = new StringBuilder();
            for (int a=0; a < listItem.length; a++) {
                tempData.append(listItem[a]);
                tempData.append(DELIMITER);
            }
            tempData.deleteCharAt(tempData.length()-1);
            encodedData.add(tempData.toString());
        }
        return encodedData;
    }

    @Override
    public List<String[]> decodeData(List data) {
        List<String> rawData = (ArrayList)data;
        List<String[]> decodedData = new ArrayList<>();
        for (String listItem : rawData) {
            decodedData.add(listItem.split(DELIMITER));
        }
        return decodedData;
    }

    @Override
    public FileTypeStrategy getFileTypeStrategy() {
        return fts;
    }
    
    
    
    
    
    
    // TEST CODE
//    public static void main(String[] args)  {
//    
//        CsvCommaFormat c = new CsvCommaFormat();
//        
//        // encode
//        
//        List l = new ArrayList();
//        String[] a1 = {"Terry", "Munchkin", "36"};
//        l.add(a1);
//        String[] a2 = {"Michael", "Buble", "44"};
//        l.add(a2);
//        String[] a3 = {"Ginny", "Weasley", "22"};
//        l.add(a3);
//        
//        List<String> l2 = c.encodeData(l);
//        for (String s : l2) {
//            System.out.println(s);
//        }
//        System.out.println(l2.size());
//
//        
//        // decode
//        
//        List q = new ArrayList();
//        q.add("Terry,Mulhousen,23");
//        q.add("Ginny,Weasly,21");
//        q.add("Sally,Fields,45");
//        
//        List w = new ArrayList(c.decodeData(q));
//        for (Object o : w) {
//            String[] list = (String[]) o;
//            for (int a=0; a<list.length; a++) {
//                System.out.println(list[a].toString());
//            }
//        }
//        
//    }

   
}
