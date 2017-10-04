public class NegativeNumberException extends Exception {
    String message;

    NegativeNumberException(String m){
        message = m;
    }

    public String getMessage(){
        return message;
    }
}
