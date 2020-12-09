import ProjectStarterCode.model.Tile;
import org.junit.jupiter.api.Test;

class TileTest {

    @Test
    void testTileGetterMethods() {
        Tile tile = new Tile(0, 1);
        assert tile.getInsideTile().compareTo("nothing") == 0;
        assert tile.getRow() == 0;
        assert tile.getCol() == 1;
    }

    @Test
    void TestSetInsideTile() {
        Tile tile = new Tile(0, 1);
        assert tile.getInsideTile().compareTo("nothing") == 0;
        tile.setInsideTile("testing");
        assert tile.getInsideTile().compareTo("testing") == 0;
    }
}
