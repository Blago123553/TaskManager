package services;

import models.Client;
import models.Master;
import models.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    private PaymentService paymentService;
    private Client client;
    private Master master;
    private Service service;

    @BeforeEach
    void setup() {
        paymentService = new PaymentService();
        client = new Client("Мария", 2000.0);
        master = new Master("Игорь");
        service = new Service("Установка Windows", 1500.0);
    }

    @Test
    void processOrder_shouldTransferMoneyAndAssignService() {
        paymentService.processOrder(client, master, service);

        assertAll(
            () -> assertEquals(500.0, client.getMoney()),
            () -> assertEquals(1500.0, master.getMoney()),
            
            () -> assertEquals(service, client.getCurrentService()),
            () -> assertEquals(1, master.getServicesCount())
        );
    }

    @Test
    void processOrder_shouldNotChangeState_whenClientHasInsufficientFunds() {
        Service expensiveService = new Service("Сборка ПК", 5000.0);
        paymentService.processOrder(client, master, expensiveService);

        assertAll(
            () -> assertEquals(2000.0, client.getMoney()),
            () -> assertEquals(0.0, master.getMoney()),
            () -> assertNull(client.getCurrentService()),
            () -> assertEquals(0, master.getServicesCount())
        );
    }

    @Test
    void completeOrder_shouldClearClientServiceAndRemoveFromMaster() {
        paymentService.processOrder(client, master, service);
        
        paymentService.completeOrder(client, master, service);

        assertAll(
            () -> assertNull(client.getCurrentService()),
            () -> assertEquals(0, master.getServicesCount())
        );
    }
}