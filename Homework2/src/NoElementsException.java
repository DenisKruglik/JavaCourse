public class NoElementsException extends Exception {
    String message;
    NoElementsException(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
