import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    public Arena(int width, int height) {
        hero = new Hero(10, 10);
        this.width = width;
        this.height = height;
    }
    public void draw(Screen screen) throws IOException {
        screen.clear();
        screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
    public boolean canHeroMove(Position position) {
        if (position.getX() < width && position.getY() < height) {
            System.out.println("fit");
            return true;
        }
        return false;
    }
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
        System.out.println(hero.getX());
        System.out.println(hero.getY());
    }
    public void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> { moveHero(hero.moveUp()); break; }
            case ArrowDown  -> { moveHero(hero.moveDown()); break; }
            case ArrowRight -> { moveHero(hero.moveRight()); break; }
            case ArrowLeft  -> { moveHero(hero.moveLeft()); break; }
            default -> { break; }
        }
    }
}
