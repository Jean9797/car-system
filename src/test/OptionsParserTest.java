import org.junit.Test;

import static org.junit.Assert.*;

public class OptionsParserTest {
    @Test
    public void parse() throws Exception {
        MoveDirection[] properResult = {MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Backward, MoveDirection.Backward,
                MoveDirection.Left, MoveDirection.Left, MoveDirection.Right, MoveDirection.Right};

        String[] input = {"f", "asfq", "forward", "backward", "vvvv", "b", "left", "g", "l", "r", "right"};

        assertEquals(properResult, OptionsParser.parse(input));

    }

}