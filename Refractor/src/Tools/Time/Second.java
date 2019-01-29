package Tools.Time;

public class Second implements Ticker {
    private int seconds;

    public Second(){
        seconds = 0;
    }

    public Second(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String toString(){
        if(seconds < 10){
            return "0"+ seconds;
        }
        else return ""+ seconds;
    }

    public void tick(){
        seconds++;
    }
}
