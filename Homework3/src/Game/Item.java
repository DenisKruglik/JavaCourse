package Game;

public abstract class Item {

    private String title;
    Item(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
