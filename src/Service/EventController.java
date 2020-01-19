package Service;

import Service.Download.DownloadTools;
import Service.FileReader.FileReaderTools;

import java.io.File;
import java.util.List;

public class EventController {
    private static EventController _instance;

    public static EventController Instance(){
        if(_instance == null){
            _instance = new EventController();
        }
        return _instance;
    }

    private FileReaderTools fileReaderTools = new FileReaderTools();

    private DownloadTools downloadTools = new DownloadTools();

    public void StartOperation(File txtFile, File saveFile){
        List<String> urlList = fileReaderTools.ReaderFile(txtFile);
        String dictFilePath = txtFile.getName().equals("import.txt")? saveFile.getAbsolutePath()+"\\import" : saveFile.getAbsolutePath()+"\\raw-assets";
        File dictFile = new File(dictFilePath);
        if(!dictFile.exists()){
            dictFile.mkdirs();
        }

    }

}
