import java.util.ArrayList;
import java.util.List;

public class BankAcct {

    private int acctNumber;
    private float acctBalance;
    List<Transaction> transactionHistory;

    public BankAcct(){
        this.acctNumber = 0;
        this.acctBalance = 0;
        transactionHistory = new ArrayList<Transaction>();
    }

    public BankAcct(int acctNumber){
        this.acctNumber = acctNumber;
        this.acctBalance = 0;
        transactionHistory = new ArrayList<Transaction>();
    }

    public BankAcct(int acctNumber, float acctBalance){
        this.acctNumber = acctNumber;
        this.acctBalance = acctBalance;
        transactionHistory = new ArrayList<Transaction>();
    }

    public int getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(int acctNumber) {
        this.acctNumber = acctNumber;
    }

    public float getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(float acctBalance){
        this.acctBalance = acctBalance;
    }

    public void transaction(int payer, int payee, float amount){
        this.transactionHistory.add(new Transaction(payer, payee, amount));
        if(payer == this.getAcctNumber()){
            this.acctBalance -= amount;
        }
        else{
            this.acctBalance += amount;
        }
    }

    public ArrayList<Object> getTransaction(int i){
        ArrayList<Object> temp = new ArrayList<Object>();
        temp.add(this.transactionHistory.get(i).payer);
        temp.add(this.transactionHistory.get(i).payee);
        temp.add(this.transactionHistory.get(i).amount);
        return temp;
    }

    public List<Transaction> transactionSearch(int acct){
        List<Transaction> temp = new ArrayList<Transaction>();
        for (Transaction transaction : this.transactionHistory) {
            if ((transaction.payer == acct) || transaction.payee == acct) {
                temp.add(transaction);
            }
        }
        return temp;
    }

    public static class Transaction{
        int payer;
        int payee;
        float amount;

        public Transaction(){
            this.payer = 0;
            this.payee = 0;
            this.amount = 0F;
        }

        public Transaction(int payer,int payee, float amount){
            this.payer = payer;
            this.payee = payee;
            this.amount = amount;
        }

        @Override
        public String toString(){
            return "Sending Acct: " + this.payer + " Receiving Acct: " + payee + " Amount: " + amount;
        }
    }
}
