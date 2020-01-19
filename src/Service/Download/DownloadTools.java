package Service.Download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTools {
    //检查文件是否存在
    private boolean CheckFileExits(String url,String saveFilePath){
        String[] parts = url.split("/");
        String dictFilePath = saveFilePath+"\\"+parts[parts.length-2];
        File dictFile = new File(dictFilePath);
        if(!dictFile.exists()){
            dictFile.mkdirs();
            return true;
        }
        File targetFile = new File(saveFilePath+"\\"+parts[parts.length-2]+"\\"+parts[parts.length-1]);
        return !targetFile.exists();
    }

    //检查url是否为有效url(404算是无效的)
    private boolean CheckUrl(String url){
        try{
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
            httpURLConnection.setConnectTimeout((3*1000));
            httpURLConnection.connect();
            return httpURLConnection.getResponseCode()==200;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //下载(其实想一想要不要用进程来写？？)
    public void Download(String url,String saveFilePath){
        String[] parts = url.split("/");

        if(this.CheckFileExits(url, saveFilePath) && this.CheckUrl(url)){
            try{
                HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(saveFilePath+"\\"+parts[parts.length-2]+"\\"+parts[parts.length-1]));
                byte[] data = new byte[inputStream.available()];
                int length;
                while((length = inputStream.read(data))!= -1){
                    fileOutputStream.write(data);
                }
                inputStream.close();
                fileOutputStream.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
