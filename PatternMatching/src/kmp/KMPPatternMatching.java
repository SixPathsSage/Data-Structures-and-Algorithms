package kmp;

/*
* Time Complexity: O(m+n)
* Space Complexity: O(n)
* Where m is length of the text and n is the length of the pattern
* */
public class KMPPatternMatching {
    public boolean patternMatch(String text, String pattern) {
        return indexOf(text, pattern) > -1;
    }

    public int indexOf(String text, String pattern) {
        if(pattern.length() > text.length()) {
            return -1;
        }
        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int[] prefix = createPrefixArray(patternArray);
        int i = 0;
        int j = 0;

        while(i < prefix.length && j < textArray.length) {
            if(patternArray[i] == textArray[j]) {
                i ++;
                j ++;
            }
            else if(i > 0) {
                i = prefix[i-1];
            }
            else {
                j ++;
            }
        }
        return i == patternArray.length ? j-i : -1;
    }

    private int[] createPrefixArray(char[] patternArray) {
        int[] prefix = new int[patternArray.length];

        int i = 0;
        int j = 1;

        while(j < patternArray.length) {
            if(patternArray[i] == patternArray[j]) {
                prefix[j] = i + 1;
                i ++;
                j ++;
            }
            else if(i > 0){
                i = prefix[i-1];
            }
            else {
                j ++;
            }
        }
        return prefix;
    }
}
