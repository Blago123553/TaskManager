package models;

import interfaces.Displayable;
import interfaces.Finansable;
import interfaces.Serviceable;

public class Client extends Person implements Finansable, Serviceable, Displayable {
    private double money;
    private Service currentService;

    public Client(String name, double initialMoney) {
        super(name);
        this.money = initialMoney;
        this.currentService = null;
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
            throw new Exception("Недостаточно средств у Клиента");
        }
        this.money -= amount;
    }

    @Override
    public Service getCurrentService() {
        return currentService;
    }

    @Override
    public void setCurrentService(Service service) throws Exception {
        if (this.currentService != null) {
            throw new Exception("Клиент уже заказал услугу: " + this.currentService.getServiceName());
        }
        this.currentService = service;
    }

    @Override
    public void clearService() {
        this.currentService = null;
    }

    @Override
    public void showInfo() {
        System.out.println("--- Информация о Клиенте ---");
        System.out.println("ID: " + getId());
        System.out.println("Имя: " + getName());
        System.out.println("Баланс: " + getMoney() + " руб.");
        if (currentService != null) {
            System.out.println("Заказанная задача: " + currentService.getServiceName() + 
                             " (" + currentService.getPrice() + " руб.)");
        } else {
            System.out.println("Заказанная задача: Нет");
        }
        System.out.println("-----------------------------");
    }
}