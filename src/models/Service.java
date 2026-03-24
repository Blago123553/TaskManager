package models;

// Реализуем Comparable для сортировки по умолчанию (например, по цене)
public class Service implements Comparable<Service> {
    private String title;
    private double price;
    private int minutes; // Время выполнения в минутах для Task Manager

    public Service(String title, double price, int minutes) {
        this.title = title;
        this.price = price;
        this.minutes = minutes;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getMinutes() { return minutes; }

    @Override
    public int compareTo(Service other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return String.format("Услуга: %s | Цена: %.2f | Время: %d мин", title, price, minutes);
    }
}
