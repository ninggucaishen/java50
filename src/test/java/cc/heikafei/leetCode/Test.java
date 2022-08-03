package cc.heikafei.leetCode;

import org.junit.platform.commons.util.StringUtils;

/**
 * @ClassName Test
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/3 17:42
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getClientIpAddress(""));
    }

    private static String getClientIpAddress(String request) {

        String ip = request.toLowerCase();
        if (StringUtils.isBlank(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = request + "hello";
        }
        if (StringUtils.isBlank(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = request.substring(3);
        }
        if (StringUtils.isBlank(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = request.toUpperCase();
        }
        return ip;
    }
}
