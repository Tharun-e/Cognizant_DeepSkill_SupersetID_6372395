package AAAPattern;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
public class bankaccounttest {
    private bankaccount userAccount;
    @Before
    public void initialize() {
        userAccount = new bankaccount(100);
        System.out.println("Account initialized with ₹100");
    }
    @After
    public void cleanup() {
        userAccount = null;
        System.out.println("Account closed");
    }
    @Test
    public void shouldAddFundsToAccount() {
        int fundsToAdd = 50;
        userAccount.addFunds(fundsToAdd);
        assertEquals(150, userAccount.checkBalance());
    }
    @Test
    public void shouldWithdrawFundsFromAccount() {
        int withdrawal = 30;
        userAccount.withdrawFunds(withdrawal);
        assertEquals(70, userAccount.checkBalance());
    }
    @Test
    public void shouldPreventOverdraft() {
        int overdraftAttempt = 200;
        userAccount.withdrawFunds(overdraftAttempt);
        assertEquals(100, userAccount.checkBalance());
    }

    @Test
    public void shouldAllowFullBalanceWithdrawal() {
        int fullWithdrawal = 100;
        userAccount.withdrawFunds(fullWithdrawal);
        assertEquals(0, userAccount.checkBalance());
    }
}
