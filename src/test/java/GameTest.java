import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testOnePlayerStronger(){
        Player Scorp = new Player(1, "Scorpion", 50);
        Player Sub = new Player(2, "Sub-Zero", 45);
        Game game = new Game();

        game.register(Scorp);
        game.register(Sub);

        int actual = game.round("Scorpion", "Sub-Zero");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void testSecondPlayerStronger(){
        Player Scorp = new Player(1, "Scorpion", 50);
        Player Sub = new Player(2, "Sub-Zero", 55);
        Game game = new Game();

        game.register(Scorp);
        game.register(Sub);

        int actual = game.round("Scorpion", "Sub-Zero");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void testBothPlayersStronger(){
        Player Scorp = new Player(1, "Scorpion", 50);
        Player Sub = new Player(2, "Sub-Zero", 50);
        Game game = new Game();

        game.register(Scorp);
        game.register(Sub);

        int actual = game.round("Scorpion", "Sub-Zero");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void testNotRegistredOnePlayer(){
        Player Scorp = new Player(1, "Scorpion", 50);
        Player Sub = new Player(2, "Sub-Zero", 50);
        Game game = new Game();

        game.register(Scorp);
        game.register(Sub);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Kabal","Sub-Zero"));
    }
    @Test
    public void testNotRegistredSecondPlayer(){
        Player Scorp = new Player(1, "Scorpion", 50);
        Player Sub = new Player(2, "Sub-Zero", 50);
        Game game = new Game();

        game.register(Scorp);
        game.register(Sub);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Scorpion","Baraka"));
    }

}