import models.*;
import services.TaskManager; // Импорт нового класса

public class Main {
    public static void main(String[] args) {
        // Создаем менеджера
        TaskManager manager = new TaskManager();

        // Создаем участников
        Master master = new Master("Алексей");
        Client client = new Client("Иван", 3500.0);

        // Создаем услуги (название, цена, длительность в минутах)
        Service task1 = new Service("Сборка ПК", 3000.0, 120);
        Service task2 = new Service("Чистка от пыли", 500.0, 20);
        Service task3 = new Service("Настройка сети", 1500.0, 45);

        // Работаем
        manager.processOrder(client, master, task1);
        manager.completeOrder(client, master);

        manager.processOrder(client, master, task2);
        manager.completeOrder(client, master);
        
        manager.processOrder(client, master, task3);
        manager.completeOrder(client, master);

        // Вызываем тот самый метод, который выдавал ошибку
        manager.printLongTasks();
    }
}