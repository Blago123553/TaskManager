package models;

public class Client extends Person {
    private double money;
    private Service currentService;

    public Client(String name, double initialMoney) {
        super(name);
        this.money = initialMoney;
        this.currentService = null;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Service getCurrentService() {
        return currentService;
    }

    public void setCurrentService(Service service) throws Exception {
        if (this.currentService != null) {
            throw new Exception("Клиент уже заказал услугу: " + this.currentService.getServiceName());
        }
        this.currentService = service;
    }

    public void clearService() {
        this.currentService = null;
    }

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