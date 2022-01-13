//Ethan Smith
// CS3000 Advanced Algorithms
// Chapter 15 programming
// 3/10/21

//	Apalindromeis a nonempty string over some alphabet that reads the same for-ward and backward.  
//	Examples of palindromes are all strings of length1,civic,racecar,and aibohphobia(fear of palindromes).
//	Give an efficient algorithm to find the longest palindrome that is a subsequenceof a given input string. 
//	For example, given the input character, your algorithm should return carac. What is the running time of your algorithm?
public class Pali {

    public static String longestPalSubstr(String str) {
        
    	int n = str.length();
        boolean subpals[][] = new boolean[n][n]; // saves if a subset is a palindrome or not
        int max = 1;// gotta be more than 1 because all 1 char strings are palindromes
        for (int i = 0; i < n; ++i) {
            subpals[i][i] = true;
        }
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                subpals[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (subpals[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    subpals[i][j] = true;
                    if (k > max) {
                        start = i;
                        max = k;
                    }
                }
            }
        }
        String ans = str.substring(start,start + max);
        return ans;
    }
 
    public static void main(String[] args) {
 
        String str = "spell caracter please :)";
        System.out.println(longestPalSubstr(str));
        str = "I like racecars!";
        System.out.println(longestPalSubstr(str));
        str = "no";
        System.out.println(longestPalSubstr(str));		
    }
}
