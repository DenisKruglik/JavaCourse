public abstract class Item {
    private int price;
    Item(){
        this.price = 0;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
