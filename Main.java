// import org.junit.jupiter.api.Test;
import java.util.*;
public class Main{
    // import static org.junit.jupiter.api.Assertions.assertEquals;
    public static void main(String[] args)throws InvalidTimeException {
    // create scanner object(prompt input from user)
    Scanner scan=new Scanner(System.in);
    System.out.println("Please Enter Day Start Time in 00:00: "); //3:00

    String startTime=scan.nextLine();
    Time time1 = new Time(startTime);
//   println("Please Enter Day End Time')

    System.out.println("Please enter bed time 00:00:  ");
    String endTime=scan.nextLine();
    Time time2 = new Time(endTime);

// calculate the total time of waking hours
    Time totalDayTime = Time.difference(time1, time2);

    System.out.println("Wake-up Time is: "+startTime);
         //get activity names, times and durations in arraylist

    System.out.println("Please enter the list of activities for the day: (press Enter to continue or x to quit ) ");

    List<Activity> activities = new ArrayList();
    double totalTime=0;
    while(true){
        System.out.println("Please enter The activityName: ");
        String activityName=scan.nextLine();
        System.out.println("Please enter startTime: ");
        startTime=scan.nextLine();
        System.out.println("Please enter endTime: ");
        endTime=scan.nextLine();
        //store activity names, times and durations in arraylist
        activities.add(new Activity(startTime, endTime, activityName));
        Time currentTime= Time.difference(new Time(startTime), new Time(endTime));

        totalTime += currentTime.getHours()+ (currentTime.getMinutes()/60);
         System.out.println("Would you like to continue (Y/X): ");
        String decision =scan.nextLine();

        if(decision.equalsIgnoreCase("x")){
            break;
        }


    }

    System.out.println("Total hours for the day is: "+ Time.difference(time1, time2));

    double timeleft = (totalDayTime.getHours()+ (totalDayTime.getMinutes()/60) - totalTime);
    if(timeleft > 0)
        System.out.println("You have "+ timeleft+" hours left in the day to spend with your children.");
    else
        System.out.println("You have no more time left for the day.");
        // code above calculates the input from user
  }

}
