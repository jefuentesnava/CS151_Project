public class Collision {
    public Snake snake;
    public Board board;

    public Collision(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;
    }

    public void snakeCollision() {
        //stuff for checking collision
        Tile nextTile = null;
        switch (snake.direction) {
            case UP:
                try {
                    nextTile = board.tiles[snake.location.getFirst().getRow() - 1][snake.location.getFirst().getCol()];
                    snake.location.addFirst(nextTile);
                    nextTile.setInsideTile("snake");
                    snake.location.removeLast().setInsideTile("nothing");
                } catch (IndexOutOfBoundsException e) {
                    snake.toggleAlive();
                }
                break;
            case DOWN:
                try {
                    nextTile = board.tiles[snake.location.getFirst().getRow() + 1][snake.location.getFirst().getCol()];
                    snake.location.addFirst(nextTile);
                    nextTile.setInsideTile("snake");
                    snake.location.removeLast().setInsideTile("nothing");
                } catch (IndexOutOfBoundsException e) {
                    snake.toggleAlive();
                }
                break;
            case LEFT:
                try {
                    nextTile = board.tiles[snake.location.getFirst().getRow()][snake.location.getFirst().getCol() - 1];
                    snake.location.addFirst(nextTile);
                    nextTile.setInsideTile("snake");
                    snake.location.removeLast().setInsideTile("nothing");
                } catch (IndexOutOfBoundsException e) {
                    snake.toggleAlive();
                }
                break;
            case RIGHT:
                try {
                    nextTile = board.tiles[snake.location.getFirst().getRow()][snake.location.getFirst().getCol() + 1];
                    snake.location.addFirst(nextTile);
                    nextTile.setInsideTile("snake");
                    snake.location.removeLast().setInsideTile("nothing");
                } catch (IndexOutOfBoundsException e) {
                    snake.toggleAlive();
                }
        }
    }
}
