public class StackArray {
    private Word arr[];
    private int size;
    private int last;

    StackArray(){
        this.arr = new Word[0];
        this.size = 0;
        this.last = -1;
    }

    public void push(Word el){
        if (this.size - this.last <= 1){
            Word w[] = this.arr;
            this.arr = new Word[++this.size];
            for (int i = 0; i < w.length; i++){
                this.arr[i] = w[i];
            }
        }
        this.arr[++this.last] = el;
    }

    public int getElementsAmount(){
        return this.last + 1;
    }

    public Word pop() throws NoElementsException{
        if (this.last < 0){
            throw new NoElementsException("The stack is empty!");
        }
        return this.arr[this.last--];
    }
}
