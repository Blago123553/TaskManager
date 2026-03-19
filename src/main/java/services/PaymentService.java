package services;

import models.Client;
import models.Master;
import models.Service;

public class PaymentService {
    
    public void processOrder(Client client, Master master, Service service) {
        try {
            System.out.println("\n>>> Попытка оформления заказа: " + service.getServiceName());
            
            client.removeMoney(service.getPrice());
            master.addMoney(service.getPrice());
            master.addService(service);
            client.setCurrentService(service);
            
            System.out.println(">>> Успешно! Деньги переведены, услуга назначена.");
            
        } catch (Exception e) {
            System.out.println(">>> Ошибка транзакции: " + e.getMessage());
        }
    }

    public void completeOrder(Client client, Master master, Service service) {
        System.out.println("\n>>> Завершение услуги: " + service.getServiceName());
        master.completeService(service);
        client.clearService();
        System.out.println(">>> Услуга завершена.");
    }
}