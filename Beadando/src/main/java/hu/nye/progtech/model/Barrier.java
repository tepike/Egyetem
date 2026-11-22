package hu.nye.progtech.model;

import hu.nye.progtech.map.MapVO;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class Barrier implements GameObjects {
    private static List<Barrier> barriers= new ArrayList<Barrier>();
    private Position positions;
    private int barierLength;
    private Orientation orientation;

    public static List<Barrier> getBarriers() {
        return barriers;
    }



    @Override
    public List<Position> getOccupiedPositions() {
        List<Position> result = new ArrayList<>();

        for (int i = 0; i < barierLength; i++) {

            if (orientation == Orientation.HORIZONTAL) {
                result.add(new Position(positions.getX() + i,positions.getY()));
            }
            else {
                result.add(new Position(positions.getX(), positions.getY() + i));
            }

        }

        return result;
    }

    public void addBarier(Position p, int barierLength, char orientation) {
        List<Barrier> localBarriers = new ArrayList<>();
        this.positions=p;
        this.barierLength=barierLength;
        if(orientation=='v') {
            this.orientation = Orientation.VERTICAL;
        }
        else {
            this.orientation = Orientation.HORIZONTAL;
        }
        barriers.add((Barrier) localBarriers);
    }

    public static void getBariersFromMap(MapVO mapVo) {
        String map[][]=mapVo.getMap();
        List<Position> positions= new ArrayList<>();

        for(int i=0;i<mapVo.getNumberOfColumns();i++){
            for(int j=0;j<mapVo.getNumberOfRows();j++){
                //System.out.print("\ni:"+i+" j:"+j);
                String element=map[i][j];
                if(element.equals("h")){
                    positions.add(new Position(j,i));
                }
            }
        }
        System.out.print("\n--------------------------------------\n");
        for(int i=0;i<mapVo.getNumberOfRows();i++){
            for(int j=0;j<mapVo.getNumberOfColumns();j++){
                //System.out.print("\ni:"+i+" j:"+j);
                String element=map[j][i];
                if(element.equals("v")){
                    positions.add(new Position(i,j));
                }
            }
        }
        for(Position p:positions){
            System.out.println("\nKapott poziciok y: "+p.getY()+" | x: "+p.getX());
        }
        //barriers.add((Barrier) Barrier.barriers);
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
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

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }





}
