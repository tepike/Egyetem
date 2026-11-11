package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;

public class Cars implements GameObjects {
    //Működés után bővítés String megnevezésse;
    public static Cars Player1Car;
    public static Cars Player2Car;
    private boolean jatekosAuto;
    private int xPositionHead;
    private int YPosition;
    private int Length;
    private int CarExitX;
    private int CarExitY;

    @Override
    public List<Position> getOccupiedPositions() {

        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < Length; i++) {
            positions.add(
                    new Position(
                            xPositionHead + i,
                            YPosition
                    )
            );
        }

        return positions;
    }


    public Cars(int xPosition, int YPosition,int length) {
        jatekosAuto = false;
        this.xPositionHead = xPosition;
        this.YPosition = YPosition;
        this.Length = length;
    }
    public Cars(boolean jatekosAuto, int xPosition, int YPosition,int length ,int CarExitX, int CarExitY) {
        this.jatekosAuto = jatekosAuto;
        this.xPositionHead = xPosition;
        this.YPosition = YPosition;
        this.Length = length;
        this.CarExitX = CarExitX;
        this.CarExitY = CarExitY;
    }

    public boolean isJatekosAuto() {
        return jatekosAuto;
    }

    public void setJatekosAuto(boolean jatekosAuto) {
        this.jatekosAuto = jatekosAuto;
    }

    public int getXPosition() {
        return xPositionHead;
    }
    public void setXPosition(int xPosition) {
        this.xPositionHead = xPosition;
    }

    public int getYPosition() {
        return YPosition;
    }
    public void setYPosition(int YPosition) {
        this.YPosition = YPosition;
    }

    public void setJarmuPozicio(Cars car,int x,int y) {
            this.setXPosition(x);
            this.setYPosition(y);
    }

    public static void generatePlayerObjects(){
         Player1Car= new Cars(true,0,0,2,0,0);
         Player2Car= new Cars(true,0,0,2,0,0);
    }



    public void setCarExitX(int carExitX) {
        CarExitX = carExitX;
    }
    public void setCarExitY(int carExitY) {
        CarExitY = carExitY;
    }

    public int getCarExitX() {
        return CarExitX;
    }
    public int getCarExitY() {
        return CarExitY;
    }


    public int getLength() {
        return Length;
    }
    public void setLength(int length) {
        Length = length;
    }



    public int getxPositionHead() {
        return xPositionHead;
    }

    public void setxPositionHead(int xPositionHead) {
        this.xPositionHead = xPositionHead;
    }

    @Override
    public String toString() {
        return "Jarmu adatok:\n"
                + "Position X: " + xPositionHead
                + "\nPosition Y: " + YPosition;
    }
}
