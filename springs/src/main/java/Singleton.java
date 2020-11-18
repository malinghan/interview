/**
 * @author : linghan.ma
 * @Package PACKAGE_NAME
 * @Description:
 * @date Date : 2020年11月18日 3:29 PM
 **/
public class Singleton{
    private Singleton(){

    }

    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private static final  Singleton sInstance = new Singleton();
    }
}