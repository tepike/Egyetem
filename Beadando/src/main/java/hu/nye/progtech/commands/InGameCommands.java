package hu.nye.progtech.commands;

import hu.nye.progtech.map.MapVO;

public class InGameCommands extends MapVO {
    private boolean Runing=true;

    public boolean isRuning() {
        return Runing;
    }

    public void stopRuning(){
        Runing=(!Runing);
    }

    public void CheckCommand(){
        while(isRuning()){

        }

    }
}
