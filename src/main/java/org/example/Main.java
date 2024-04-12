package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;

class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        String originalString = "Dong-ding-dong";
        String comparisonString = "Goh-bon-HON";
        try {

            int letterCount = originalString.length();
            logger.info("Number of letters in the string: " + letterCount);

            boolean isEqualIgnoreCase = originalString.equalsIgnoreCase(comparisonString);
            logger.info("Strings are equal (ignoring case): " + isEqualIgnoreCase);

            String uppercaseString = originalString.toUpperCase();
            String lowercaseString = originalString.toLowerCase();
            logger.info("Uppercase: " + uppercaseString);
            logger.info("Lowercase: " + lowercaseString);

            String searchWord = "dong";
            int index = originalString.indexOf(searchWord);
            while (index != -1) {
                System.out.println("Index of \"" + searchWord + "\": " + index);
                index = originalString.indexOf(searchWord, index + 1);
            }

            String replacedString = originalString.replace("dong", "bong");
            logger.info("Replaced string: " + replacedString);
            FileWriter writer = new FileWriter("output.txt");
            writer.write(originalString);
            writer.close();
            logger.warning("The string saved successfully");
        }catch (IOException e){
            logger.log(Level.SEVERE, e.getMessage());
            logger.severe("Error!");
            e.printStackTrace();
        }
    }
}
