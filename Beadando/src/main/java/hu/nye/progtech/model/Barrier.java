package hu.nye.progtech.model;

import hu.nye.progtech.map.MapVO;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class Barrier implements GameObjects {
    private static List<Barrier> barriers= new ArrayList<Barrier>();
    private Position position;
    private int barierLength;
    private Orientation orientation;

    public Barrier(Position position, int barierLength, Orientation orientation) {
        this.position = position;
        this.barierLength = barierLength;
        this.orientation = orientation;
    }



    @Override
    public List<Position> getOccupiedPositions() {
        List<Position> result = new ArrayList<>();

        for (int i = 0; i < barierLength; i++) {

            if (orientation == Orientation.HORIZONTAL) {
                result.add(new Position(position.getX() + i,position.getY()));
            }
            else {
                result.add(new Position(position.getX(), position.getY() + i));
            }

        }

        return result;
    }

    public static void getBariersFromMap(MapVO mapVo) {
        String map[][]=mapVo.getMap();
        barriers.clear();
        List<Position> position= new ArrayList<Position>();


        for(int i=0;i<mapVo.getNumberOfColumns();i++){
            for(int j=0;j<mapVo.getNumberOfRows();j++){
                String element=map[i][j];
                if(element.equals("h")){
                    position.add(new Position(j,i));
                }
            }
            if(!position.isEmpty()){
                Barrier barrier =new Barrier(position.get(0),position.size(),Orientation.HORIZONTAL);
                barriers.add(barrier);
                ObjectList.addObject(barrier);
                position.clear();
            }
        }
        position.clear();

        for(int i=0;i<mapVo.getNumberOfRows();i++){
            for(int j=0;j<mapVo.getNumberOfColumns();j++){
                String element=map[j][i];
                if(element.equals("v")){
                    position.add(new Position(i,j));
                }
            }
            if(!position.isEmpty()){
                Barrier barrier =new Barrier(position.get(0),position.size(),Orientation.VERTICAL);
                barriers.add(barrier);
                ObjectList.addObject(barrier);
                position.clear();
            }
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getBarierLength() {
        return barierLength;
    }

    public void setBarierLength(int barierLength) {
        this.barierLength = barierLength;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getLength(){
        return barierLength;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Akadály x: "+position.getX() +" y: "+position.getY() +" mérete: "+barierLength+" iránya: "+orientation;
    }
}
