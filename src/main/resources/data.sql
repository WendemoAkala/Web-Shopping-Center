DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS favorite;
DROP TABLE IF EXISTS item;


CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     first_name varchar(255) NOT NULL DEFAULT '',
     last_name varchar(255) NOT NULL DEFAULT '',
     email varchar(255) NOT NULL DEFAULT '',
     phone varchar(255) NOT NULL DEFAULT '',
     address varchar(255) NOT NULL DEFAULT '',
     username varchar(255) NOT NULL DEFAULT '',
     password varchar(255) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     roles varchar(200) NOT NULL DEFAULT '',
     permissions varchar(200) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

INSERT INTO user (username, password, active, roles, permissions) VALUES
    ('dan', '1234', 1, '', ''),
    ('alon', '12345', 1, '', '');

CREATE TABLE orders (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     user_id int (1200) unsigned NOT NULL AUTO_INCREMENT,
     order_date TIMESTAMP (23,10),
     shipping_address varchar(200) NOT NULL DEFAULT '',
     total_price DOUBLE(20) NOT NULL DEFAULT '',
     status varchar(20) NOT NULL DEFAULT '',
     PRIMARY KEY (id),
     FOREIGN KEY (user_id) REFERENCES user (id)
     );

INSERT INTO orders (user_id, shipping_address, total_price, status) VALUES
             (1, '' , 200, 'TEMP'),
             (2, 'asdasd dg' , 200, 'TEMP');

CREATE TABLE item (
      id int(11) unsigned NOT NULL AUTO_INCREMENT,
      title varchar(200) NOT NULL DEFAULT '',
      photo_url varchar(200) NOT NULL DEFAULT '',
      price DOUBLE(20) NOT NULL DEFAULT '',
      stock_count int(11) NOT NULL DEFAULT '',
      PRIMARY KEY (id)
      );

INSERT INTO item (title, photo_url, price, stock_count)VALUES

     ( 'Corpuls3', 'Corpuls3', 10, 10),
     ( 'Corpuls1', 'Corpuls1', 8, 13),
     ('CorpulsCPR', 'CorpulsCPR',10, 8),
     ('CorpulsAED', 'CorpulsAED', 20, 10),
     ('K1', 'K1', 10, 10),
     ('CMS System', 'CMS', 8, 6),
     ('NC12', 'NC12', 10, 11),
     ('NC19', 'NC19', 10, 7),
     ('G3-Cardiac Sience', 'G3FrontPage', 10, 17),
     ('Other Productes', 'G3FrontPage', 1, 1);


CREATE TABLE favorite (
      id int(11) unsigned NOT NULL AUTO_INCREMENT,
      user_id int(11) unsigned NOT NULL DEFAULT '',
      items varchar(1500) unsigned NOT NULL DEFAULT '',
      PRIMARY KEY (id),
      FOREIGN KEY (user_id) REFERENCES user (id)

       );

INSERT INTO favorite (user_id) VALUES
        (1);