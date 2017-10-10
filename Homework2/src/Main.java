public class Main {
    public static void main(String args[]){
//        problem1();
//        problem2();
//        problem3();
        problem4();
    }

    public static void problem1(){
        Circle c, c1, c2;
        try{
            c = new Circle(3.0);
            c1 = new Circle(2, 4, 0);
            c2 = new Circle(8, 0);
            System.out.println(c.isIntersected(c1));
            System.out.println(c.isIntersected(c2));
        }catch (InvalidShapeParametresException e){
            System.out.println(e.getMessage());
        }

        Triangle t, t1, t2;
        try{
            t = new Triangle(0,0,3,0,0,4);
            t1 = new Triangle(1,1,3,3,7,1);
            t2 = new Triangle(0,0,1,1,2,0);
            System.out.println(t.getPerimeter());
            System.out.println(t.getSquare());
            System.out.println(t.getType());
            System.out.println(t1.getPerimeter());
            System.out.println(t1.getSquare());
            System.out.println(t1.getType());
            System.out.println(t2.getPerimeter());
            System.out.println(t2.getSquare());
            System.out.println(t2.getType());
        }catch (InvalidShapeParametresException e){
            System.out.println(e.getMessage());
        }
    }

    public static void problem2(){
        Product p1 = new Product("Shirt", 100, 0.1, ProductType.CLOTHES), p2 = new Product("Fridge", 300,100, ProductType.APPLIANCES);
        System.out.println(p1.pricePerKilogram());
        p2.print();
        Product p[] = {p1, p2};
        Cart c = new Cart(2);
        System.out.println(c.totalPrice());
        try{
            c.addTo(p1, 0);
//            c.addTo(new Product("Xiaomi", 200, 0.1, ProductType.ELECTRONICS), 1);
        }catch(NonexistentPlaceException e){
            System.out.println(e);
        }
        c.print();
    }

    public static void problem3(){
        Word w;
        try{
            w = new Word("carrot", PartOfSpeech.NOUN);
            System.out.println(w.getLength());
            System.out.println(w.getPartOfSpeech());
        }catch(IncorrectWordException e){
            System.out.println(e.getMessage());
        }
        Text t = new Text(" Air     trees water animals water   ");
        System.out.println(t.getLength());
        System.out.println(t.getWordsAmount());
        System.out.println(t.getWord(1).getWord());
        Word w1[] = t.getWords();
        for (int i = 0; i < w1.length; i++){
            System.out.println(w1[i].getWord());
        }
        t.printMostFrequentWord();
    }

    public static void problem4(){
        StackArray s = new StackArray();
        try{
            s.push(new Word("rabbit", PartOfSpeech.NOUN));
            s.push(new Word("fly", PartOfSpeech.VERB));
            s.push(new Word("naturally", PartOfSpeech.ADVERB));
        }catch(IncorrectWordException e){
            System.out.println(e.getMessage());
        }
        System.out.println(s.getElementsAmount());
        try{
            System.out.println(s.pop().getWord());
        }catch(NoElementsException e){
            System.out.println(e.getMessage());
        }
        System.out.println(s.getElementsAmount());
        try{
            System.out.println(s.pop().getWord());
        }catch(NoElementsException e){
            System.out.println(e.getMessage());
        }
        System.out.println(s.getElementsAmount());
        try{
            s.push(new Word("brave", PartOfSpeech.ADJECTIVE));
        }catch(IncorrectWordException e){
            System.out.println(e.getMessage());
        }
        System.out.println(s.getElementsAmount());
        try{
            System.out.println(s.pop().getWord());
        }catch(NoElementsException e){
            System.out.println(e.getMessage());
        }
        System.out.println(s.getElementsAmount());
    }
}
