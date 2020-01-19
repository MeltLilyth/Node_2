package Service.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class FileReaderTools {
    public List<String> ReaderFile(File txtFile){
        StringBuffer stringBuffer = new StringBuffer();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile));
            String length;
            while((length = bufferedReader.readLine())!= null){
                stringBuffer.append(length);
            }
            bufferedReader.close();
            System.out.println();
//          Arrays.asList(stringBuffer.toString().split("\n"));
            return null;  //调试用，以后会改掉
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
