package FileService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cgeiser
 */
public class TxtFormat implements FormatStrategy {
    private FileTypeStrategy fts = new TextFileType();
    private final String CRT = "\n";
    
    public TxtFormat() {
    }

    
    @Override
    public List<String> encodeData(List<String[]> rawData) {
        List<String> encodedData = new ArrayList<String>();
        for (String[] listItem : rawData) {
            encodedData.addAll(Arrays.asList(listItem));
            
        }
        return encodedData;
    }

    @Override
    public List<String[]> decodeData(List data) {
        List<String> rawData = (ArrayList)data;
        List<String[]> decodedData = new ArrayList<>();
        for (String s : rawData) {
            String[] listItem = {s};
            decodedData.add(listItem);
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
//        TxtFormat c = new TxtFormat();
//        
//        // encode test
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
//        // decode test
//        
//        List q = new ArrayList();
//        q.add("Terry");
//        q.add("Mulhousen");
//        q.add("23");
//        q.add("Ginny");
//        q.add("Weasly");
//        q.add("21");
//        q.add("Sally");
//        q.add("Fields");
//        q.add("45");
//        
//        List w = new ArrayList(c.decodeData(q));
//        for (Object o : w) {
//            String[] list = (String[]) o;
//            for (int a=0; a<list.length; a++) {
//                System.out.println(list[a]);
//            }
//        }
//    }

   
}
