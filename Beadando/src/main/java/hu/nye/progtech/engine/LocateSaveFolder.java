package hu.nye.progtech.engine;

import hu.nye.progtech.commands.SaveGame;

import java.io.File;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocateSaveFolder {

    public String UserFolder=System.getProperty("user.home") + File.separator + "Documents";
    public String SaveFolder=UserFolder+File.separator+"RushHourNYE";

    File folder=new File(SaveFolder);

   public LocateSaveFolder(){
        if(!folder.exists()){
            folder.mkdir();
        }
    }

    public void PrintSavedFiles(){
        String [] files=folder.list();
            if(files==null || files.length==0){
                System.out.print("Nincs mentett játék");
                try {
                    new SaveGame().saveDefaultGame();
                }catch (Exception e){
                    e.printStackTrace();
                }
                //saveDefaultGame();
                return;
            }
        for (int i = 0; i < files.length; i++) {

            String fileName = files[i];

            int dotIndex = fileName.lastIndexOf('.');

            if (dotIndex > 0) {
                fileName = fileName.substring(0, dotIndex);
            }

            System.out.println((i + 1) + ". " + fileName);
        }
    }

    public String getSavedGame(int index){
        String [] files=folder.list();
        if(files==null || files.length==0){
            return null;
        }
       return files[index];
    }

}
