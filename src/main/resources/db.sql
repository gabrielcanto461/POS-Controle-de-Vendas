CREATE TABLE public.address(
    address_id int8 primary key,
    city varchar(255),
    complement varchar(255),
    district varchar(255),
    number varchar(10),
    street varchar(255)
);

CREATE TABLE public.account(
    account_number int8 primary key,
    debt float8
);

CREATE TABLE public.customer(
    customer_id int8 primary key,
    district varchar(255),
    name varchar(255),
    account_number int8,
    address_id int8,
    CONSTRAINT fk_address
        FOREIGN KEY(address_id)
            REFERENCES address(address_id),
    CONSTRAINT fk_account
        FOREIGN KEY(account_number)
            REFERENCES account(account_number)

);


INSERT INTO public.address
(address_id, city, complement, district, "number" , street)
VALUES(1, 'Campinas', 'Casa', 'Satélite Íris', '50', 'Rua Geraldo de Campos Ferreira');

INSERT INTO public.account
(account_number, debt)
values(1, 0);

INSERT INTO public.customer
(customer_id, district, name, account_number, address_id)
VALUES(1, 'Satélite', 'Gabriel Augusto', 1, 1);
