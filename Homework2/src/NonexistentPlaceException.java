public class NonexistentPlaceException extends Exception {
    String message;

    NonexistentPlaceException(String m){
        message = m;
    }

    public String getMessage() {
        return message;
    }
}
