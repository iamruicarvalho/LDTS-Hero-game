import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
public class Hero {
    private Position position;

    public Hero(int x, int y) {
        position = new Position(x, y);
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }
    public void setPosition(Position pos) {
        this.position = pos;                          //complete this line
    }

    public Position moveUp()    { return new Position(position.getX(), position.getY()-1); }
    public Position moveDown()  { return new Position(position.getX(), position.getY()+1); }
    public Position moveRight() { return new Position(position.getX()+1, position.getY()); }
    public Position moveLeft()  { return new Position(position.getX()-1, position.getY()); }

    public void draw(Screen screen) throws IOException {
        //System.out.println(position.getX() + position.getY());
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }


}
