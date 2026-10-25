package hu.nye.progtech.engine;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    //Működés után bővítés String megnevezésse;
    private boolean jatekosAuto;
    private int meret;
    private int [][] jarmuPozicio;

    public Cars(boolean jatekosAuto, int meret) {
        this.jatekosAuto = jatekosAuto;
        if(meret<=1)meret=2;
        this.meret = meret;
        jarmuPozicio=new int [meret][meret];
    }


    public boolean isJatekosAuto() {
        return jatekosAuto;
    }

    public void setJatekosAuto(boolean jatekosAuto) {
        this.jatekosAuto = jatekosAuto;
    }

    public int getMeret() {
        return meret;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }

    public int[][] getJarmuPozicio() {
        return jarmuPozicio;
    }

    public void setJarmuPozicio(int x,int y) {
        if(this.meret==1){
            this.jarmuPozicio[0][0]=x;
            this.jarmuPozicio[1][0]=y;
        }
    }

    public void setJarmuPozicio(int x,int y,int x2,int y2) {
        if(this.meret==2){
            this.jarmuPozicio[0][0]=x;
            this.jarmuPozicio[1][0]=y;
            this.jarmuPozicio[0][1]=x2;
            this.jarmuPozicio[1][1]=y2;
        }
    }
}
