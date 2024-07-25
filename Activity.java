//write class
import java.util.*;
public class Activity{
  private String startTime; 
  private String endTime;
  private String activityName; 
  public Activity(String startTime, String endTime, String activityName){
  this.startTime = startTime;
  this.endTime = endTime;
  this.activityName = activityName;

}
  //return end time/starttime
  public String getActivityName() {
    return activityName;
}  public String getStartTime() {
  return startTime;
  }
  public String getEndTime(){return endTime;}
//setters for activity name
  public void setActivityName(String activityName) {
    this.activityName = activityName;
}
//setters start time
  public void setStartTime(String startTime) {
    this.startTime = startTime;
}
// setter end time
  public void setEndTime(String endTime) {
    this.endTime = endTime;
}

  }
// create class, time