public class Text {
    private String text;

    Text(String text){
        this.text = text.trim();
    }

    public int getLength(){
        return this.text.length();
    }

    public int getWordsAmount(){
        return this.text.split("\\s+").length;
    }

    public Word getWord(int n){
        try{
            return new Word(this.text.split("\\s+")[n], PartOfSpeech.UNKNOWN);
        }catch(IncorrectWordException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Word[] getWords(){
        String w[] = this.text.split("\\s+");
        Word words[] = new Word[w.length];
        for (int i = 0; i < w.length; i++){
            try{
                words[i] = new Word(w[i], PartOfSpeech.UNKNOWN);
            }catch(IncorrectWordException e){
                System.out.println(e.getMessage());
            }
        }
        return words;
    }

    public void printMostFrequentWord(){
        String words[] = this.text.split("\\s+");
        String w, fr = "";
        int max = 0, counter;
        for (int i = 0; i < words.length; i++){
            if (words[i] == null){
                continue;
            }
            counter = 1;
            w = words[i];
            words[i] = null;
            for (int j = i+1; j < words.length; j++){
                if (words[j] == null){
                    continue;
                }
                if (words[j].equalsIgnoreCase(w)){
                    counter++;
                    words[j] = null;
                }
//                System.out.println(words[j].toLowerCase() + " (" + words[j].toLowerCase().length() + ") == " + w.toLowerCase() + " (" + w.toLowerCase().length() + ") - " + (words[j].toLowerCase() == w.toLowerCase()) );
//                System.out.println(words[j].equalsIgnoreCase(w));
            }
            if (counter > max){
                max = counter;
                fr = w;
            }
        }
        System.out.println(fr);
        System.out.println(max);
    }
}
