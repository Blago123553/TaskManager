package models;
import interfaces.*;
import exceptions.*;

public class Master extends Person implements Serviceable, Displayable, Finansable {
    private double earnings;
    private Service currentService;

    public Master(String name) {
        super(name);
        this.earnings = 0.0;
        this.currentService = null;
    }

    @Override
    public double getMoney() { return earnings; }

    @Override
    public void addMoney(double amount) { this.earnings += amount; }

    @Override
    public void removeMoney(double amount) throws InsufficientFundsException {
        if (this.earnings < amount) {
            throw new InsufficientFundsException("Недостаточно средств у мастера.");
        }
        this.earnings -= amount;
    }

    @Override
    public Service getCurrentService() { return currentService; }

    @Override
    public void setCurrentService(Service service) throws BusyPersonException {
        if (this.currentService != null) {
            throw new BusyPersonException("Мастер " + name + " уже занят другой задачей.");
        }
        this.currentService = service;
    }

    @Override
    public void clearService() { this.currentService = null; }

    @Override
    public void showInfo() {
        String serviceName = (currentService != null) ? currentService.getTitle() : "Свободен";
        System.out.printf("Мастер: %s | Заработано: %.2f | Текущая задача: %s%n", name, earnings, serviceName);
    }
}