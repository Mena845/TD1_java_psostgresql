-- 1 - Création de la table Product
create table  product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    creation_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- 2 - Création de la table Product_category
create table product_category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    product_id INT NOT NULL,

-- 3 - Clé étrangère vers product(id)
    CONSTRAINT fk_product
    FOREIGN KEY (product_id)
    REFERENCES product(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );
