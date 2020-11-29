public class Food {

    //public Tile location;
    public Board board;

    public Food(Board board) {
        this.board = board;
    }

    public void spawnFood() {
        //needs to look at board and choose unoccupied tile
        if (!foodIsOnBoard()) {
            int x = (int) (Math.random() * board.tiles.length);
            int y = (int) (Math.random() * board.tiles.length);
            if (board.tiles[x][y].getInsideTile().compareTo("nothing") == 0) {
                board.tiles[x][y].setInsideTile("food");
            }
        }
    }

    public boolean foodIsOnBoard() {
        //iterate through tiles of board and check if food is there
        for (int i = 0; i < board.tiles.length; i++) {
            for (int j = 0; j < board.tiles[0].length; j++) {
                if (board.tiles[i][j].getInsideTile().compareTo("food") == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
