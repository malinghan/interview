package ipconvert;

/**
 * @author : linghan.ma
 * @Package ipconvert
 * @Description:
 *
 * https://blog.csdn.net/dadiyang/article/details/88096136
 * 思路就是将 ip 的每一段数字转为 8 位二进制数，并将它们放在结果的适当位置上
 *
 * 注意:
 *    这里不需要手动的将10进制转为2进制，计算机在进行位运算时，会将输入自动转为二进制，进而进行位运算，之后再转为10进制显示
 * @date Date : 2020年12月12日 12:35 PM
 **/
public class IpUtil {
    
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("8") << 8);
        System.out.println(IpUtil.ip2Int("192.168.1.3"));
    }
    
    public static int ip2Int(String ipString) {
        // 取 ip 的各段
        String[] ipSlices = ipString.split("\\.");
        for (final String ipSlice : ipSlices) {
            System.out.println(ipSlice);
        }
        int rs = 0;
        for (int i = 0; i < ipSlices.length; i++) {
            // 将 ip 的每一段解析为 int，并根据位置左移 8 位
            int intSlice = Integer.parseInt(ipSlices[i]) << 8 * (ipSlices.length -1 - i);
            // 或运算
            rs = rs | intSlice;
        }
        return rs;
    }
    
    /**
     * 将 int 转换为 ip 字符串
     *
     * @param ipInt 用 int 表示的 ip 值
     * @return ip字符串，如 127.0.0.1
     */
    public static String int2Ip(int ipInt) {
        String[] ipString = new String[4];
        for (int i = 0; i < 4; i++) {
            // 每 8 位为一段，这里取当前要处理的最高位的位置
            int pos = i * 8;
            // 取当前处理的 ip 段的值
            int and = ipInt & (255 << pos);
            // 将当前 ip 段转换为 0 ~ 255 的数字，注意这里必须使用无符号右移
            ipString[i] = String.valueOf(and >>> pos);
        }
        return String.join(".", ipString);
    }
    
    /**
     * 将int数字转换成ipv4地址
     *
     */
    public static String integer2Ip(int ip) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        boolean needPoint = false; // 是否需要加入'.'
        for (int i = 0; i < 4; i++) {
            if (needPoint) {
                sb.append('.');
            }
            needPoint = true;
            int offset = 8 * (3 - i);
            num = (ip >> offset) & 0xff;
            sb.append(num);
        }
        return sb.toString();
    }
}
