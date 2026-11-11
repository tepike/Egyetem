package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;

public class Barrier implements GameObjects {
    private Position positions;
    private int barierLength;
    private Orientation orientation;

    @Override
    public List<Position> getOccupiedPositions() {

        List<Position> result = new ArrayList<>();

        for (int i = 0; i < barierLength; i++) {

            if (orientation == Orientation.HORIZONTAL) {

                result.add(
                        new Position(
                                positions.getX() + i,
                                positions.getY()
                        )
                );

            } else {

                result.add(
                        new Position(
                                positions.getX(),
                                positions.getY() + i
                        )
                );

            }

        }

        return result;
    }

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





}
