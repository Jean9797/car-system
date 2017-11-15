import org.junit.Test;

import static org.junit.Assert.*;

public class OptionsParserTest {
    @Test
    public void parse() throws Exception {
        MoveDirection[] properResult = {MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Backward, MoveDirection.Backward,
                MoveDirection.Left, MoveDirection.Left, MoveDirection.Right, MoveDirection.Right};

        String[] input = {"f", "forward", "backward", "b", "left", "l", "r", "right"};

        assertEquals(properResult, OptionsParser.parse(input));

    }

}