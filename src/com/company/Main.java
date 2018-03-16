package com.company;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        File f = new File("D:\\data1.txt");

        try (
                FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr)
        ) {

            String txt = null;
            StringBuilder sb = new StringBuilder();

            while ((txt = bfr.readLine()) != null) {
                sb.append(txt);
            }

            String words[] = sb.toString().split(" ");

            Map<String, Integer> occurrences = new HashMap<>();

            for (String word : words) {
                if (word.length() > 1) {
                    Integer oldCount = occurrences.get(word);
                    if (oldCount == null) {
                        oldCount = 0;
                    }
                    occurrences.put(word, oldCount + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());

            }

            int maxVal = Collections.max(occurrences.values());

            for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
                if (entry.getValue() == maxVal) {
                    System.out.println("\nA najczestsze slowo to: ");
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
