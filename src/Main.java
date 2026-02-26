import models.Client;
import models.Master;
import models.Service;

public class Main {
    public static void main(String[] args) {
        Master masterAlex = new Master("Алексей (Мастер)");
        Client clientIvan = new Client("Иван (Клиент)", 5000.0);

        Service repairPhone = new Service("Ремонт телефона", 1500.0);

        System.out.println("=== НАЧАЛЬНОЕ СОСТОЯНИЕ ===");
        masterAlex.showInfo();
        clientIvan.showInfo();

        // Ручная обработка заказа (временное решение)
        try {
            clientIvan.setMoney(clientIvan.getMoney() - repairPhone.getPrice());
            masterAlex.setMoney(masterAlex.getMoney() + repairPhone.getPrice());
            masterAlex.addService(repairPhone);
            clientIvan.setCurrentService(repairPhone);
            System.out.println("\n>>> Заказ оформлен вручную!");
        } catch (Exception e) {
            System.out.println(">>> Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== ПОСЛЕ ЗАКАЗА ===");
        masterAlex.showInfo();
        clientIvan.showInfo();
    }
}