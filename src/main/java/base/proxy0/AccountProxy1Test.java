package base.proxy0;

/**
 * @author : linghan.ma
 * @Package base.proxy0
 * @Description: http://ifeve.com/cglib-desc/
 * @date Date : 2019年09月25日 5:47 PM
 **/
public class AccountProxy1Test {
    public static  void main(String[] args){
        Account account = (Account) new AccountCglibProxyFactory().getInstance(new AccountImpl());
        account.updateAccount();

        Person person = (Person) new AccountCglibProxyFactory().getInstance(new Person());

        System.out.println(person);

        person.show();
    }
}
