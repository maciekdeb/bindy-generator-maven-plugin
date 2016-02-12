package pl.lodz.p;

/**
 * Created by maciek on 09/02/16.
 */
public abstract class File {

    private String fileName;
    private String className;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
