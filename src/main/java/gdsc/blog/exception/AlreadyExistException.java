package gdsc.blog.exception;

public class AlreadyExistException extends RuntimeException{
    private final String message = "Field Already Exist";

    public AlreadyExistException(String message){
        super(message);
    }
}