package hu.nye.progtech.engine;

    public class JatekMezo {
        private int mezoSzeles=6;
        private int mezopMagas=12;

        private int mezo[][];

        private boolean mezoFoglalt;
        private boolean mezoKijarat;



        public void JatekMezo(){
            setMezoMeret(mezoSzeles,mezopMagas);
            System.out.println("JatekMezo merete: "+mezo[0].length+" "+mezo.length);

        }

        // Getters and Setters ------------------------------------------------------------------------------
        public int getMezoSzeles() {
            return mezoSzeles;
        }

        public void setMezoSzeles(int mezoSzeles) {
            this.mezoSzeles = mezoSzeles;
        }

        public int getMezopMagas() {
            return mezopMagas;
        }

        public void setMezopMagas(int mezopMagas) {
            this.mezopMagas = mezopMagas;
        }

        public int[][] getMezo() {
            return mezo;
        }

        public void setMezo(int i,int j,int adat) {
            int[][] localMezo=new int[i][j];
            this.mezo = localMezo;
        }

        public void setMezoMeret(int i,int j) {
            int[][] localMezo=new int[i][j];
            this.mezo = localMezo;
        }

        public boolean isMezoFoglalt() {
            return mezoFoglalt;
        }

        public void setMezoFoglalt(boolean mezoFoglalt) {
            this.mezoFoglalt = mezoFoglalt;
        }

        public boolean isMezoKijarat() {
            return mezoKijarat;
        }

        public void setMezoKijarat(boolean mezoKijarat) {
            this.mezoKijarat = mezoKijarat;
        }
        // Getters and Setters vege ---------------------------------------------------------------------------
    }
