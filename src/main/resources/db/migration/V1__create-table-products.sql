CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name_product VARCHAR(255) NOT NULL,
    code_product VARCHAR(10) UNIQUE NOT NULL,
    desc_product TEXT NOT NULL,
    price_product DECIMAL(10, 2) NOT NULL
);
