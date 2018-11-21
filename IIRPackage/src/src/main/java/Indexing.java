package src.main.java;
//Preprocessing
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import opennlp.tools.stemmer.PorterStemmer;

class Postings {
    private int docID;
    private int frequency;

    public Postings(int docID, int frequency) {
            this.docID = docID;
            this.frequency = frequency;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
                
                
}

public class Indexing {
    static Map<String, List<Postings>> index = new HashMap<String, List<Postings>>();
    static String directory = "D:\\Adithya\\IIR\\CourseRecommender-updated-master\\IIRPackage\\data\\";
    static List<String> fileNames = new ArrayList<>();
    static Set<String > words = new HashSet<>();
    static List<String> titles= new ArrayList<String>();
    static String special = "[^a-zA-Z0-9\\s+]";
    static PorterStemmer porterStemmer = new PorterStemmer();
    static StopWords stopwords = StopWords.getInstance();
    static Set<String> stopWordSet = stopwords.getStopWords();
    BufferedReader bufferedReader;
    
//    public static void main(String args[]) throws Exception{
//        try {
//            Indexing idx = new Indexing();
//            for(int i=1; i<=26; i++) {
//                    idx.indexFile(i);
//            }
//            idx.search(Arrays.asList(args[0].split(",")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    
    public boolean indexFile(int i) 
            throws FileNotFoundException, IOException {
        int pos = 0;
        List<String> terms;
        String overview, title, file = directory+i+".txt";
        //System.out.println("File being read = " + file);
        fileNames.add(i+".txt"); 
        
        bufferedReader = new BufferedReader(new FileReader(file));
        //System.out.println("File reader = " + bufferedReader);
            if((title = bufferedReader.readLine()) != null) {
                title = title.toLowerCase();
                titles.add(title);
                //System.out.println("Title being read= " + title);
                while((overview = bufferedReader.readLine()) != null ) {
                    if(overview.equals("\n") || overview.equals("") || overview.length() == 0) {
                        continue;
                    }
                    overview = overview.replaceAll(special, "");
                    overview = overview.toLowerCase();
                    terms = new ArrayList<>(Arrays.asList(overview.split(" ")));
                    //System.out.println("Special chars removed...");
                    for(String term : terms) {
                        if(!stopWordSet.contains(term)) {
                            pos++;
                            String stemmed = porterStemmer.stem(term);
                            words.add(stemmed);
                            //System.out.println("Stemming and stopword removal complete");
                            List<Postings> idx = index.get(stemmed);
                            if (idx == null) {
                                idx = new LinkedList<>();
                                index.put(stemmed, idx);
                            }
                            idx.add(new Postings(i, pos));
                            //stemmedWords.add(stemmed);
                        }
                    }
                }
                //System.out.println("Index created");
                bufferedReader.close();
                return true;        
        } 
        System.out.println("Problem in reading file..."); 
        return false;
    }
    
    public String search(List<String> words) {
                String output="";
		for (String iter : words) {
			Set<String> answer = new HashSet<>();
			String word = iter.toLowerCase();
			List<Postings> idx = index.get(word);
			if (idx != null) {
                            for(Postings t : idx){
                                //System.out.println("t.getDocID() =" + t.getDocID());
                                answer.add(fileNames.get(t.getDocID()-1));
                                answer.add(" "+t.getFrequency());
                            } 
			}
			output += word;
                        for(String f:answer){
                            output += ("" + f);
                        }
                        output += "\n";
		}
                //System.out.println("output = " + output);
                return output;
	}
    
    public static void stemming(Set<String> words) 
            throws Exception {        
        List<String> stemmedWords = new ArrayList<>();
        PorterStemmer porterStemmer = new PorterStemmer();
        words.forEach(word -> {
            String stemmed = porterStemmer.stem(word);
            stemmedWords.add(stemmed);
            //System.out.println("Stemmed word : " + stemmed + " from the given word : " + word);
        });
    }
    
     public static void stopwordsRemoval(Set<String> words) 
             throws Exception {
        StopWords stopwords = StopWords.getInstance();
        Set<String> stopWord = stopwords.getStopWords();
        words.removeAll(stopWord);
    }
    
}
