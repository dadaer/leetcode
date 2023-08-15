package string.medium;

/**
 * @source: leetcode468
 * @difficulty: medium
 * @topic: 验证IP地址
 * @link: https://leetcode.cn/problems/validate-ip-address/
 * @description:
 * @input: queryIP = "172.16.254.1"
 * @output: "IPv4"
 * @requirements:
 */
public class ValidIPAddress {
    public static void main(String[] args) {
        System.out.println(validIPAddress("192.168@1.1"));
    }

    public static String validIPAddress(String queryIP) {
        String[] strings = queryIP.split("\\.");
        int ipv4Length = strings.length;
        if (ipv4Length == 4) {  // IPv4
            if (queryIP.lastIndexOf(".") == queryIP.length() - 1) {
                return "Neither";
            }
            for (String str : strings) {
                if (str.length() < 1 || str.length() > 3) {
                    return "Neither";
                }
                if (str.length() > 1 && str.charAt(0) == '0') {
                    return "Neither";
                }
                for (char ch : str.toCharArray()) {
                    if (ch < '0' || ch > '9') {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else { // IPv6
            String[] strings1 = queryIP.split(":");
            int ipv6Length = strings1.length;
            if (queryIP.lastIndexOf(":") == queryIP.length() - 1) {
                return "Neither";
            }
            if (ipv6Length == 8) {
                for (String str : strings1) {
                    if (str.length() > 4 || str.length() < 1) {
                        return "Neither";
                    }
                    for (char ch : str.toCharArray()) {
                        if ((ch <= '9' && ch >= '0') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {

                        } else {
                            return "Neither";
                        }
                    }
                }
                return "IPv6";
            }
        }
        return "Neither";
    }

    public static String validIPAddress1(String queryIP) {
        String[] strings = queryIP.split("\\.");
        int length = strings.length;
        if (length == 4) {
            if (queryIP.lastIndexOf(".") == queryIP.length() - 1) {
                return "Neither";
            }
            for (String str : strings) {
                // 排除含有前导 0 的情况
                if (str.length() > 1 && str.charAt(0) == '0') {
                    return "Neither";
                }
                // 判断数值是否合法
                if (str.length() < 1 || str.length() > 3) {
                    return "Neither";
                } else {
                    for (char ch : str.toCharArray()) {
                        if (ch < '0' || ch > '9') {
                            return "Neither";
                        }
                    }
                    int value = Integer.parseInt(str);
                    if (value < 0 || value > 255) {
                        return "Neither";
                    }
                }
            }
            return "IPv4";
        } else {
            if (length == 1) {
                String[] strings1 = queryIP.split(":");
                if (queryIP.lastIndexOf(":") == queryIP.length() - 1) {
                    return "Neither";
                }
                if (strings1.length == 8) {
                    for (String str : strings1) {
                        int length1 = str.length();
                        if (length1 == 0 || length1 > 4) {
                            return "Neither";
                        }
                        for (int i = 0; i < length1; i++) {
                            char c = str.charAt(i);
                            if (!(Character.isDigit(c) || (c >= 'a' && c <= 'f') || c >= 'A' && c <= 'F')) {
                                return "Neither";
                            }
                        }
                    }
                    return "IPv6";
                }
            }
        }
        return "Neither";
    }
}
