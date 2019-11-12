package bean;

import base.JsonUtil;
import base.bean.copy.BeanCopierUtil;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package bean
 * @Description:
 * 结论: 在新旧bean的属性名和属性类型相同的情况下
 *  1. cglib的bean copy 之后，基本属性不会随旧的值改变而改变
 *  2. 引用的属性会随着引用的对象的值改变而改变
 * @date Date : 2019年11月12日 2:36 PM
 **/
public class BeanTest {

    @Test
    public void beanCopyTest(){
        User old = new User();
        old.setId("1");
        old.setName("aaa");
        old.setSex("22");
        final Watch watch  = new Watch();
        watch.setName("watch1");
        old.setWatch(watch);
        List<Pen> pens =  new ArrayList<Pen>();
        old.setPens(pens);
        UserDO newUser = new UserDO();
        BeanCopier beanCopier = BeanCopierUtil.copy(old.getClass(),newUser.getClass());
        beanCopier.copy(old,newUser,null);
        System.out.println(JsonUtil.toJson(newUser));
        watch.setName("watch2");
        old.setName("bbb");
        System.out.println(JsonUtil.toJson(newUser));
        System.out.println(JsonUtil.toJson(old));
    }

    @Test
    public void ListBeanCopyTest(){
        User old = new User();
        old.setId("1");
        old.setName("aaa");
        old.setSex("22");
        UserDO newUser = new UserDO();
        BeanCopier beanCopier = BeanCopierUtil.copy(old.getClass(),newUser.getClass());
        beanCopier.copy(old,newUser,null);
        System.out.println(JsonUtil.toJson(newUser));
    }
}
