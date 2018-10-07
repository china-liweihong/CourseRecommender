package src.main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StopWords {
    
    private Map<String, Boolean> stopWords;
    private static StopWords instance;
 	
    public StopWords()
    {
        stopWords = new HashMap<>();
        stopWords.put("0", true);
        stopWords.put("1", true);
        stopWords.put("2", true);
        stopWords.put("3", true);
        stopWords.put("4", true);
        stopWords.put("5", true);
        stopWords.put("6", true);
        stopWords.put("7", true);
        stopWords.put("8", true);
        stopWords.put("9", true);

        stopWords.put("a", true);
        stopWords.put("about", true);
        stopWords.put("above", true);
        stopWords.put("after", true);
        stopWords.put("again", true);
        stopWords.put("against", true);
        stopWords.put("all", true);
        stopWords.put("am", true);
        stopWords.put("an", true);
        stopWords.put("and", true);
        stopWords.put("any", true);
        stopWords.put("are", true);
        stopWords.put("aren't", true);
        stopWords.put("as", true);
        stopWords.put("at", true);
        stopWords.put("be", true);
        stopWords.put("because", true);
        stopWords.put("been", true);
        stopWords.put("before", true);
        stopWords.put("being", true);
        stopWords.put("below", true);
        stopWords.put("between", true);
        stopWords.put("both", true);
        stopWords.put("but", true);
        stopWords.put("by", true);
        stopWords.put("can't", true);
        stopWords.put("cannot", true);
        stopWords.put("could", true);
        stopWords.put("couldn't", true);
        stopWords.put("did", true);
        stopWords.put("didn't", true);
        stopWords.put("do", true);
        stopWords.put("does", true);
        stopWords.put("doesn't", true);
        stopWords.put("doing", true);
        stopWords.put("don't", true);
        stopWords.put("down", true);
        stopWords.put("during", true);
        stopWords.put("each", true);
        stopWords.put("few", true);
        stopWords.put("for", true);
        stopWords.put("from", true);
        stopWords.put("further", true);
        stopWords.put("had", true);
        stopWords.put("hadn't", true);
        stopWords.put("has", true);
        stopWords.put("hasn't", true);
        stopWords.put("have", true);
        stopWords.put("haven't", true);
        stopWords.put("having", true);
        stopWords.put("he", true);
        stopWords.put("he'd", true);
        stopWords.put("he'll", true);
        stopWords.put("he's", true);
        stopWords.put("her", true);
        stopWords.put("here", true);
        stopWords.put("here's", true);
        stopWords.put("hers", true);
        stopWords.put("herself", true);
        stopWords.put("him", true);
        stopWords.put("himself", true);
        stopWords.put("his", true);
        stopWords.put("how", true);
        stopWords.put("how's", true);
        stopWords.put("i", true);
        stopWords.put("i'd", true);
        stopWords.put("i'll", true);
        stopWords.put("i'm", true);
        stopWords.put("i've", true);
        stopWords.put("if", true);
        stopWords.put("in", true);
        stopWords.put("into", true);
        stopWords.put("is", true);
        stopWords.put("isn't", true);
        stopWords.put("it", true);
        stopWords.put("it's", true);
        stopWords.put("its", true);
        stopWords.put("itself", true);
        stopWords.put("let's", true);
        stopWords.put("me", true);
        stopWords.put("more", true);
        stopWords.put("most", true);
        stopWords.put("mustn't", true);
        stopWords.put("my", true);
        stopWords.put("myself", true);
        stopWords.put("no", true);
        stopWords.put("nor", true);
        stopWords.put("not", true);
        stopWords.put("of", true);
        stopWords.put("off", true);
        stopWords.put("on", true);
        stopWords.put("once", true);
        stopWords.put("only", true);
        stopWords.put("or", true);
        stopWords.put("other", true);
        stopWords.put("ought", true);
        stopWords.put("our", true);
        stopWords.put("ours ", true);
        stopWords.put(" ourselves", true);
        stopWords.put("out", true);
        stopWords.put("over", true);
        stopWords.put("own", true);
        stopWords.put("same", true);
        stopWords.put("shan't", true);
        stopWords.put("she", true);
        stopWords.put("she'd", true);
        stopWords.put("she'll", true);
        stopWords.put("she's", true);
        stopWords.put("should", true);
        stopWords.put("shouldn't", true);
        stopWords.put("so", true);
        stopWords.put("some", true);
        stopWords.put("say", true);
        stopWords.put("said", true);
        stopWords.put("such", true);
        stopWords.put("than", true);
        stopWords.put("that", true);
        stopWords.put("that's", true);
        stopWords.put("the", true);
        stopWords.put("their", true);
        stopWords.put("theirs", true);
        stopWords.put("them", true);
        stopWords.put("themselves", true);
        stopWords.put("then", true);
        stopWords.put("there", true);
        stopWords.put("there's", true);
        stopWords.put("these", true);
        stopWords.put("they", true);
        stopWords.put("they'd", true);
        stopWords.put("they'll", true);
        stopWords.put("they're", true);
        stopWords.put("they've", true);
        stopWords.put("this", true);
        stopWords.put("those", true);
        stopWords.put("through", true);
        stopWords.put("to", true);
        stopWords.put("too", true);
        stopWords.put("under", true);
        stopWords.put("until", true);
        stopWords.put("up", true);
        stopWords.put("very", true);
        stopWords.put("was", true);
        stopWords.put("wasn't", true);
        stopWords.put("we", true);
        stopWords.put("we'd", true);
        stopWords.put("we'll", true);
        stopWords.put("we're", true);
        stopWords.put("we've", true);
        stopWords.put("were", true);
        stopWords.put("weren't", true);
        stopWords.put("what", true);
        stopWords.put("what's", true);
        stopWords.put("when", true);
        stopWords.put("when's", true);
        stopWords.put("where", true);
        stopWords.put("where's", true);
        stopWords.put("which", true);
        stopWords.put("while", true);
        stopWords.put("who", true);
        stopWords.put("who's", true);
        stopWords.put("whom", true);
        stopWords.put("why", true);
        stopWords.put("why's", true);
        stopWords.put("with", true);
        stopWords.put("won't", true);
        stopWords.put("would", true);
        stopWords.put("wouldn't", true);
        stopWords.put("you", true);
        stopWords.put("you'd", true);
        stopWords.put("you'll", true);
        stopWords.put("you're", true);
        stopWords.put("you've", true);
        stopWords.put("your", true);
        stopWords.put("yours", true);
        stopWords.put("yourself", true);
        stopWords.put("yourselves ", true);
    }

    public boolean isStopWord(String s)
    {
        boolean ret = stopWords.get(s);
        if(s.length()==1) ret = true;
        return ret;
    }
    
    public  Set<String> getStopWords() {
        return stopWords.keySet();
    }

    public static StopWords getInstance()
    {
		if(instance == null)
			instance = new StopWords();
		return instance;	
    } 
}
    

