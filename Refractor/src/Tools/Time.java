package Tools;

public class Time {
    private int hr;
    private int min;
    private int sec;

    public Time() {
        this.hr = 0;
        this.min = 0;
        this.sec = 0;
    }

    public Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr % 24;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min % 60;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec % 60;
    }

    @Override
    public String toString() {
        return hr + ":" + min + ":" + sec;
    }
}