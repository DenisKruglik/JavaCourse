public class Product {
    private String title;
    private double costPrice;
    private double weight;
    private ProductType category;

    Product(String t, double c, double w, ProductType cat){
        title = t;
        costPrice = c;
        weight = w;
        category = cat;
    }

    String getTitle(){
        return title;
    }

    double getCostPrice(){
        return costPrice;
    }

    double getWeight(){
        return weight;
    }

    ProductType getCategory(){
        return category;
    }

    void setTitle(String t){
        title = t;
    }

    void setCostPrice(double c){
        costPrice = c;
    }

    void setWeight(double w){
        weight = w;
    }

    void setCategory(ProductType cat){
        category = cat;
    }

    double pricePerKilogram(){
        return costPrice/weight;
    }

    void print(){
        System.out.println(title);
        System.out.println(costPrice);
        System.out.println(weight);
        System.out.println(category);
    }
}
