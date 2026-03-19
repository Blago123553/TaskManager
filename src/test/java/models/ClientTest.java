package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;
    private Service service;

    @BeforeEach
    void setup() {
        client = new Client("Иван", 1000.0);
        service = new Service("Ремонт", 500.0);
    }

    @Test
    void addMoney_shouldIncreaseBalance() {
        client.addMoney(500.0);
        assertEquals(1500.0, client.getMoney());
    }

    @Test
    void removeMoney_shouldDecreaseBalance_whenSufficientFunds() throws Exception {
        client.removeMoney(200.0);
        assertEquals(800.0, client.getMoney());
    }

    @Test
    void removeMoney_shouldThrowException_whenInsufficientFunds() {
        Exception exception = assertThrows(Exception.class, () -> client.removeMoney(1500.0));
        assertEquals("Недостаточно средств у Клиента", exception.getMessage());
    }

    @Test
    void setCurrentService_shouldSetService_whenNoActiveService() throws Exception {
        client.setCurrentService(service);
        assertNotNull(client.getCurrentService());
        assertEquals("Ремонт", client.getCurrentService().getServiceName());
    }

    @Test
    void setCurrentService_shouldThrowException_whenAlreadyHasService() throws Exception {
        client.setCurrentService(service);
        Service newService = new Service("Установка ПО", 300.0);
        assertThrows(Exception.class, () -> client.setCurrentService(newService));
    }

    @Test
    void clearService_shouldRemoveService() throws Exception {
        client.setCurrentService(service);
        client.clearService();
        assertNull(client.getCurrentService());
    }
}