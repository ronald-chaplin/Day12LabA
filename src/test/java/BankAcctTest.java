import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankAcctTest {
    BankAcct a;

    @BeforeEach
    void init(){
        a = new BankAcct();
    }

    @Test
    void getAcctNumberTest(){
        a = new BankAcct(123456789);
        int expected = 123456789;
        int actual = a.getAcctNumber();
        assertEquals(expected, actual);
    }

    @Test
    void setAcctNumberTest(){
        int expected = 987654321;
        a.setAcctNumber(expected);
        int actual = a.getAcctNumber();
        assertEquals(expected, actual);
    }

    @Test
    void getAcctBalanceTest(){
        float expected = 1500f;
        a = new BankAcct(1, expected);
        float actual = a.getAcctBalance();
        assertEquals(expected, actual);
    }

    @Test
    void setAcctBalanceTest(){
        float expected = 100f;
        a.setAcctBalance(expected);
        float actual = a.getAcctBalance();
        assertEquals(expected, actual);
    }

    @Test
    void getTransactionTest(){
        a = new BankAcct(12345, 10000f);
        a.transaction(54321, 12345, 1400.50f);
        ArrayList<Object> expected = new ArrayList<Object>();
        expected.add(54321);
        expected.add(12345);
        expected.add(1400.50f);
        ArrayList<Object> actual = a.getTransaction(0);
        assertEquals(expected, actual);
    }

    @Test
    void transactionTest(){
        a = new BankAcct(1,100f);
        a.transaction(2, 1, 15f);
        float expected = 115f;
        float actual = a.getAcctBalance();
        assertEquals(expected, actual);
    }

    @Test
    void transactionSearchTest(){
        a = new BankAcct(1);
        a.transaction(2 , 1, 450f);
        a.transaction(1, 3, 13f);
        a.transaction(2 , 1, 310f);
        //List<BankAcct.Transaction> expected = new ArrayList<BankAcct.Transaction>();
        //expected.add(new BankAcct.Transaction(2 , 1, 450f));
        //expected.add(new BankAcct.Transaction(2 , 1, 310f));
        String expected = "[Sending Acct: 2 Receiving Acct: 1 Amount: 450.0, Sending Acct: 2 Receiving Acct: 1 Amount: 310.0]";
        List<BankAcct.Transaction> actual = a.transactionSearch(2);
        assertEquals(expected, actual.toString());
    }
}
