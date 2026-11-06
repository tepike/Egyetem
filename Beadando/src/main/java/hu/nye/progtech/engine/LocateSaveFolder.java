package hu.nye.progtech.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocateSaveFolder {
    public String UserFolder=System.getProperty("user.home") + File.separator + "Documents";
    public String SaveFolder=UserFolder+File.separator+"RushHourNYE";
    File folder=new File(SaveFolder);
    public List<String> AvaibleSavesList=new ArrayList<String>();
   public LocateSaveFolder(){
        if(!folder.exists()){
            folder.mkdir();
            System.out.println("Folder created");
        }else {
            System.out.println("Folder already exists");
        }
        AvaibleSavesList.add(Arrays.toString(folder.list()));
    }
    public void PrintSavedFiles(){
       for(String s: AvaibleSavesList){
           System.out.println(s);
       }
    }
}
