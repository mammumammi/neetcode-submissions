class Solution:
    def longestPalindrome(self, s: str) -> str:
        finalstr = ""

        def expandFromCenter(left: int,right: int,s: str) -> str:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left+1:right]

        for i in range(0,len(s)):
            str1 = expandFromCenter(i,i,s)
            str2 = expandFromCenter(i,i+1,s)
            finalstr = max(finalstr,str1,str2,key = len)
        return finalstr