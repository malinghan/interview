package bean;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : linghan.ma
 * @Package bean
 * @Description:
 * @date Date : 2020年01月19日 10:49 AM
 **/
public class StringTest {

    @Test
    public void test() {
        final String regex = "(?<!\\<u\\>)(\\{#.+?\\})";
        final String string = "<p style=\"text-align: center; \"><font size=\"6\">离职证明</font></p><p><br></p><p>&nbsp; &nbsp; &nbsp; &nbsp;<font size=\"5\">员工<u>{#姓名}</u>，身份证号（<u>{#身份证号}</u>），于{#入职日期}至{#离职时间}在我公司担任<u>{#岗位}</u>一职。因{#离职原因}原因于{#离职时间}正式离职。</font></p><p>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size=\"5\">已办理完离职及交接手续，双方已解除劳动关系，不存在劳动争议，特此证明！</font></p><p><font size=\"5\"><br></font></p><p><font size=\"5\"><br></font></p><p style=\"text-align: right;\"><font size=\"5\">（盖章）&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</font><span style=\"font-size: x-large;\">&nbsp; &nbsp;</span></p><p style=\"text-align: right;\"><font size=\"5\">签字：&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</font></p><p style=\"text-align: right; \"><font size=\"5\">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</font></p><p><br></p>";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        System.out.println(string.replaceAll(regex,"<u>$1</u>"));
    }
}
