package models;

import interfaces.Displayable;
import interfaces.Finansable;

import java.util.ArrayList;
import java.util.List;

public class Master extends Person implements Finansable, Displayable {
    private double money;
    private final List<Service> activeServices;

    public Master(String name) {
        super(name);
        this.money = 0.0;
        this.activeServices = new ArrayList<>();
    }

    @Override
    public double getMoney() {
        return money;
    }

    @Override
    public void addMoney(double amount) {
        this.money += amount;
    }

    @Override
    public void removeMoney(double amount) throws Exception {
        if (this.money < amount) {
            throw new Exception("Недостаточно средств у Мастера");
        }
        this.money -= amount;
    }

    public void addService(Service service) {
        activeServices.add(service);
    }

    public void completeService(Service service) {
        activeServices.remove(service);
    }

    public int getServicesCount() {
        return activeServices.size();
    }

    @Override
    public void showInfo() {
        System.out.println("--- Информация о Мастере ---");
        System.out.println("ID: " + getId());
        System.out.println("Имя: " + getName());
        System.out.println("Баланс: " + getMoney() + " руб.");
        System.out.println("Выполняемых услуг сейчас: " + getServicesCount());
        System.out.println("-----------------------------");
    }
}