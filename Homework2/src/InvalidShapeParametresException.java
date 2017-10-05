public class InvalidShapeParametresException extends Exception {
    private String message;

    InvalidShapeParametresException(String m){
        message = m;
    }

    public String getMessage(){
        return message;
    }
}
