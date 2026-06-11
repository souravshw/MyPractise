package io.practise.accolite;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: I am a developer
 * <p>
 * Output: r ep o levedamaI
 */
public class ReversingWordBX {
    public static void main(String[] args) {
        String input = "I am a developer";

        List<String> letters = new ArrayList<>();

        List<Integer> spaces = new ArrayList<>();

        String[] split = input.split("");

        //Arrays.stream(split).forEach(System.out::print);

        for (int index = 0; index < split.length; ++index) {
            if (!split[index].equals(" ")) {
                letters.add(split[index]);
            } else {
                spaces.add(index);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        letters.forEach(eachLetter -> stringBuilder.append(eachLetter));

        stringBuilder.reverse();

        spaces.forEach(eachSpace -> stringBuilder.insert(eachSpace," "));

        System.out.println(stringBuilder);



    }
}
