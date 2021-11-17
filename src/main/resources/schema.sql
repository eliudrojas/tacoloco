CREATE TABLE IF NOT EXISTS `orders` (`order_id` INTEGER   PRIMARY KEY AUTO_INCREMENT, `client_id` INTEGER   not null);

CREATE TABLE IF NOT EXISTS `client` (`client_id` INTEGER   PRIMARY KEY AUTO_INCREMENT, `name` varchar(50)   not null, `last_name` varchar(50) not null);

CREATE TABLE IF NOT EXISTS `product` (`product_id` INTEGER   PRIMARY KEY AUTO_INCREMENT, `name` varchar(50)   not null);

CREATE TABLE IF NOT EXISTS `order_details` (`order_id` INTEGER   PRIMARY KEY AUTO_INCREMENT, `product_id` INTEGER not null,
 quantity INTEGER not null,
 FOREIGN KEY (`order_id`)
 REFERENCES `orders`,
 FOREIGN KEY (`product_id`)
   REFERENCES `product`
 );
