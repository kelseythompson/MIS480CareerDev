//exception upon the time class. Prompts user to correct.
public class InvalidTimeException extends Exception{
    private String message;
    public InvalidTimeException(String message){
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}