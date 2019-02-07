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

    public void addHr(int hr) {
        this.hr = getHr() + hr % 24;
    }

    public void addMin(int min) {
        this.min = getMin() + min % 60;
        this.hr = getHr() + min / 60;
    }

    public void addSec(int sec) {
        this.sec = getSec() + sec % 60;
        this.min = getMin() + (sec / 60) % 60;
        this.hr = getHr() + sec / 3600;
    }

    @Override
    public String toString() {
        return hr + ":" + min + ":" + sec;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Time.class) {
            Time time = ((Time) obj);
            return this.hr == time.hr && this.min == time.min && this.sec == time.sec;
        }
        return false;
    }
}