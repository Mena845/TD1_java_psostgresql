-- 1 - Insertion dans la table product
INSERT INTO product (name, price, creation_datetime) VALUES
   ('Laptop Pro X', 1500.00, '2024-01-10 10:00:00'),
    ('Mechanical Keyboard', 120.00, '2024-02-15 12:30:00'),
    ('Gaming Mouse', 60.00, '2024-03-01 08:20:00'),
    ('USB-C Hub', 45.00, '2024-01-25 14:00:00');

-- 2 - Insertion dans la table product category
INSERT INTO product_category (name, product_id) VALUES
    ('Electronics', 1),
    ('Computers', 1),
     ('Accessories', 2),
     ('Gaming', 3),
     ('Accessories', 4);
