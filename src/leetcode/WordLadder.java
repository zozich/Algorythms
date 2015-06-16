package leetcode;

import java.util.*;

public class WordLadder {

  public static void main(String[] args) {
    String start = "nape";
    String end = "mild";
    Set<String> dictionary = new HashSet<String>();
    Collections.addAll(dictionary, "dose", "ends", "dine", "jars", "prow", "soap", "guns", "hops", "cray", "hove", "ella", "hour", "lens", "jive", "wiry", "earl", "mara", "part", "flue", "putt", "rory", "bull", "york", "ruts", "lily", "vamp", "bask", "peer", "boat", "dens", "lyre", "jets", "wide", "rile", "boos", "down", "path", "onyx", "mows", "toke", "soto", "dork", "nape", "mans", "loin", "jots", "male", "sits", "minn", "sale", "pets", "hugo", "woke", "suds", "rugs", "vole", "warp", "mite", "pews", "lips", "pals", "nigh", "sulk", "vice", "clod", "iowa", "gibe", "shad", "carl", "huns", "coot", "sera", "mils", "rose", "orly", "ford", "void", "time", "eloy", "risk", "veep", "reps", "dolt", "hens", "tray", "melt", "rung", "rich", "saga", "lust", "yews", "rode", "many", "cods", "rape", "last", "tile", "nosy", "take", "nope", "toni", "bank", "jock", "jody", "diss", "nips", "bake", "lima", "wore", "kins", "cult", "hart", "wuss", "tale", "sing", "lake", "bogy", "wigs", "kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns", "will", "tart", "drug", "gale", "mold", "disk", "spay", "hows", "naps", "puss", "gina", "kara", "zorn", "boll", "cams", "boas", "rave", "sets", "lego", "hays", "judy", "chap", "live", "bahs", "ohio", "nibs", "cuts", "pups", "data", "kate", "rump", "hews", "mary", "stow", "fang", "bolt", "rues", "mesh", "mice", "rise", "rant", "dune", "jell", "laws", "jove", "bode", "sung", "nils", "vila", "mode", "hued", "cell", "fies", "swat", "wags", "nate", "wist", "honk", "goth", "told", "oise", "wail", "tels", "sore", "hunk", "mate", "luke", "tore", "bond", "bast", "vows", "ripe", "fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair", "tags", "cost", "woes", "buns", "lend", "bops", "code", "eddy", "siva", "oops", "toed", "bale", "hutu", "jolt", "rife", "darn", "tape", "bold", "cope", "cake", "wisp", "vats", "wave", "hems", "bill", "cord", "pert", "type", "kroc", "ucla", "albs", "yoko", "silt", "pock", "drub", "puny", "fads", "mull", "pray", "mole", "talc", "east", "slay", "jamb", "mill", "dung", "jack", "lynx", "nome", "leos", "lade", "sana", "tike", "cali", "toge", "pled", "mile", "mass", "leon", "sloe", "lube", "kans", "cory", "burs", "race", "toss", "mild", "tops", "maze", "city", "sadr", "bays", "poet", "volt", "laze", "gold", "zuni", "shea", "gags", "fist", "ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo", "hume", "yowl", "craw", "pied", "toga", "lobs", "love", "lode", "duds", "bled", "juts", "gabs", "fink", "rock", "pant", "wipe", "pele", "suez", "nina", "ring", "okra", "warm", "lyle", "gape", "bead", "lead", "jane", "oink", "ware", "zibo", "inns", "mope", "hang", "made", "fobs", "gamy", "fort", "peak", "gill", "dino", "dina", "tier");
    Date timeStart = new Date();
    System.out.println(new WordLadder().ladderLength(start, end, dictionary));
    Date timeEnd = new Date();
    System.out.println(timeEnd.getTime() - timeStart.getTime() + " ms");
  }

  private Set<String> visited = new HashSet<String>();
  private Set<Character> alphabet = new HashSet<Character>();
  private int counter = 1;

  {
    for (int i = 0; i < 26; i++) {
      alphabet.add((char) ('a' + i));
    }
  }

  public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
    if (beginWord.equals(endWord)) {
      return 1;
    }
    visited.add(beginWord);
    wordDict.add(endWord);
    Set<String> words = changeOneLetterOptions(beginWord, wordDict);
    Set<String> nextTierWords = new HashSet<String>();
    while (!words.isEmpty()) {
      counter++;
      for (String word : words) {
        visited.add(word);
        if (word.equals(endWord)) {
          return counter;
        } else {
          nextTierWords.addAll(changeOneLetterOptions(word, wordDict));
        }
      }
      words.clear();
      words.addAll(nextTierWords);
      nextTierWords.clear();
    }
    return 0;
  }

  private Set<String> changeOneLetterOptions(String word, Set<String> wordDict) {
    Set<String> result = new HashSet<String>();
    for (int i = 0; i < word.length(); i++) {
      char[] wordChars = word.toCharArray();
      for (Character c : alphabet) {
        wordChars[i] = c;
        String newWord = new String(wordChars);
        if (wordDict.contains(newWord) && (!visited.contains(newWord))) {
          result.add(newWord);
        }
      }
    }
    return result;
  }
}
