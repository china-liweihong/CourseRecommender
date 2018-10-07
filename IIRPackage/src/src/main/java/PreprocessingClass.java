package src.main.java;
//Preprocessing
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;*/
import opennlp.tools.stemmer.PorterStemmer;

public class PreprocessingClass {
    
    static String file = "D:\\Adithya\\IIR\\lotr.txt";
    static Set<String > words = new HashSet<>();
    static String special = "[^a-zA-Z0-9\\s+]";
    
    public static void preprocessor() throws Exception {
        
        try {
            readFile();         
            testStopwords(words);
            testStemming(words);
            System.out.println("words = \n" + words);
        } catch (Exception ex) {
            Logger.getLogger(PreprocessingClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readFile() throws FileNotFoundException, IOException {
        
        String line;
        List<String> terms;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while((line = bufferedReader.readLine()) != null ) {
            if(line == "\n" || line == "" || line.length() == 0) {
                continue;
            }
            line = line.replaceAll(special, "");
            terms = new ArrayList<>(Arrays.asList(line.split(" ")));
            words.addAll(terms);
        }
        bufferedReader.close();
    }
    
    public static void testStemming(Set<String> words) 
            throws Exception {
        
        List<String> stemmedWords = new ArrayList<>();
        PorterStemmer porterStemmer = new PorterStemmer();
        words.forEach(word -> {
            String stemmed = porterStemmer.stem(word);
            stemmedWords.add(stemmed);
            //System.out.println("Stemmed word : " + stemmed + " from the given word : " + word);
        });
    }
    
     public static void testStopwords(Set<String> words) throws Exception {

        StopWords stopwords = StopWords.getInstance();
        Set<String> stopWord = stopwords.getStopWords();
        //System.out.println("Stopwords to be removed are : " + stopWord);
        words.removeAll(stopWord);
    }
    
}
