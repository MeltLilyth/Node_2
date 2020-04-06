package JsGameResourcesHandler.Service.FileTools;

import JsGameResourcesHandler.pojo.DataContent;
import JsGameResourcesHandler.pojo.JsonData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileTools {
    private static FileTools _instance;

    public static FileTools getInstance(){
        if(_instance == null){
            _instance = new FileTools();
        }
        return _instance;
    }

    //写入文件
    public void writeFile(String fileName,String content){
        File file = new File(fileName);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(content,0,content.length());
            bufferedWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //读取excel
    public String readExcel(String filePath) throws Exception{
        File file = new File(filePath);
        Workbook workbook = null;
        List<JsonData> dataList = new ArrayList<JsonData>();

        if (file.exists()) {
            if (file.getName().split("\\.")[1].equals("xls")) {
                FileInputStream fileInputStream = new FileInputStream(file);
                workbook = new HSSFWorkbook(fileInputStream);
            }
            else if(file.getName().split("\\.")[1].equals("xlsx")){
                workbook = new XSSFWorkbook(file);
            }
            else{
                System.out.println("Error File");
            }
            if(workbook != null){
                Sheet sheet = workbook.getSheetAt(0);
                if(sheet != null){
                    for(int num = 1;num < sheet.getPhysicalNumberOfRows(); num++){
                        Row row = sheet.getRow(num);
                        JsonData jsonData = new JsonData();
                        DataContent dataContent = new DataContent();
                        jsonData.setLanguageKey(row.getCell(0).getStringCellValue());
                        dataContent.setChinese_simple(row.getCell(1).getStringCellValue());
                        dataContent.setEnglish(row.getCell(2).getStringCellValue());
                        dataContent.setChinese_tradition(row.getCell(3).getStringCellValue());
                        dataContent.setColored(row.getCell(4).getBooleanCellValue());
                        dataContent.setColor(row.getCell(5).getStringCellValue().split(","));
                        dataContent.setUseSystemFont(row.getCell(6).getBooleanCellValue());
                        if(row.getCell(7).getStringCellValue() != null && !row.getCell(7).getStringCellValue().isEmpty()){
                            dataContent.setParams(row.getCell(7).getStringCellValue().split(","));
                        }
                        jsonData.setDataContent(dataContent);
                        dataList.add(jsonData);
                    }
                }
            }
        }
        //调用fastjson的方法即可
        return null;
    }
}
