package hu.nye.progtech.model;

public class Cars {
    //Működés után bővítés String megnevezésse;
    private boolean jatekosAuto;
    private int [][] jarmuPozicio;
    private static int [][] exit={{0,0},{11,5}};

    public Cars(boolean jatekosAuto) {
        this.jatekosAuto = jatekosAuto;
        jarmuPozicio=new int [1][1];
    }

    public boolean isJatekosAuto() {
        return jatekosAuto;
    }

    public void setJatekosAuto(boolean jatekosAuto) {
        this.jatekosAuto = jatekosAuto;
    }

    public int[][] getJarmuPozicio() {
        return jarmuPozicio;
    }

    public void setJarmuPozicio(int x,int y,int x2,int y2) {
            this.jarmuPozicio[0][0]=x;
            this.jarmuPozicio[1][0]=y;
            this.jarmuPozicio[0][1]=x2;
            this.jarmuPozicio[1][1]=y2;

    }

    public static int[][] getExit() {
        return exit;
    }

    public void setExit(int[][] exit) {
        this.exit = exit;
    }
}
