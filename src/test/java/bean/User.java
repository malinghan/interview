package bean;

import java.util.List;

/**
 * @author : linghan.ma
 * @Package bean
 * @Description:
 * @date Date : 2019年11月12日 2:38 PM
 **/
public class User {
    private String id;
    private String name;
    private String sex;
    private Watch watch;
    private List<Pen> pens;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public List<Pen> getPens() {
        return pens;
    }

    public void setPens(List<Pen> pens) {
        this.pens = pens;
    }
}
