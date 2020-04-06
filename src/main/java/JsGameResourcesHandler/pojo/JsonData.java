package JsGameResourcesHandler.pojo;


import java.util.Arrays;

public class JsonData {
    private String languageKey;
    private DataContent dataContent;

    public JsonData() {
    }

    public JsonData(String languageKey, DataContent dataContent) {
        this.languageKey = languageKey;
        this.dataContent = dataContent;
    }

    public String getLanguageKey() {
        return languageKey;
    }

    public void setLanguageKey(String languageKey) {
        this.languageKey = languageKey;
    }

    public DataContent getDataContent() {
        return dataContent;
    }

    public void setDataContent(DataContent dataContent) {
        this.dataContent = dataContent;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "languageKey='" + languageKey + '\'' +
                ", dataContent=" + dataContent +
                '}';
    }
}
