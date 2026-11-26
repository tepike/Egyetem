package hu.nye.progtech.engine;

import hu.nye.progtech.commands.SaveGame;
import hu.nye.progtech.map.MapVO;

import java.io.File;


public class LocateSaveFolder {

    public String UserFolder = System.getProperty("user.home") + File.separator + "Documents";
    public String SaveFolder = UserFolder + File.separator + "RushHourNYE";

    File folder = new File(SaveFolder);

    public void LocateSaveFolder() {
        if (!folder.exists()) {
            System.out.println("Folder doesn't exist");
            folder.mkdir();
            System.out.print("Folder created");
        } else {
            System.out.println("Folder exists");
        }
    }

    public void PrintSavedFiles(MapVO mapVO) {
        String[] files = folder.list();
        if (files == null || files.length == 0) {
            try {
                new SaveGame().saveDefaultGame(mapVO);
            } catch (Exception e) {
                System.out.println("\n" + e);
            }

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

    public String getSavedGame(int index) {
        String[] files = folder.list();
        if (files == null || files.length == 0) {
            return null;
        }
        return files[index];
    }

}
