CREATE TABLE company
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    logo_url VARCHAR(255)
);

CREATE TABLE designer
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

CREATE TABLE mascot
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    photo VARCHAR(255),
    rating FLOAT,
    designer_id INT,
    FOREIGN KEY (designer_id) REFERENCES designer(id)
);

CREATE TABLE mascot_company
(
    mascot_id INT,
    company_id INT,
    FOREIGN KEY (mascot_id) REFERENCES mascot(id),
    FOREIGN KEY (company_id) REFERENCES company(id)
);

INSERT INTO company (id, name, logo_url) VALUES
                                             (1, 'Glitch Productions', 'https://upload.wikimedia.org/wikipedia/en/thumb/6/63/Glitch_Productions_2023.svg/1280px-Glitch_Productions_2023.svg.png'),
                                             (2, 'fangamer', 'https://www.fangamer.com/cdn/shop/files/fg-logo-stacked-margins.png?height=500&v=1695396365');
INSERT INTO designer (id, first_name, last_name) VALUES
                                                     (1, 'Lucy', 'Xue'),
                                                     (2, 'Matt', 'Gaglione'),
                                                     (3, 'Saber', 'Murphy');

INSERT INTO mascot (id, name, photo, rating, designer_id) VALUES
                                                              (1, 'Temmie Plush', 'https://www.fangamer.com/cdn/shop/products/product_UT_shoptem_plush_photo2_86483699-836d-46b7-ac07-97d52a47fd3e.png', 5, 3),
                                                              (2, 'Lancer Plush', 'https://www.fangamer.com/cdn/shop/products/product_DR_lancer_plush_photo0.png', 5, 3),
                                                              (3, 'Pomni Plush', 'https://glitchproductions.store/cdn/shop/files/pomni-plush-2.png', 5, 1),
                                                              (4, 'Kinger Plush', 'https://glitchproductions.store/cdn/shop/files/kinger-plush-2.png', 5, 2),
                                                              (5, 'Jax Plush', 'https://glitchproductions.store/cdn/shop/files/jax-plush-1.png', 5, 1);

INSERT INTO mascot_company (mascot_id, company_id) VALUES
                                                       (1, 2), -- Temmie -> fangamer
                                                       (2, 2), -- Lancer -> fangamer
                                                       (3, 1), -- Pomni -> Glitch
                                                       (4, 1), -- Kinger -> Glitch
                                                       (5, 1); -- Jax -> Glitch
















CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', 'dbuser1'),
       ('dbuser2', 'dbuser2'),
       ('dbuser3', 'dbuser3');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'ROLE_ADMIN'),
       ('dbuser2', 'ROLE_AUTHOR_ADMIN'),
       ('dbuser3', 'ROLE_BOOK_ADMIN');




