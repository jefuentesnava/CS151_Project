package ProjectStarterCode.model;

public class Board {

    public Tile[][] tiles;

    public Board() {
        //need to set dimensions of board
        tiles = new Tile[9][9];
        //creating tiles for each tile
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tiles[i][j].getInsideTile() + "\t");
            }
            System.out.println();
        }
    }
}
