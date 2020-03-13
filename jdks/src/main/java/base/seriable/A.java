package base.seriable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author : linghan.ma
 * @Package base.seriable
 * @Description:
 * @date Date : 2019年09月16日 6:10 PM
 **/
public class A implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return Objects.equals(getName(), a.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
