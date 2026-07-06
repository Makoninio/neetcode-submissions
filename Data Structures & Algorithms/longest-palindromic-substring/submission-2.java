class Solution {
    //Two pointer
    public String longestPalindrome(String s) {
        int resIndex = 0, len = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd
            int l=i, r=i;
            while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) { 
                    resIndex = l;
                    len= r - l + 1;
                }
                l--;
                r++;
            }

            //even
            l=i;
            r=i+1;
            while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {                   
                    resIndex = l;
                    len= r - l + 1;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIndex, resIndex + len);
    }

}
