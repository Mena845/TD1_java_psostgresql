create table Product (
    id SERIAL primary key,
    name varchar(200) not null ,
    price numeric (10,2) not null ,
    creation_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Product_category(
    id SERIAL primary key,
    name varchar(200) not null ,
    product_id int not null ,
    constraint fk_product foreign key (product_id) references Product(id)
);


