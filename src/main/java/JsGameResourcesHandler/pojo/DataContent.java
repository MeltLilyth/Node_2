package JsGameResourcesHandler.pojo;

import java.util.Arrays;

public class DataContent{
    private String chinese_simple;
    private String english;
    private String chinese_tradition;
    private boolean isColored;
    private String[] color;
    private boolean isUseSystemFont;
    private String[] params;

    public DataContent() {
    }

    public DataContent(String chinese_simple, String english, String chinese_tradition, boolean isColored, String[] color, boolean isUseSystemFont, String[] params) {
        this.chinese_simple = chinese_simple;
        this.english = english;
        this.chinese_tradition = chinese_tradition;
        this.isColored = isColored;
        this.color = color;
        this.isUseSystemFont = isUseSystemFont;
        this.params = params;
    }

    public String getChinese_simple() {
        return chinese_simple;
    }

    public void setChinese_simple(String chinese_simple) {
        this.chinese_simple = chinese_simple;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese_tradition() {
        return chinese_tradition;
    }

    public void setChinese_tradition(String chinese_tradition) {
        this.chinese_tradition = chinese_tradition;
    }

    public boolean isColored() {
        return isColored;
    }

    public void setColored(boolean colored) {
        isColored = colored;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public boolean isUseSystemFont() {
        return isUseSystemFont;
    }

    public void setUseSystemFont(boolean useSystemFont) {
        isUseSystemFont = useSystemFont;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "DataContent{" +
                "chinese_simple='" + chinese_simple + '\'' +
                ", english='" + english + '\'' +
                ", chinese_tradition='" + chinese_tradition + '\'' +
                ", isColored=" + isColored +
                ", color=" + Arrays.toString(color) +
                ", isUseSystemFont=" + isUseSystemFont +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
