package FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class FileService {

    private String filePath;
    private List<String[]> data = new ArrayList();
    private FileTypeStrategy fileType;
    private FormatStrategy format;
    
    public FileService(String filePath, FormatStrategy format) {
        this.setFilePath(filePath);
        this.setFormatStrategy(format);
        this.setFileTypeStrategy(format.getFileTypeStrategy());
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        if (fileType != null) {
            fileType.setFileName(filePath);
        }
    }

    public FileTypeStrategy getFileTypeStrategy() {
        return fileType;
    }

    public void setFileTypeStrategy(FileTypeStrategy fts) {
        this.fileType = fts;
        fileType.setFileName(filePath);
    }

    public FormatStrategy getFormatStrategy() {
        return format;
    }

    public void setFormatStrategy(FormatStrategy format) {
        this.format = format;
    }
    
    
    public void dataToFile(List rawData) throws IOException {
        fileType.writeToFile(format.encodeData(rawData));
    }
    
    public List<String[]> dataFromFile() throws IOException {
        data = format.decodeData(fileType.readFromFile());
        return data;
    }
}
