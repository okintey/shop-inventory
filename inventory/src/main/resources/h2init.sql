CREATE TABLE IF NOT EXISTS category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');
INSERT INTO category (id, name) VALUES (3, 'Clothing');
INSERT INTO category (id, name) VALUES (4, 'Home & Kitchen');
INSERT INTO category (id, name) VALUES (5, 'Sports & Outdoors');

CREATE TABLE IF NOT EXISTS supplier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20),
    email VARCHAR(255),
    additionalInfo TEXT
);

INSERT INTO supplier (id, name, phoneNumber, email, additionalInfo) VALUES
(1, 'Supplier A', '123-456-7890', 'supplierA@example.com', 'Additional info A'),
(2, 'Supplier B', '234-567-8901', 'supplierB@example.com', 'Additional info B'),
(3, 'Supplier C', '345-678-9012', 'supplierC@example.com', 'Additional info C'),
(4, 'Supplier D', '456-789-0123', 'supplierD@example.com', 'Additional info D'),
(5, 'Supplier E', '567-890-1234', 'supplierE@example.com', 'Additional info E');

CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    supplier_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

INSERT INTO products (name, description, price, quantity, supplier_id, category_id) VALUES
('Laptop', 'High performance laptop', 999.99, 50, 1, 1),
('Smartphone', 'Latest model smartphone', 699.99, 100, 1, 1),
('Novel', 'Bestselling novel', 19.99, 200, 2, 2),
('T-shirt', 'Comfortable cotton t-shirt', 9.99, 150, 3, 3),
('Blender', 'High-speed blender', 49.99, 75, 4, 4),
('Tennis Racket', 'Professional tennis racket', 89.99, 30, 5, 5);