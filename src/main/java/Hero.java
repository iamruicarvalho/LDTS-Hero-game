import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {
    private Position position;

    public Hero(int x, int y) {
        super(x, y);
        position = new Position(x, y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position pos) {
        this.position = pos;
    }
    public Position moveUp()    { return new Position(position.getX(), position.getY()-1); }
    public Position moveDown()  { return new Position(position.getX(), position.getY()+1); }
    public Position moveRight() { return new Position(position.getX()+1, position.getY()); }
    public Position moveLeft()  { return new Position(position.getX()-1, position.getY()); }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#001199"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "*");
    }
}
