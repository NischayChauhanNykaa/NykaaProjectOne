# NykaaProjectOne

## Database Scheme

### product 
``` 
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `prodcut_info` varchar(1000) NOT NULL,
  `product_image` varchar(255) NOT NULL,
  `product_location` varchar(250) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `product_price` varchar(20) NOT NULL,
  `product_thumbnail` varchar(50) NOT NULL,
  `updated` datetime DEFAULT NULL,
  `product_category_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKibmbqqcc97sxli35lnikn0ulu` (`product_category_category_id`),
  CONSTRAINT `FKibmbqqcc97sxli35lnikn0ulu` FOREIGN KEY (`product_category_category_id`) REFERENCES `product_category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
```

### product category 
``` 
CREATE TABLE `product_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  `created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
```

### user  
```
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `email_verified` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `registration_date` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
```

### user_order
```
CREATE TABLE `user_order` (
  `order_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `order_amount` float NOT NULL,
  `order_city` varchar(255) DEFAULT NULL,
  `order_country` varchar(255) DEFAULT NULL,
  `order_email` varchar(255) DEFAULT NULL,
  `order_phone` varchar(255) DEFAULT NULL,
  `order_shipment_address` varchar(255) DEFAULT NULL,
  `order_shipment_charge` float NOT NULL,
  `order_shipment_name` varchar(255) DEFAULT NULL,
  `order_shipped` bit(1) NOT NULL,
  `order_state` varchar(255) DEFAULT NULL,
  `order_zip` varchar(255) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `order_user_id_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK53f6xpom4jwqyvflj188kbbo5` (`order_user_id_user_id`),
  CONSTRAINT `FK53f6xpom4jwqyvflj188kbbo5` FOREIGN KEY (`order_user_id_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
```

### user_order_details 
```
CREATE TABLE `user_order_details` (
  `details_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `details_name` varchar(255) DEFAULT NULL,
  `details_price` varchar(255) DEFAULT NULL,
  `details_quantity` int(11) NOT NULL,
  `updated` datetime DEFAULT NULL,
  `order_id_order_id` bigint(20) DEFAULT NULL,
  `product_id_product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`details_id`),
  KEY `FKfj4w69kyw4dlt8nc3jalfn4na` (`order_id_order_id`),
  KEY `FK92fhllh2yhf4r9yh1vs2eotkg` (`product_id_product_id`),
  CONSTRAINT `FK92fhllh2yhf4r9yh1vs2eotkg` FOREIGN KEY (`product_id_product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKfj4w69kyw4dlt8nc3jalfn4na` FOREIGN KEY (`order_id_order_id`) REFERENCES `user_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
```
