package ProjectStarterCode.model;

public class Model {

    public Board board;
    public Snake snake;
    public Food food;
    public Collision collision;

    public Model() {
        board = new Board();
        snake = new Snake(board);
        food = new Food(board, 6, 4); //#'s to be removed when not testing
        collision = new Collision(board, snake);
    }

    public void updateModel() {
        //snake movement is calculated
        collision.snakeCollision();
        //spawns food if there isn't one
        food.spawnFood();
    }
}
