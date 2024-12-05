package org.mycompany.shopinventory.sqs;

public record OrderEvent(Long productId,
                         OrderStatus status,
                         Integer quantity) {
}
