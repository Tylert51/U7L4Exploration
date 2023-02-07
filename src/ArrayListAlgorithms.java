import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListAlgorithms
{
    /** Returns true if any of the elements in stringList contain
     *  target as a substring; false otherwise.
     *
     *  Does NOT mutate (modify) elements of stringList.
     *  PRECONDITION: stringList.size() > 0
     *
     *  @param stringList  original arraylist of Strings
     *  @return  true if target is found in any of the strings, false otherwise
     */
    public static boolean containsTarget(ArrayList<String> stringList, String target) {
        for (String word : stringList) {
            if (word.contains(target)) {
                return true;
            }
        }
        return false;
    }

    /** Returns number of elements in intList that are less than the
     *  average of all elements.
     *
     *  Does NOT mutate (modify) elements of intList.
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  original arraylist of Integers
     *  @return  the number of ints in intList that are less than the average
     */
    public static int belowAverage(ArrayList<Integer> intList) {
        int count = 0;
        double sum = 0;

        for (Integer num : intList) {
            sum += num;
        }
        double average = sum / intList.size();

        for (Integer num : intList) {
            if (num < average) {
                count++;
            }
        }

        return count;
    }

    /** Replaces all words in wordList that end in "s" with the all-uppercase
     *  version of the word.  For example, "apples" should be replaced with "APPLES".
     *  Assume all letters of all words in wordList are lowercase initially (no need
     *  to worry about checking for case or converting first to lowercase)
     *
     *  DOES mutate (modify) elements of wordList.
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  original arraylist of words
     */
    public static void replaceWithCaps(ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String origWord = wordList.get(i);
            int lastLetterLen = origWord.length();
            String lastLetter = origWord.substring(lastLetterLen - 1);

            if (lastLetter.equals("s")) {
                wordList.set(i, origWord.toUpperCase());
            }
        }
    }

    /** Returns the index at which the minimum value of all integers in
     *  intList appears; if the minimum value appears more than once in
     *  the arraylist, return the index of the first occurrence
     *
     *  Does NOT mutate (modify) elements in intList.
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  original arraylist of Integers
     *  @return  the index at which the minimum value occurs
     */
    public static int indexOfMinimum(ArrayList<Integer> intList) {
        int min = intList.get(0);

        for (Integer num : intList) {
            if (num < min) {
                min = num;
            }
        }

        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) == min ) {
                return i;
            }
        }

        return -1;
    }

    /** Returns true if two array lists of the same length contain the exact
     *  same elements in the same order (i.e. the two arraylists are identical).
     *  Returns false otherwise.
     *
     *  Does NOT mutate (modify) elements in either arraylist
     *  PRECONDITION: numList1.size() == numList2.size()
     *
     *  @param numList1  first arraylist of Integers
     *  @param numList2  second arraylist of Integers, has the same size a first
     *  @return  true if both arraylists are identical, element for element
     */
    public static boolean areIdentical(ArrayList<Integer> numList1, ArrayList<Integer> numList2) {
        for (int i = 0; i < numList1.size(); i++) {
            if (numList1.get(i) != numList2.get(i)) {
                return false;
            }
        }
        return true;
    }

    /** Removes all elements from numList that are ODD Integers.
     *
     *  DOES mutate (modify) elements in numList
     *  PRECONDITION: numList1.size() > 0
     *
     *  @param numList arraylist of Integers
     */
    public static void removeOdds(ArrayList<Integer> numList) {
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);

            if (num % 2 == 1) {
                numList.remove(i);
                i--;
            }
        }
    }

    /** Removes all elements from wordList that contain an a, e, i , and/or o.
     *  All other words (i.e. those that have u and/or y as the vowel
     *  such as "ugh" or "sly", or no vowels, like "psh"), add a duplicate of
     *  that element to wordList at an adjacent index.
     *
     *  Assume all words have lowercase letters (i.e. no need to check for case)
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void wackyVowels(ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);

            if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o")) {
                wordList.remove(i);
                i--;
            } else {
                wordList.add(i, word);
                i++;
            }
        }
    }

    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static void removeDuplicates(ArrayList<Integer> intList) {
        String duplicateNums = "";

        for (int i = 0; i < intList.size(); i++) {
            String num = intList.get(i) + "";

            if (duplicateNums.contains(num)) {
                intList.remove(i);
                i--;
            } else {
                duplicateNums += num;
            }
        }
    }

    /** Adds an uppercase version of each string directly AFTER the string
     *  in wordList; for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "HELLO", "my", "MY", "best", "BEST", "friend", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperAfter(ArrayList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String wordU = wordList.get(i).toUpperCase();
            wordList.add(i + 1, wordU);
            i++;
        }
    }

    /** Appends an uppercase version of each string to the END of of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperEnd(ArrayList<String> wordList) {
        int size = wordList.size();

        for (int i = 0; i < size; i++) {
            String wordU = wordList.get(i).toUpperCase();
            wordList.add(i + size, wordU);
        }
    }

    /** Returns an arraylist of Strings that represents the input sentence parsed
     *  into separate words (using a space: " " as the delimiter) and REVERSED
     *  For example, if sentence = "This is my sentence!"
     *  this method return [sentence!, my, is, This]
     *
     *  PRECONDITION: sentence does not end with a space
     *
     *  @param sentence  the input String that represents one or more words
    separated by spaces
     *  @return  new arraylist of Strings containing the words of sentence reversed
     */
    public static ArrayList<String> parseWordsAndReverse(String sentence) {
        ArrayList<String> orig = new ArrayList<String>();
        ArrayList<String> reverse = new ArrayList<String>();
        sentence += " ";
        String word = "";

        for (int i = 0; i < sentence.length(); i++) {
            String letter = sentence.charAt(i) + "";

            if (!letter.equals(" ")) {
                word += letter;
            } else {
                orig.add(word);
                word = "";
            }
        }

        for (int i = orig.size() - 1; i >= 0; i--) {
            reverse.add(orig.get(i));
        }

        return reverse;
    }

    /** Removes all words from wordList that begin with "b" and inserts them at the
     *  front of wordList; all "b" words that are moved should appear in the same order
     *  in the modified arrayList as they did before being moved
     *
     *  For example, this method will take a wordList:
     *  ["apple", "banana", "cherry", "donut", "bagel", "danish", "berry", "baguette", "soda"]
     *  and modify it to
     *  ["banana", "bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0, all strings in wordList have at least one character
     *
     *  @param wordList  arraylist of words
     */
    public static void moveBWords(ArrayList<String> wordList) {
        int nextI = 0;
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);

            if((word.charAt(0) + "").equals("b")) {
                wordList.remove(i);
                wordList.add(nextI, word);
                nextI++;
            }
        }
    }

    /** Returns Arraylist of Integers that contain all mode(s) of the int array numList.
     *  If elements in numList all appear exactly once, there is no mode, and this method
     *  should return an empty list
     *
     *  For example, if numList is: [1, 2, 3, 2, 4, 5, 5, 6],
     *  then numList contains two modes: 2, 5
     *  and this method returns an arraylist containing 2 and 5 (in any order)
     *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6, 6, 7, 6],
     *  then numList contains one mode: 6
     *  and this method returns an arrayList containing 6
     *  If numList is: [1, 2, 3, 4, 5, 6], then numList contains no mode
     *  and this method returns an empty arrayList: []
     *  If numList is: [2, 2, 2, 3, 3, 3, 4, 4, 4],
     *  then numList contains three modes: 2, 3, 4
     *  and this method returns an arrayList containing 2, 3, and 4 (in any order)
     *
     *  Does NOT mutate (modify) elements in numList
     *  PRECONDITIONS: numList.length > 0
     *
     *  @param numList  numList of ints
     */
    public static ArrayList<Integer> modes(int[] numList) {
        ArrayList<Integer> modes = new ArrayList<Integer>();
        int[] copy = Arrays.copyOf(numList, numList.length);
        Arrays.sort(copy);

        ArrayList[] splitNum = new ArrayList[numDiff(copy)];
        for (int i = 0; i < splitNum.length; i++) {
            splitNum[i] = new ArrayList<Integer>();
        }

        int nInd = 0;
        for (int i = 0; i < copy.length; i++) {
            if (i == 0) {
                splitNum[nInd].add(copy[i]);
            } else if (copy[i] != copy[i-1]){
                nInd++;
                splitNum[nInd].add(copy[i]);
            } else {
                splitNum[nInd].add(copy[i]);
            }
        }

        int[] freq = new int[splitNum.length];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = splitNum[i].size();
        }

        int max = 0;

        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < freq.length; i++) {
                if (x == 0) {
                    if (freq[i] > max) {
                        max = freq[i];
                    }
                } else {
                    if(freq[i] == max && max != 1) {
                        modes.add((int) splitNum[i].get(0));
                    }
                }
            }
        }
        return modes;
    }


    private static int numDiff(int[] nums) {
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                count++;
            }
        }

        return count;
    }


}