
import java.util.Objects;

public class Position { // in this class we are just saving the position where is our player or food . The position is in which square is the player or food is locate?
    private int x ;
    private int y ;

    public Position(int x , int y){
        this.x = x ;
        this.y = y ;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Position o) {

        if ( x == o.getX() && y == o.getY()) return true; //here we are checking are two positions equal if it is equal returns true if it is not false 
    
        return false ; 
    }
}
