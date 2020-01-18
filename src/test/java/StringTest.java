import org.junit.Test;
import org.mockito.internal.util.StringUtil;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : linghan.ma
 * @Package PACKAGE_NAME
 * @Description:
 * @date Date : 2020年01月17日 8:19 PM
 **/
public class StringTest {

    @Test
    public void stringTest(){
       String content ="<p style=\"text-align: center; \"><font size=\"6\">薪酬证明</font></p><p><br></p><p>&nbsp; &nbsp; &nbsp; <font size=\"5\">兹证明<u>{#姓名}</u>（先生/女士）身份证号（{#身份证号}），目前为我公司（全职/兼职）员工。于{#入职日期}入职。现在{#部门}部门担任{#岗位}职务。固定月工资人民币{#最新基本工资基数}元，特此证明。</font></p><p><font size=\"5\"><br></font></p><p><font size=\"5\"><br></font></p><p style=\"text-align: right; \"><font size=\"5\">（盖章）&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</font><span style=\"font-size: x-large;\">&nbsp; &nbsp;</span></p><p style=\"text-align: right;\"><font size=\"5\">签字：&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</font></p><p style=\"text-align: right; \"><font size=\"5\">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 日</font></p><p><br></p>";
//       String content = "{#姓名}";
        String regex = "(?<!\\<u\\>)(\\{#.+?\\})";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(content);
        System.out.println(matcher.replaceAll("\\<u\\>$1\\<\\/u\\>"));
    }
}
