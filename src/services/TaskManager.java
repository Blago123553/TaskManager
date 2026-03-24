package services;

import models.*;
import exceptions.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TaskManager {
    // Инициализация логгера
    private static final Logger logger = Logger.getLogger(TaskManager.class.getName());

    // Коллекция для истории выполненных задач
    private final List<Service> completedTasks = new ArrayList<>();

    /**
     * Оформление заказа
     */
    public void processOrder(Client client, Master master, Service service) {
        try {
            // Проверка денег
            client.removeMoney(service.getPrice());
            
            // Назначение задачи
            master.setCurrentService(service);
            client.setCurrentService(service);
            
            logger.info(">>> Заказ принят: " + service.getTitle() + " для " + client.getName());
        } catch (InsufficientFundsException | BusyPersonException e) {
            logger.log(Level.WARNING, "Ошибка оформления: {0}", e.getMessage());
        }
    }

    /**
     * Завершение текущего заказа
     */
    public void completeOrder(Client client, Master master) {
        Service current = master.getCurrentService();
        
        if (current != null) {
            // Мастер получает деньги
            master.addMoney(current.getPrice());
            
            // Сохраняем в историю
            completedTasks.add(current);
            
            // Освобождаем людей
            master.clearService();
            client.clearService();
            
            logger.info(">>> Заказ завершен: " + current.getTitle());
        } else {
            logger.warning("Попытка завершить заказ, когда мастер свободен.");
        }
    }

    /**
     * Аналитика через Stream API: 
     * Оставляем задачи > 30 минут, но СОРТИРУЕМ ПО ЦЕНЕ (от меньшей к большей)
     */
    public void printLongTasks() {
        System.out.println("\n ОТЧЕТ: Сортировка оказанных услуг по возрастанию цены.");
        
        completedTasks.stream()
            .sorted(Comparator.comparingDouble(Service::getPrice)) // 2. СОРТИРУЕМ ПО ПРАЙСУ (цене)
            .map(task -> String.format("- %s | Время: %d мин | Цена: %.2f руб.", 
                    task.getTitle(), task.getMinutes(), task.getPrice())) // 3. Выводим название, время и цену
            .forEach(System.out::println);                         // 4. Печатаем
            
        if (completedTasks.isEmpty()) {
            System.out.println("(Список выполненных задач пока пуст)");
        }
    }
}