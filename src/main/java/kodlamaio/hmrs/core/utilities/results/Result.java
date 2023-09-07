package kodlamaio.hmrs.core.utilities.results;

public class Result {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

     public Result(boolean success) {
        this.success = success;
        
    }
    

    
    
}
