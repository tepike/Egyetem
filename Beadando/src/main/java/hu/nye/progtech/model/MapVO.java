package hu.nye.progtech;

class MapVO {
    private int numberOfRows;
    private int numberOfColumns;
    private int [][] map;
    private boolean[][] occupied;

    public MapVO(int numberOfRows, int numberOfColumns, int [][] map) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = map;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getMap() {
        return map;
    }

}
