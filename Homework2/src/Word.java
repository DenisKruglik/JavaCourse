public class Word {
    private final String word;
    private final PartOfSpeech partOfSpeech;

    Word(String word, PartOfSpeech partOfSpeech) throws IncorrectWordException{
        if (word.isEmpty()){
            throw new IncorrectWordException("The word is empty!");
        }else if (word.trim().split("\\s+").length > 1){
            throw new IncorrectWordException("String contains more than 1 word!");
        }
        this.word = word;
        this.partOfSpeech = partOfSpeech;
    }

    public String getWord(){
        return this.word;
    }

    public int getLength(){
        return this.word.length();
    }

    public PartOfSpeech getPartOfSpeech(){
        return this.partOfSpeech;
    }
}
