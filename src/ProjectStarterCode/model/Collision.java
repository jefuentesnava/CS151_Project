package ProjectStarterCode.model;

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
        if (snake.isAlive()) {
            switch (snake.direction) {
                case UP:
                    try {
                        nextTile = board.tiles[snake.location.getFirst().getRow() - 1][snake.location.getFirst().getCol()];
                        nextTileReaction(nextTile);
                    } catch (IndexOutOfBoundsException e) {
                        snake.toggleAlive();
                    }
                    break;
                case DOWN:
                    try {
                        nextTile = board.tiles[snake.location.getFirst().getRow() + 1][snake.location.getFirst().getCol()];
                        nextTileReaction(nextTile);
                    } catch (IndexOutOfBoundsException e) {
                        snake.toggleAlive();
                    }
                    break;
                case LEFT:
                    try {
                        nextTile = board.tiles[snake.location.getFirst().getRow()][snake.location.getFirst().getCol() - 1];
                        nextTileReaction(nextTile);
                    } catch (IndexOutOfBoundsException e) {
                        snake.toggleAlive();
                    }
                    break;
                case RIGHT:
                    try {
                        nextTile = board.tiles[snake.location.getFirst().getRow()][snake.location.getFirst().getCol() + 1];
                        nextTileReaction(nextTile);
                    } catch (IndexOutOfBoundsException e) {
                        snake.toggleAlive();
                    }
            }
        }
    }

    private void nextTileReaction(Tile nextTile) {
        if (nextTile.getInsideTile().equals("snake")) {
            snake.toggleAlive();
        } else if (nextTile.getInsideTile().equals("food")) {
            nextTile.setInsideTile("snake");
            snake.location.addFirst(nextTile);
            snake.updateSize();
        } else if (nextTile.getInsideTile().equals("nothing")) {
            nextTile.setInsideTile("snake");
            snake.location.addFirst(nextTile);
            snake.location.removeLast().setInsideTile("nothing");
        }
    }
}
