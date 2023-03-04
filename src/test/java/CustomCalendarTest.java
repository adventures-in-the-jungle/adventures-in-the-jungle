import io.github.adventures_in_the_jungle.logic.game.Commands;
import org.junit.jupiter.api.Test;

public class CustomCalendarTest {

    @Test
    public void CustomCalendarTest() {

        String output = Commands.GetCommandFeedback(Commands.TIME);

        System.out.println(output);

        if (output.contains("日本標準時")) assert true;
        else assert false;

    }
}
