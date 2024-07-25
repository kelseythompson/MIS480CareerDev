// create class, Time
public class Time {
    private int hours;
    private int minutes;
    private String meridian;

    // set time 
    public Time(int hours, int minutes, String meridian) throws InvalidTimeException{
        Interval intervalHours = new Interval(0, 12);
        Interval intervalMinutes = new Interval(0, 59);

        if (!intervalHours.within(hours)) {
            throw new InvalidTimeException("the hours you entered is invalid " + hours);
        }
        if (!intervalMinutes.within(minutes)) {
            throw new InvalidTimeException("the minutes you entered is invalid " + minutes);
        }
        if (!meridian.trim().equalsIgnoreCase("pm")){
            if(!meridian.trim().equalsIgnoreCase("am")) {
        
         throw new InvalidTimeException("the meridian you entered is invalid " + meridian);
        }
        }
        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;

    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }


    public Time(String time) throws InvalidTimeException {//2:00 pm
        //input validation of time input from user
        this(Integer.parseInt(time.split(":")[0].trim()), Integer.parseInt(time.split(":")[1].trim().split(" ")[0].trim()), time.split(" ")[1].trim());

    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getMeridian() {
        return meridian;
    }

    public static Time difference(Time t1, Time t2) {
        int t1_hours = convertTime(t1);
        int t2_hours = convertTime(t2);
        int t1TotalMinutes = t1_hours * 60 + t1.minutes;
        int t2TotalMinutes = t2_hours * 60 + t2.minutes;

        int diffMinutes = Math.abs(t1TotalMinutes - t2TotalMinutes);

        int diffHours = diffMinutes / 60;
        diffMinutes = diffMinutes % 60;

        return new Time(diffHours, diffMinutes);

    }

    // tostring: returns the object as a string
    public String toString() {
        return String.format("%02d:%02d %s", hours, minutes, (this.meridian != null ? this.meridian.toUpperCase() : ""));
    }

    public static int convertTime(Time time) {
        if (time.getMeridian().equalsIgnoreCase("pm") && time.getHours() != 12) {
            return time.hours + 12;
        } else if (time.getMeridian().equalsIgnoreCase("am") && time.getHours() == 12) {
            return 0;
        }
        return time.getHours();
    }

    public int compareTo(Time o) {
        int newThisTime = convertTime(this);
        int newOTime = convertTime(o);

//        out.println("O = "+newOTime + " this = "+newThisTime);

        if (newThisTime > newOTime) {

            if (meridian.equalsIgnoreCase("pm") || (meridian.equalsIgnoreCase("am") && o.getMeridian().equalsIgnoreCase("am"))) {
                if (minutes >= o.minutes)
                    return 1;

                return 1;
            }
            return -1;

        } else if (newThisTime == newOTime && minutes == o.getMinutes()) {
            if ((meridian.equalsIgnoreCase("am") && o.meridian.equalsIgnoreCase("am")) || (meridian.equalsIgnoreCase("pm") && o.meridian.equalsIgnoreCase("pm"))) {

                return 0;
            }
            if ((meridian.equalsIgnoreCase("pm"))) {

                return 1;
            } else {
                return -1;
            }
        }
        return -1;
    }
}


