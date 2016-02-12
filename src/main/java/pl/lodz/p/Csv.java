package pl.lodz.p;

/**
 * Created by maciek on 09/02/16.
 */
public class Csv extends File {

    private String separator;
    private boolean skipFirstLine;

    @Override
    public String toString() {
        return "csv";
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public boolean isSkipFirstLine() {
        return skipFirstLine;
    }

    public void setSkipFirstLine(boolean skipFirstLine) {
        this.skipFirstLine = skipFirstLine;
    }
}
