public class Cart {
    int amount;
    Product products[];

    Cart(Product p[], int a){
        amount = a;
        products = p;
    }

    void addTo(Product t, int k) throws NonexistentPlaceException{
        if (k < 0 || k >= amount){
            throw new NonexistentPlaceException("No such place in the cart!");
        }
        products[k] = t;
    }

    double totalPrice(){
        double sum = 0;
        for (int i = 0; i < amount; i++){
            sum += products[i].getCostPrice();
        }
        return sum;
    }

    void print(){
        for (int i = 0; i < amount; i++){
            System.out.println(products[i].getTitle());
            System.out.println(products[i].getCostPrice());
            System.out.println(products[i].getWeight());
            System.out.println(products[i].getCategory());
        }
        System.out.println(amount);
    }
}
