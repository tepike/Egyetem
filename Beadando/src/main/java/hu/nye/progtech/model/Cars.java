package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    //Működés után bővítés String megnevezésse;
    public static Cars Player1Car;
    public static Cars Player2Car;
    private boolean jatekosAuto;
    private int xPosition;
    private int YPosition;
    private int Length;
    private int CarExitX;
    private int CarExitY;


    public Cars(boolean jatekosAuto, int xPosition, int YPosition,int length) {
        this.jatekosAuto = jatekosAuto;
        this.xPosition = xPosition;
        this.YPosition = YPosition;
        this.Length = length;
    }
    public Cars(boolean jatekosAuto, int xPosition, int YPosition,int length ,int CarExitX, int CarExitY) {
        this.jatekosAuto = jatekosAuto;
        this.xPosition = xPosition;
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
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public int getYPosition() {
        return YPosition;
    }
    public void setYPosition(int YPosition) {
        this.YPosition = YPosition;
    }

    public void setJarmuPozicio(int x,int y,int x2,int y2) {

    }

    public static void generatePlayerObjects(){
         Player1Car= new Cars(true,0,0,2,0,0);
         Player2Car= new Cars(true,0,0,2,0,0);
    }

    public int getCarExitX() {
        return CarExitX;
    }

    public void setCarExitX(int carExitX) {
        CarExitX = carExitX;
    }

    public int getCarExitY() {
        return CarExitY;
    }

    public void setCarExitY(int carExitY) {
        CarExitY = carExitY;
    }
    public int getLength() {
        return Length;
    }
    public void setLength(int length) {
        Length = length;
    }

    public String toString(Cars c){
        return "Jarmu adatok:\nPosition X:"+c.getXPosition()+"\nPosition Y:"+c.getYPosition()+"\nHossza:"+c.getLength()+"\nKijarat X:"+c.getCarExitX()+" Kijarat Y:"+c.getCarExitY();
    }
}
