package Game;

public abstract class PickableItem extends Item{
    private int price;
    PickableItem(String title, int price){
        super(title);
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}
