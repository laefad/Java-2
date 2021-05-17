CREATE SEQUENCE public.items_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.items_id_seq
    OWNER TO postgres;

CREATE SEQUENCE public.orders_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.orders_id_seq
    OWNER TO postgres;
	
CREATE TABLE public.items
(
    item_id integer NOT NULL DEFAULT nextval('items_id_seq'::regclass),
    item_name character varying(30) COLLATE pg_catalog."default",
    creation_date date,
    price double precision,
    order_id integer NOT NULL,
    CONSTRAINT items_pkey PRIMARY KEY (item_id)
);

ALTER TABLE public.items
    OWNER to postgres;
	
CREATE TABLE public.orders
(
    order_id integer NOT NULL DEFAULT nextval('orders_id_seq'::regclass),
    order_date date,
    CONSTRAINT orders_pkey PRIMARY KEY (order_id)
);

ALTER TABLE public.orders
    OWNER to postgres;
	
ALTER TABLE public.items
	ADD CONSTRAINT items_order_id_fkey FOREIGN KEY (order_id)
		REFERENCES public.orders (order_id) MATCH SIMPLE
		ON UPDATE NO ACTION
		ON DELETE NO ACTION;
		
CREATE ROLE java WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  PASSWORD 'java';