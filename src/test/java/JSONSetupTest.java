import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;

import org.junit.Test;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JSONSetupTest {

    @Test
    public void JSONSetupTest() {
        Game game = Game.getInstance();
        Setup.JSONSetup(game);
        assert true;
    }

}
