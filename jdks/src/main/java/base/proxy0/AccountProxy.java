package base.proxy0;

/**
 * @author : linghan.ma
 * @Package base.proxy0
 * @Description:
 * @date Date : 2019年09月25日 5:26 PM
 **/
public class AccountProxy implements Account {

    private Account account;

    public AccountProxy(Account account){
        super();
        this.account = account;
    }

    public void queryAccount() {
        System.out.println("proxy before...");
        account.queryAccount();
        System.out.println("proxy after...");
    }

    public void updateAccount() {
        System.out.println("proxy before...");
        account.updateAccount();
        System.out.println("proxy afert...");
    }
}
