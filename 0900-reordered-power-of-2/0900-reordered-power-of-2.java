class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);

        for (int i = 0; i < 31; i++) { // 2^0 to 2^30 are < 10^9
            int powerOfTwo = 1 << i;
            if (target.equals(sortDigits(powerOfTwo))) {
                return true;
            }
        }

        return false;
    }

    private String sortDigits(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}