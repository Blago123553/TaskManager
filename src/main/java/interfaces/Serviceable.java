package interfaces;

import models.Service;

public interface Serviceable {
    Service getCurrentService();
    void setCurrentService(Service service) throws Exception;
    void clearService();
}