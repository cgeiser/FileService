package FileService;

import java.io.IOException;
import java.util.List;

public interface FileTypeStrategy {
    
    public abstract List readFromFile() throws IOException;
    
    public abstract void writeToFile(List data) throws IOException;

    public void setFileName(String filePath);
    
}