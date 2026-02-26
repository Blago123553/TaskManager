import models.Client;
import models.Master;
import models.Service;
import services.PaymentService;

public class Main {
    public static void main(String[] args) {
        Master masterAlex = new Master("Алексей (Мастер)");
        Client clientIvan = new Client("Иван (Клиент)", 5000.0);
        Client clientMaria = new Client("Мария (Клиент)", 1000.0);

        Service repairPhone = new Service("Ремонт телефона", 1500.0);
        Service installWindows = new Service("Установка Windows", 2000.0);

        PaymentService paymentService = new PaymentService();

        System.out.println("=== НАЧАЛЬНОЕ СОСТОЯНИЕ ===");
        masterAlex.showInfo();
        clientIvan.showInfo();
        clientMaria.showInfo();

        paymentService.processOrder(clientIvan, masterAlex, repairPhone);

        System.out.println("\n=== ПОСЛЕ ПЕРВОГО ЗАКАЗА ===");
        masterAlex.showInfo();
        clientIvan.showInfo();

        paymentService.processOrder(clientIvan, masterAlex, installWindows);
        paymentService.processOrder(clientMaria, masterAlex, installWindows);

        System.out.println("\n=== ФИНАЛЬНОЕ СОСТОЯНИЕ ===");
        masterAlex.showInfo();
        clientIvan.showInfo();
        clientMaria.showInfo();
    }
}