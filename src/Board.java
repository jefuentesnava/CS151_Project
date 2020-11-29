public class Board {

    public Tile[][] tiles;

    public Board(int x, int y) {
        //need to set dimensions of board
        tiles = new Tile[x][y];
        //creating tiles for each tile
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tiles[i][j] = new Tile();
            }
        }
    }
}
