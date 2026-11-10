package hu.nye.progtech.model;

import java.util.List;

public class Barrier {
    public static List<Barrier> positionList;
    private Position positions;
    private int barierLength;
    private Orientation orientation;

    public Barrier(Position p,int barierLength,char orientation) {
        this.positions=p;
        this.barierLength=barierLength;
        if(orientation=='V') {
            this.orientation = Orientation.VERTICAL;
        }
        else {
            this.orientation = Orientation.HORIZONTAL;
        }
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

    public static void addBarrier(Barrier barrier) {
        positionList.add(barrier);
    }

    public List<Barrier> getPositionList() {
        return positionList;
    }



}
