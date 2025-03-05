package io.practise;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Given two strings return true, if the two strings are anagrams and false if not
 * <p>
 * s1 = “William Shakespeare”
 * s2 = “I am a weakish speller”
 *  false
 * <p>
 * s1 = “A decimal point”
 * s2 = “I'm a dot in place”
 * false
 * <p>
 * s1 = adb
 * s2 = cdb
 * true
 */
public class TestAnagram {

  public static void main(String[] args) {
    String str1 = "A decimal pointt";
    String str2 = "I'm a dot in placee";

    String s1= "sanjay";

    String s2= "jain";



    String s3= "sanjayjain";

    s1 = s1.concat(s2);


    System.out.println(s1.equals(s3));

    String allowedCharacters = "qwertyuioplkjhgfdsazxccvbnm";

    List<String> list = new ArrayList<>();

    for(char ch: allowedCharacters.toCharArray()) {
      list.add(String.valueOf(ch));
    }
    //(O(n)) : 26


    Map<String, Integer> firstStringMap = new HashMap<>();
    Map<String, Integer> secondStringMap = new HashMap<>();


    for (char ch : str1.toCharArray()) {
      //System.out.println("String.valueOf(ch).toLowerCase() "+String.valueOf(ch).toLowerCase() + " "+list.contains(String.valueOf(ch).toLowerCase()));
      if (list.contains(String.valueOf(ch).toLowerCase())) {
        String tempString = String.valueOf(ch).toLowerCase();

       // System.out.println("tempString "+ tempString);
        if (firstStringMap.containsKey(tempString)) {
         // System.out.println("allowed tempString "+ tempString+"\n");
          int count = firstStringMap.get(tempString);
          firstStringMap.put(tempString, ++count);
        } else {
          firstStringMap.put(tempString, 1);
        }
      } else {
        System.out.print(ch);
      }

      // o(n)

    }

    for (char ch : str2.toCharArray()) {
      if (list.contains(String.valueOf(ch).toLowerCase())) {
        String tempString = String.valueOf(ch).toLowerCase();

        if (secondStringMap.containsKey(tempString)) {
          int count = secondStringMap.get(tempString);
          secondStringMap.put(tempString, ++count);
        } else {
          secondStringMap.put(tempString, 1);
        }
      }else {
        System.out.print(ch);
      }
    }



    AtomicBoolean isAnagram = new AtomicBoolean(true);

    firstStringMap.keySet().forEach(eachKey -> {
      if(secondStringMap.containsKey(eachKey)) {
        if(!secondStringMap.get(eachKey).equals(firstStringMap.get(eachKey))) {
          isAnagram.set(false);
        }
      } else {
        isAnagram.set(false);
      }
    });
    System.out.println(isAnagram.get());
  }
}
