package idworker;

/**
 * @author : linghan.ma
 * @Package com.github.tokenclient
 * @Description:
 * @date Date : 2020年12月09日 12:49 AM
 **/
public class IdWorkerTest {
    
    
    public static void main(String[] args) {
        while(true){
            System.out.println(IdWorkerUtils.getInstance().createUUID());
        }
    }
}
