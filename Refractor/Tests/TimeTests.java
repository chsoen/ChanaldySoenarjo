import Tools.Time.Time;
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
        time.tick();
        assertEquals(1,time.getSec());
        time.setSec(20);
        time.tick();
        assertEquals(21, time.getSec());
        Time time2 = new Time(10,20,59);
        assertEquals(37259,time2.getSec());
        time2.tick();
        assertEquals(time2.toString(), "10:21:0");
    }
}
