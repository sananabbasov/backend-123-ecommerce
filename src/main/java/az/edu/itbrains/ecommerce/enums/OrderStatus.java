package az.edu.itbrains.ecommerce.enums;

public enum OrderStatus {
    PENDING,        // Order has been received but not yet processed
    PROCESSING,     // Order is being prepared or fulfilled
    SHIPPED,        // Order has been shipped
    DELIVERED,      // Order has been delivered to the customer
    CANCELED,       // Order has been canceled
    RETURNED,       // Order has been returned by the customer
    REFUNDED        // Payment for the order has been refunded
}
