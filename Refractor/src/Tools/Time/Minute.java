package Tools.Time;

public class Minute implements Ticker {
    private int minutes;

    public Minute(){
        minutes = 0;
    }

    public Minute(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String toString(){
        if(minutes < 10){
            return "0"+ minutes;
        }
        else return ""+ minutes;
    }

    public void tick(){
        minutes++;
    }
}
