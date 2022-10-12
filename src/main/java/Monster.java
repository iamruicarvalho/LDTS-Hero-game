import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    private final Position position;
    public Monster(int x, int y) {
        super(x, y);
        this.position = new Position(x, y);
    }
    public Position getPosition() {
        return position;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF5555"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
    public Position move(Arena arena){
        Random random = new Random();
        while(true) {
            Position ret = new Position(this.getPosition().getX() + random.nextInt(3) - 1, this.getPosition().getY() + random.nextInt(3) - 1);
            if(ret.getX() > 0 && ret.getX() < arena.getWidth()-1 && ret.getY() > 0 && ret.getY() < arena.getHeight()-1)
                return ret;
        }
    }
}
