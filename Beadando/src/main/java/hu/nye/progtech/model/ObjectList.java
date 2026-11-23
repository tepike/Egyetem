package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectList {
    private static final List<GameObjects> objectList =new ArrayList<>();



    public static GameObjects findObjectAt(int x, int y) {
        for(GameObjects object : objectList) {

            for(Position p : object.getOccupiedPositions()) {

                if(p.getX() == x && p.getY() == y) {
                    return object;
                }

            }

        }
        return null;
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

    public static void setObjectPosition(int x1, int y1, int x2, int y2){
        for(GameObjects object : objectList) {
            for(Position p : object.getOccupiedPositions()) {
                if(p.getX() == x1 && p.getY() == y1) {

                }
            }

        }
    }



}
