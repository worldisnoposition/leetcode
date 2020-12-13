package com.mark.code.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullJustify {
    public static void main(String[] args) {
        FullJustify c = new FullJustify();
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};

        List<String> result = c.fullJustify(words, 16);
        System.out.println(result);
    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        char[] temp = new char[maxWidth];
        Arrays.fill(temp, ' ');
        List<String> result = new ArrayList();
        int index = 0, beforeIndex = 0, rowWordsCount = 0;
        while (index < words.length) {
            int indexCount = index - beforeIndex;
            if (indexCount + rowWordsCount + words[index].length() > maxWidth) {
                int spaceGroupCount = index - 1 - beforeIndex;
                int canUseSpace = maxWidth - rowWordsCount;
                int avgSpace = spaceGroupCount == 0 ? 0 : canUseSpace / spaceGroupCount;
                int moreSpace = spaceGroupCount == 0 ? 0 : canUseSpace % spaceGroupCount;
                int tempIndex = 0;
                while (tempIndex < temp.length && beforeIndex < index) {
                    System.arraycopy(words[beforeIndex].toCharArray(), 0, temp, tempIndex, words[beforeIndex].length());
                    tempIndex += words[beforeIndex].length() + avgSpace + (moreSpace-- > 0 ? 1 : 0);
                    beforeIndex++;
                }
                result.add(new String(temp));
                Arrays.fill(temp, ' ');
                rowWordsCount = words[index].length();
            } else {
                rowWordsCount += words[index].length();
            }
            index++;
        }
        if (beforeIndex < index) {
            int tempIndex = 0;
            while (tempIndex < temp.length && beforeIndex < index) {
                System.arraycopy(words[beforeIndex].toCharArray(), 0, temp, tempIndex, words[beforeIndex].length());
                tempIndex += words[beforeIndex].length() + 1;
                beforeIndex++;
            }
            result.add(new String(temp));
        }
        return result;
    }
}
