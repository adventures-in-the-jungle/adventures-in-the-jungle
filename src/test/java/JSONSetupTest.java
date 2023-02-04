import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.junit.Test;

import java.io.FileNotFoundException;

public class JSONSetupTest {

    @Test
    public static void JSONSetupTest() {
        Game game = Game.getInstance();
        try {
            Setup.JSONSetup(game);
            assert true;
        } catch (FileNotFoundException e) {
            assert false;
            throw new RuntimeException(e);
        }
    }

}
