import java.util.LinkedList;

public class Snake {

    private boolean alive;
    private int size;
    //public direction, what are we using to keep track of direction?
    public LinkedList<Tile> location;

    public Snake() {
        alive = true;
        size = 3; //need to double check starting length
        //direction =
        location = new LinkedList<Tile>();
        //need to add initial location of tiles
        //head
        //body
        //tail?
    }

    public boolean toggleAlive() {
        alive = !alive;
        return alive;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int newSize) {
        size = newSize;
    }

    private boolean checkWinCondition() {
        //0 should be replaced with 1/2 of board size
        return size > 0;
    }
}
