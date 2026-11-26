package hu.nye.progtech.engine;

import hu.nye.progtech.commands.LoadGame;
import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Run {
    private final MapVO mapVO;
    private List<Player> player = new ArrayList<>();
    public Run(MapVO mapVO) {
        mapVO.setupMap();
        this.mapVO = mapVO;
        this.player=mapVO.getPlayer();
        for(Player p: player){
            System.out.println("Run voidba player: "+p.playerName);
            System.out.println("x:"+p.getExitX()+"\ny: "+p.getExitY());
        }
    }
    public void Start() {
        LocateSaveFolder locateSaveFolder = new LocateSaveFolder();
        locateSaveFolder.LocateSaveFolder();
        new LoadGame().LoadGame(mapVO);
/*
        for(String [] c:mapVO.getMap()){
            System.out.println(c[0]+"\t"+c[1]+"\t"+c[2]+"\t"+c[3]+"\t"+c[4]+"\t"+c[5]+"\t"+c[6]+"\t"+c[7]+"\t"+c[8]+"\t"+c[9]+"\t"+c[10]+"\t"+c[11]);
        }
        for(Player p: player){
            System.out.println("Da fak: "+p.playerName);
            System.out.println("x:"+p.getExitX()+"\ny: "+p.getExitY());
        }
*/
        new JatekMezo().printMap(mapVO,player);
        new LoadGame().LoadGame(mapVO);
        new JatekMezo().printMap(mapVO,player);


    }

}
