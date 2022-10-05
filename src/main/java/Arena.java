import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class Arena {
    private final int width;
    private final int height;
    private final Hero hero;

    public Arena(int width, int height) {
        hero = new Hero(10, 10);
        this.width = width;
        this.height = height;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
    }
    public boolean canHeroMove(Position position) {
        return (position.getX() < width && position.getY() < height);       //true or false
    }
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
        //System.out.println(hero.getX());
        //System.out.println(hero.getY());
    }
    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> { moveHero(hero.moveUp());}
            case ArrowDown  -> { moveHero(hero.moveDown()); }
            case ArrowRight -> { moveHero(hero.moveRight()); }
            case ArrowLeft  -> { moveHero(hero.moveLeft()); }
            default -> { }
        }
    }
}
