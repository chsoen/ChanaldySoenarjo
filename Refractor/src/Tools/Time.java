package Tools;

public class Time {
    private int hr;
    private int min;
    private int sec;

    public Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
    }

    public Time(Time time) {
        this.hr = time.getHr();
        this.min = time.getMin();
        this.sec = time.getSec();
    }

    public Time() {
        this.hr = 0;
        this.min = 0;
        this.sec = 0;
    }

    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    /*
    Requires: int hr
    Modifies: This
    Effects: Adds hours to clock.
     */
    public void addHr(int hr) {
        this.hr = getHr() + hr % 24;
    }

    /*
    Requires: int min
    Modifies: This
    Effects: Adds minutes to clock. If over an hour, adds to hr and min.
     */
    public void addMin(int min) {
        this.min = getMin() + min % 60;
        this.hr = getHr() + min / 60;
    }

    /*
    Requires: int sec
    Modifies: This
    Effects: Adds seconds to clock. If over a minute, adds to min and sec, if over an hour, adds to hour
    min and sec.
     */
    public void addSec(int sec) {
        this.sec = getSec() + sec % 60;
        this.min = getMin() + (sec / 60) % 60;
        this.hr = getHr() + sec / 3600;
    }

    @Override
    public String toString() {
        return hr + ":" + min + ":" + sec;
    }

    /*
    Requires: Object obj
    Effects: Returns true if this and obj have the same hours, minutes, and seconds.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Time.class) {
            Time time = ((Time) obj);
            return this.hr == time.hr && this.min == time.min && this.sec == time.sec;
        }
        return false;
    }
}