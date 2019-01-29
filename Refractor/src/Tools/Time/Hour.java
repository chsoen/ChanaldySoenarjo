package Tools.Time;

public class Hour implements Ticker {
    private int hours;

    public Hour(){
        hours = 0;
    }

    public Hour(int hours){
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String toString(){
        if(hours < 10){
            return "0"+ hours;
        }
        else return ""+ hours;
    }

    public void tick(){
        hours++;
    }
}
