package base.bean.copy;

/**
 * @author : linghan.ma
 * @Package base.bean.copy
 * @Description:
 * @date Date : 2019年11月12日 2:33 PM
 **/
import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

public class BeanCopierUtil {

    final static private Map<String, BeanCopier> BEAN_COPIERS = new HashMap();

    public static BeanCopier copy(Class<?> srcClazz, Class<?> destClazz) {
        String key = genKey(srcClazz, destClazz);

        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcClazz, destClazz, false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }

        return copier;
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }
}
