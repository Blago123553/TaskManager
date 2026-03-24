package interfaces;
import models.Service;
import exceptions.BusyPersonException;

public interface Serviceable {
    Service getCurrentService();
    void setCurrentService(Service service) throws BusyPersonException;
    void clearService();
}