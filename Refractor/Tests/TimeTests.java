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
        time.setMin(62);
        assertEquals("0:2:0",time.toString());
        time.setHr(25);
        assertEquals("1:2:0", time.toString());
        time.setSec(70);
        assertEquals("1:2:10", time.toString());
    }
}
