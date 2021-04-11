CREATE TABLE categories_products
(
    product_id  INT,
    category_id INT,
    CONSTRAINT movie_cat_pk PRIMARY KEY (product_id, category_id),
    CONSTRAINT FK_movie
        FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT FK_category
        FOREIGN KEY (category_id) REFERENCES categories (id)
);