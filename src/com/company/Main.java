package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Main {

    public static void main(String[] args) {

        File f = new File("D:\\Java\\JavaHomework_2\\python.html");

        try (
                FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr)
        ) {

            String htmlPage = null;
            StringBuilder sb = new StringBuilder();

            while ((htmlPage = bfr.readLine()) != null) {
                sb.append(htmlPage);
            }

            htmlPage = sb.toString().replaceAll("<[^>]*>", " ");
            String htmlWords[] = htmlPage.split(" ");

            Map<String, Integer> occurrences = new HashMap<>();

            for (String word : htmlWords) {
                if (word.length() > 3) {
                    Integer oldCount = occurrences.get(word);
                    if (oldCount == null) {
                        oldCount = 0;
                    }
                    occurrences.put(word, oldCount + 1);
                }
            }
            /*
            for (String word : occurrences.keySet()) {
                System.out.println(word + " " + occurrences.get(word));
            }
            */

            System.out.println(Collections.max(occurrences.keySet()) + " " +Collections.max(occurrences.values()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
