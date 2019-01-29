package Tools.Time;

public class Time implements Ticker {
    private Hour hr;
    private Minute min;
    private Second sec;

    public Time(){
        hr = new Hour();
        min = new Minute();
        sec = new Second();
    }

    public Time(Hour hr, Minute min, Second sec){
        this.hr = hr;
        this.min = min;
        this.sec = sec;
    }

    public Time(Time time){
        this.hr = time.hr;
        this.min = time.min;
        this.sec = time.sec;
    }

    public Hour getHr() {
        return hr;
    }

    public void setHr(Hour hr) {
        this.hr = hr;
    }

    public Minute getMin() {
        return min;
    }

    public void setMin(Minute min) {
        this.min = min;
    }

    public Second getSec() {
        return sec;
    }

    public void setSec(Second sec) {
        this.sec = sec;
    }

    public void tick(){
        sec.tick();
        if(sec.getSeconds() == 60){
            sec.setSeconds(0);
            min.tick();
            if(min.getMinutes() == 60){
                min.setMinutes(0);
                hr.tick();
                if(hr.getHours() == 24){
                    hr.setHours(0);
                }
            }
        }
    }

    public String toString(){
        return hr.toString()+":"+min.toString()+":"+sec.toString();
    }
}
