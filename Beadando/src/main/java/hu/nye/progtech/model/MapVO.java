package hu.nye.progtech.model;

class MapVO {
    private int numberOfRows;
    private int numberOfColumns;
    private int [][] map;
    private boolean[][] occupiedArea;

    public MapVO(int numberOfRows, int numberOfColumns, int [][] map, boolean[][] occupiedArea) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = map;
        this.occupiedArea = occupiedArea;
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

    public boolean[][] getOccupiedArea() {return occupiedArea;}

}
