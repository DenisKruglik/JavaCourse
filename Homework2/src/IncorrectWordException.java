public class IncorrectWordException extends Exception {
    String message;

    IncorrectWordException(String m){
        this.message = m;
    }

    public String getMessage(){
        return this.message;
    }
}
