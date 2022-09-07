-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-04 21:05:15.683

-- tables
-- Table: address
CREATE TABLE address (
    id_address serial  NOT NULL,
    street varchar(100)  NOT NULL,
    zone varchar(50)  NOT NULL,
    h_number varchar(50)  NOT NULL,
    city varchar(50)  NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (id_address)
);

-- Table: business
CREATE TABLE business (
    id_business serial  NOT NULL,
    name_business varchar(50)  NOT NULL,
    address_id_address int  NOT NULL,
    CONSTRAINT business_pk PRIMARY KEY (id_business)
);

-- Table: delivery
CREATE TABLE delivery (
    id_delivery serial  NOT NULL,
    user_address_id_user_address int  NOT NULL,
    user_id_user int  NOT NULL,
    business_id_business int  NOT NULL,
    CONSTRAINT delivery_pk PRIMARY KEY (id_delivery)
);

-- Table: dish
CREATE TABLE dish (
    id_dish serial  NOT NULL,
    name varchar(50)  NOT NULL,
    description varchar(200)  NOT NULL,
    cost money  NOT NULL,
    business_id_business int  NOT NULL,
    CONSTRAINT dish_pk PRIMARY KEY (id_dish)
);

-- Table: order
CREATE TABLE "order" (
    id_order serial  NOT NULL,
    total_payment money  NOT NULL,
    order_status_id_order_status int  NOT NULL,
    type_payment_id_typepay int  NOT NULL,
    delivery_id_delivery int  NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id_order)
);

-- Table: order_details
CREATE TABLE order_details (
    id_order_details serial  NOT NULL,
    order_id_order int  NOT NULL,
    dish_id_dish int  NOT NULL,
    CONSTRAINT order_details_pk PRIMARY KEY (id_order_details)
);

-- Table: order_status
CREATE TABLE order_status (
    id_order_status serial  NOT NULL,
    order_status varchar(50)  NOT NULL,
    CONSTRAINT order_status_pk PRIMARY KEY (id_order_status)
);

-- Table: type_payment
CREATE TABLE type_payment (
    id_typepay serial  NOT NULL,
    type varchar(50)  NOT NULL,
    CONSTRAINT type_payment_pk PRIMARY KEY (id_typepay)
);

-- Table: type_user
CREATE TABLE type_user (
    typeid serial  NOT NULL,
    name_rol varchar(50)  NOT NULL,
    description varchar(100)  NOT NULL,
    CONSTRAINT type_user_pk PRIMARY KEY (typeid)
);

-- Table: user
CREATE TABLE "user" (
    id_user serial  NOT NULL,
    name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    phone varchar(50)  NOT NULL,
    mail varchar(50)  NOT NULL,
    type_user_typeid int  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id_user)
);

-- Table: user_address
CREATE TABLE user_address (
    id_user_address serial  NOT NULL,
    user_id_user int  NOT NULL,
    address_id_address int  NOT NULL,
    status int  NOT NULL,
    CONSTRAINT user_address_pk PRIMARY KEY (id_user_address)
);

-- foreign keys
-- Reference: business_address (table: business)
ALTER TABLE business ADD CONSTRAINT business_address
    FOREIGN KEY (address_id_address)
    REFERENCES address (id_address)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: delivery_business (table: delivery)
ALTER TABLE delivery ADD CONSTRAINT delivery_business
    FOREIGN KEY (business_id_business)
    REFERENCES business (id_business)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: delivery_user (table: delivery)
ALTER TABLE delivery ADD CONSTRAINT delivery_user
    FOREIGN KEY (user_id_user)
    REFERENCES "user" (id_user)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: delivery_user_address (table: delivery)
ALTER TABLE delivery ADD CONSTRAINT delivery_user_address
    FOREIGN KEY (user_address_id_user_address)
    REFERENCES user_address (id_user_address)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: dish_business (table: dish)
ALTER TABLE dish ADD CONSTRAINT dish_business
    FOREIGN KEY (business_id_business)
    REFERENCES business (id_business)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_delivery (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_delivery
    FOREIGN KEY (delivery_id_delivery)
    REFERENCES delivery (id_delivery)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_details_dish (table: order_details)
ALTER TABLE order_details ADD CONSTRAINT order_details_dish
    FOREIGN KEY (dish_id_dish)
    REFERENCES dish (id_dish)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_details_order (table: order_details)
ALTER TABLE order_details ADD CONSTRAINT order_details_order
    FOREIGN KEY (order_id_order)
    REFERENCES "order" (id_order)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_order_status (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_order_status
    FOREIGN KEY (order_status_id_order_status)
    REFERENCES order_status (id_order_status)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_type_payment (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_type_payment
    FOREIGN KEY (type_payment_id_typepay)
    REFERENCES type_payment (id_typepay)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_address_address (table: user_address)
ALTER TABLE user_address ADD CONSTRAINT user_address_address
    FOREIGN KEY (address_id_address)
    REFERENCES address (id_address)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_address_user (table: user_address)
ALTER TABLE user_address ADD CONSTRAINT user_address_user
    FOREIGN KEY (user_id_user)
    REFERENCES "user" (id_user)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_type_user (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_type_user
    FOREIGN KEY (type_user_typeid)
    REFERENCES type_user (typeid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

