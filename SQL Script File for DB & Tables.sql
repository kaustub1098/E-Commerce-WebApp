-- Database: EcommerceStoreDb

-- DROP DATABASE IF EXISTS "EcommerceStoreDb";

CREATE DATABASE "EcommerceStoreDb"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

------------------------------------------------------------------------
-- Table: public.order_items

-- DROP TABLE IF EXISTS public.order_items;

CREATE TABLE IF NOT EXISTS public.order_items
(
    id integer NOT NULL,
    order_total_price bigint,
    order_id integer,
    product_id bigint NOT NULL,
    CONSTRAINT order_items_pkey PRIMARY KEY (id),
    CONSTRAINT fkbioxgbv59vetrxe0ejfubep1w FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknq9h86l7j5434kx37pj6h9mwj FOREIGN KEY (product_id)
        REFERENCES public.product_info (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.order_items
    OWNER to postgres;

------------------------------------------------------------------------

-- Table: public.orders

-- DROP TABLE IF EXISTS public.orders;

CREATE TABLE IF NOT EXISTS public.orders
(
    id bigint NOT NULL,
    order_total bigint NOT NULL,
    order_date date NOT NULL,
    order_time time without time zone NOT NULL,
    payment_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    adddress_id bigint NOT NULL,
    product_id bigint,
    user_id integer,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk5b157pu8r98owtscqgt5lf57f FOREIGN KEY (adddress_id)
        REFERENCES public.shipping_address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhto0jfuo6klykke45uv2g9am FOREIGN KEY (product_id)
        REFERENCES public.product_info (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.orders
    OWNER to postgres;


------------------------------------------------------------------------

-- Table: public.product_category

-- DROP TABLE IF EXISTS public.product_category;

CREATE TABLE IF NOT EXISTS public.product_category
(
    id bigint NOT NULL,
    category_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_category_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product_category
    OWNER to postgres;

-------------------------------------------------------------------------

-- Table: public.product_info

-- DROP TABLE IF EXISTS public.product_info;

CREATE TABLE IF NOT EXISTS public.product_info
(
    id bigint NOT NULL,
    product_description character varying(255) COLLATE pg_catalog."default" NOT NULL,
    product_image_url character varying(255) COLLATE pg_catalog."default" NOT NULL,
    product_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    product_price integer NOT NULL,
    product_stock_quantity integer NOT NULL,
    category_id bigint,
    CONSTRAINT product_info_pkey PRIMARY KEY (id),
    CONSTRAINT fkpvsqpy81lna9e46wrei24uvem FOREIGN KEY (category_id)
        REFERENCES public.product_category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product_info
    OWNER to postgres;


------------------------------------------------------------------------------------------

-- Table: public.shipping_address

-- DROP TABLE IF EXISTS public.shipping_address;

CREATE TABLE IF NOT EXISTS public.shipping_address
(
    id bigint NOT NULL,
    city character varying(255) COLLATE pg_catalog."default" NOT NULL,
    country character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    house_no integer NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    mobile_no integer NOT NULL,
    pincode integer NOT NULL,
    state character varying(255) COLLATE pg_catalog."default" NOT NULL,
    street_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    houseno integer,
    mobileno integer,
    CONSTRAINT shipping_address_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.shipping_address
    OWNER to postgres;


---------------------------------------------------------------------------------------

-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL,
    address character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_address character varying(255) COLLATE pg_catalog."default",
    user_emailid character varying(255) COLLATE pg_catalog."default",
    user_first_name character varying(255) COLLATE pg_catalog."default",
    user_last_name character varying(255) COLLATE pg_catalog."default",
    user_password character varying(255) COLLATE pg_catalog."default",
    user_phone_number character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;