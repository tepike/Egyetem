package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectList {
    private static List<GameObjects> objectList =new ArrayList<>();

    public static GameObjects findObjectAt(int x, int y) {
        for(GameObjects object : objectList) {

            for(Position p : object.getOccupiedPositions()) {

                if(p.getX() == x && p.getY() == y) {
                    return object;
                }

            }

        }
        return null; //Ha nincs olyan ami foglalja
    }

    public static boolean isOccupied(int x, int y) {

        for(GameObjects object : objectList) {

            if(object.containsPosition(x, y)) {
                return true;
            }

        }

        return false;
    }

    public static void addObject(GameObjects vehicle){
        objectList.add(vehicle);
    }

    public List<GameObjects> getVehicleList(){
        return objectList ;
    }

}
