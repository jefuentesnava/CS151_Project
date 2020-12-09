import ProjectStarterCode.model.Board;
import ProjectStarterCode.model.Snake;
import ProjectStarterCode.model.Tile;
import org.junit.jupiter.api.Test;

class SnakeTest {

    @Test
    void testAliveFunctions() {
        Board board = new Board();
        Snake snake = new Snake(board);
        assert snake.isAlive();
        snake.toggleAlive();
        assert !snake.isAlive();
    }

    @Test
    void testSizeFunctions() {
        Board board = new Board();
        Snake snake = new Snake(board);
        assert snake.getSize() == 3;
        snake.location.add(new Tile(0, 0));
        assert snake.getSize() == 3;
        snake.updateSize();
        assert snake.getSize() == 4;
    }

    @Test
    void testCheckWinCondition() {
        Board board = new Board();
        Snake snake = new Snake(board);
        assert !snake.checkWinCondition();
        for (int i = 0; i < 40; i++) {
            snake.location.add(new Tile(0, 0));
        }
        assert !snake.checkWinCondition();
        snake.updateSize();
        assert snake.checkWinCondition();
    }
}
