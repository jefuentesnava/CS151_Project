import ProjectStarterCode.model.Board;
import ProjectStarterCode.model.Food;
import org.junit.jupiter.api.Test;

class FoodTest {

    @Test
    void testSpawnFood() {
        Board board = new Board();
        Food food = new Food(board);
        assert food.location != null;
    }

    @Test
    void testFoodIsOnBoard() {
        Board board = new Board();
        Food food = new Food(board);
        assert food.foodIsOnBoard();
        food.location.setInsideTile("nothing");
        assert !food.foodIsOnBoard();
    }
}
