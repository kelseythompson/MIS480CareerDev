// class for calculating the difference between all of the activities 
public class Interval {
    private int start;
    private int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    public boolean within(int e){
        return this.start<=e && this.end >=e;
    }

}