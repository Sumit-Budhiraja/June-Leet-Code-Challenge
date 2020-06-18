class Solution {
    public int hIndex(int[] citations) {
    int len = citations.length;
 
    if (len == 0) {
        return 0;
    }
 
    if (len == 1) {
        if (citations[0] == 0) {
            return 0;
        } else {
            return 1;
        }
    }
 
    int i = 0;
    int j = len - 1;
    while (i < j) {
        int m = i + (j - i + 1) / 2;
        if (citations[m] > len - m) {
            j = m - 1;
        } else {
            i = m;
        }
    }
 
    if (citations[j] > len - j) {
        return len;
    }
 
    if (citations[j] == len - j) {
        return len - j;
    } else {
        return len - j - 1;
    }
}
}