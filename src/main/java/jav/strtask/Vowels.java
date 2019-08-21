package jav.strtask;

import java.util.*;
import java.util.function.Function;

public class Vowels {

    public Vowels() {
    }

    // return vowels chars

    Function<String, Integer> getCount = new Function<String, Integer>() {

        // vowel collection
        private Set<Character> engSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

        @Override
        public Integer apply(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                count += engSet.contains(s.charAt(i)) ? 1 : 0;

            return count;
        }
    };

    Comparator<String> comparator = (s1, s2) -> Integer.compare(getCount.apply(s1), getCount.apply(s2));

    List<String> stringList = Arrays.asList("adfrstydj", "nmvjikfiifjsg", "mnxbvt", "fsrdwcxz", "yuehbcc");

    // Upper vowels ; comparator.reversed()
    //Collections.sort(stringList, comparator);
    public void printSortVowels(){
        Collections.sort(stringList, comparator);
        System.out.println("Sort by vowels > "+ stringList);
    }
}
