class Solution {
    public String validIPAddress(String IP) {

        if (IP == null || IP.isEmpty()) {
            return "Neither";
        }

        return isValidV6(IP) ? "IPv6" : (isValidV4(IP) ? "IPv4" : "Neither");
    }

    private boolean isValidV4(String ip) {

        int length = ip.length();
        if (length >= 7 && length < 16) {

            int value = 0;
            boolean leadingZero = false;
            int octetCount = 1;
            boolean leadingDot = false;
            for (int idx = 0; idx < length; idx++) {

                char ch = ip.charAt(idx);
                if (ch == '.') {
                    octetCount++;
                    if (idx == 0 || idx == length - 1 || leadingDot || octetCount > 4) {
                        return false;
                    }
                    value = 0;
                    leadingZero = false;
                    leadingDot = true;
                    continue;
                }

                if (leadingZero) {
                    return false;
                }

                int digit = Character.digit(ch, 10);
                if (digit < 0) {
                    return false;
                }

                leadingZero = digit == 0;
                leadingDot = false;

                value = (value * 10) + digit;
                if (value >= 256) {
                    return false;
                }
            }

            return octetCount == 4;
        }

        return false;
    }

    private boolean isValidV6(String ip) {

        int length = ip.length();
        if (length >= 15 && length < 40) {

            long value = 0;
            boolean leadingColon = false;
            int hexCount = 1;
            int digitCount = 0;
            for (int idx = 0; idx < length; idx++) {

                char ch = ip.charAt(idx);
                if (ch == ':') {
                    hexCount++;
                    if (idx == 0 || idx == length - 1 || leadingColon || hexCount > 8 || digitCount > 4) {
                        return false;
                    }
                    value = 0;
                    leadingColon = true;
                    digitCount = 0;
                    continue;
                }

                int digit = Character.digit(ch, 16);
                if (digit < 0) {
                    return false;
                }

                digitCount++;
                leadingColon = false;

                value = (value * 10) + digit;
                if (value >= (1L << 16)) {
                    return false;
                }
            }

            return hexCount == 8;
        }

        return false;
    }
}