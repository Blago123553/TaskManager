package interfaces;

public interface Finansable {
    double getMoney();
    void addMoney(double amount);
    void removeMoney(double amount) throws Exception;
}