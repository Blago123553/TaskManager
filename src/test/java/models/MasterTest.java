package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MasterTest {
    private Master master;
    private Service service;

    @BeforeEach
    void setup() {
        master = new Master("Алексей");
        service = new Service("Настройка сети", 1000.0);
    }

    @Test
    void initialBalanceAndServicesCount_shouldBeZero() {
        assertAll(
            () -> assertEquals(0.0, master.getMoney()),
            () -> assertEquals(0, master.getServicesCount())
        );
    }

    @Test
    void addService_shouldIncreaseServicesCount() {
        master.addService(service);
        assertEquals(1, master.getServicesCount());
    }

    @Test
    void completeService_shouldDecreaseServicesCount() {
        master.addService(service);
        master.completeService(service);
        assertEquals(0, master.getServicesCount());
    }

    @Test
    void removeMoney_shouldThrowException_whenInsufficientFunds() {
        assertThrows(Exception.class, () -> master.removeMoney(100.0));
    }
}