package models;
import interfaces.*;
import exceptions.*;

public class Client extends Person implements Finansable, Serviceable, Displayable {
    private double money;
    private Service currentService;

    public Client(String name, double initialMoney) {
        super(name);
        this.money = initialMoney;
        this.currentService = null;
    }

    @Override
    public double getMoney() { return money; }

    @Override
    public void addMoney(double amount) { this.money += amount; }

    @Override
    public void removeMoney(double amount) throws InsufficientFundsException {
        if (this.money < amount) {
            throw new InsufficientFundsException("Недостаточно средств у клиента: " + name);
        }
        this.money -= amount;
    }

    @Override
    public Service getCurrentService() { return currentService; }

    @Override
    public void setCurrentService(Service service) throws BusyPersonException {
        if (this.currentService != null) {
            throw new BusyPersonException("Клиент " + name + " уже имеет активный заказ.");
        }
        this.currentService = service;
    }

    @Override
    public void clearService() { this.currentService = null; }

    @Override
    public void showInfo() {
        String serviceName = (currentService != null) ? currentService.getTitle() : "Нет активных заказов";
        System.out.printf("Клиент: %s | Баланс: %.2f | Текущий заказ: %s%n", name, money, serviceName);
    }
}