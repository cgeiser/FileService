package FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileService class allows reading and writing of different file types.
 * FileTypeStrategy is an interchangable interface depending on the type of
 * data stream...text or binary.  FormatStrategy is an interchangable interface
 * that contains the encoding and decoding instructions for specific file
 * formats...csv, txt, custom, etc.  A default FileTypeStrategy is part of
 * each FormatStrategy.
 * 
 * FileService accepts and returns an ArrayList<String[]>.
 * 
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

    /**
     * Returns the filePath.
     * @return String filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the filePath.  Also sets it in the FileTypeStrategy only if it
     * is being changed.
     * @param filePath 
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        if (fileType != null) {
            fileType.setFileName(filePath);
        }
    }

    /**
     * Returns the FileTypeStrategy...text or binary.
     * @return FileTypeStrategy
     */
    public FileTypeStrategy getFileTypeStrategy() {
        return fileType;
    }

    /**
     * Sets the FileTypeStrategy...text or binary.  A corresponding correct
     * value is included in each FormatStrategy object.
     * @param fts 
     */
    public void setFileTypeStrategy(FileTypeStrategy fts) {
        this.fileType = fts;
        fileType.setFileName(filePath);
    }

    /**
     * Returns the current FormatStrategy.
     * @return FormatStrategy
     */
    public FormatStrategy getFormatStrategy() {
        return format;
    }

    /**
     * Sets the FormatStrategy used for encoding and decoding.
     * @param format 
     */
    public void setFormatStrategy(FormatStrategy format) {
        this.format = format;
    }
    
    /**
     * 
     * @param rawData
     * @throws IOException 
     */
    public void dataToFile(List rawData) throws IOException {
        fileType.writeToFile(format.encodeData(rawData));
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public List<String[]> dataFromFile() throws IOException {
        data = format.decodeData(fileType.readFromFile());
        return data;
    }
}
