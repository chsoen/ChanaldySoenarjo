import Tools.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTests {
    Time time;

    @Before
    public void setup(){
        time = new Time();

    }

    @Test
    public void testTick(){
        time.addMin(62);
        assertEquals("1:2:0",time.toString());
        time.addHr(25);
        assertEquals("2:2:0", time.toString());
        time.addSec(70);
        assertEquals("2:3:10", time.toString());
    }
}
