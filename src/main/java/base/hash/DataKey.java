package base.hash;

/**
 * @author : linghan.ma
 * @Package base.hash
 * @Description:
 * @date Date : 2019年09月18日 1:15 AM
 **/
public class DataKey {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // getter and setter methods
    @Override
    public String toString() {
        return "DataKey [name=" + name + ", id=" + id + "]";
    }

}
