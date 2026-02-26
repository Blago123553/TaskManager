package models;

import java.util.ArrayList;
import java.util.List;

public class Master extends Person {
    private double money;
    private final List<Service> activeServices;

    public Master(String name) {
        super(name);
        this.money = 0.0;
        this.activeServices = new ArrayList<>();
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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

    public void showInfo() {
        System.out.println("--- Информация о Мастере ---");
        System.out.println("ID: " + getId());
        System.out.println("Имя: " + getName());
        System.out.println("Баланс: " + getMoney() + " руб.");
        System.out.println("Выполняемых услуг сейчас: " + getServicesCount());
        System.out.println("-----------------------------");
    }
}