package FileService;

import java.util.List;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public interface FormatStrategy {

    public abstract List<String> encodeData(List<String[]> rawData);
    
    public abstract List<String[]> decodeData(List<String> rawData);
    
    public abstract FileTypeStrategy getFileTypeStrategy();
    
}
