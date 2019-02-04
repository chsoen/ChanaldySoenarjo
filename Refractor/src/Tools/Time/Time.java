package Tools.Time;

public class Time implements Ticker{
    private int hr;
    private int min;
    private int sec;

    public Time(){
        this.hr = 0;
        this.min = 0;
        this.sec = 0;
    }

    public Time(int hr, int min, int sec){
        this.hr = hr;
        this.min = min;
        this.sec = sec;
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

    public int getHr(){
        return hr + min/60 + sec/3600;
    }

    public int getMin(){
        return hr*60 + min + sec/60;
    }

    public int getSec(){
        return hr*3600 + min * 60 + sec;
    }

    public void tick(){
        int tick = getSec() + 1;
        hr = tick/3600;
        min = (tick%3600)/60;
        sec = ((tick%3600)%60);
    }

    @Override
    public String toString(){
        return hr+":"+min+":"+sec;
    }
}