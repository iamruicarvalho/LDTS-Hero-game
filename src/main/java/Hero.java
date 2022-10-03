import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    private int x;
    private int y;
    private int ola;
    private Screen screen;
    public Hero(int x, int y) {

    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void moveUp()    { y -= 1; }
    public void moveDown()  { y += 1; }
    public void moveRight() { x += 1; }
    public void moveLeft()  { x -= 1; }

    public void draw(Screen screen) throws IOException {
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }
}
