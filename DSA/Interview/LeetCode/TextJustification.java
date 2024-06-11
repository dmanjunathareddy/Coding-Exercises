package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            
            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int numberOfSpaces = maxWidth - totalChars;
            
            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(' ');
                }
                for (int i = line.length(); i < maxWidth; i++) {
                    line.append(' ');
                }
            } else {
                int spaces = numberOfSpaces / (numberOfWords - 1);
                int extraSpaces = numberOfSpaces % (numberOfWords - 1);
                
                for (int i = index; i < last - 1; i++) {
                    line.append(words[i]);
                    line.append(' ');
                    for (int j = 0; j < spaces; j++) {
                        line.append(' ');
                    }
                    if (extraSpaces > 0) {
                        line.append(' ');
                        extraSpaces--;
                    }
                }
                line.append(words[last - 1]);
            }
            
            result.add(line.toString());
            index = last;
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> justifiedText = fullJustify(words, maxWidth);

        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }
}
