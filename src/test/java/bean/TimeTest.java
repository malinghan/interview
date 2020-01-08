package bean;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author : linghan.ma
 * @Package bean
 * @Description:
 * @date Date : 2020年01月08日 10:06 AM
 **/
public class TimeTest {

    @Test
    public void timeTest(){
        System.out.println(DateTime.now().plusDays(10).toString("HH:mm (d号)"));
    }
}
