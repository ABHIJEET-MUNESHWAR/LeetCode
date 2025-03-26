create table vehicle
(
    id          serial primary key,
    name        varchar(255) not null,
    type        varchar(255) check (type IN ('BIKE', 'SCOOTER')),
    isAvailable boolean      not null default true
)

create table bike
(
    id        serial primary key,
    vehicleId int references vehicle (id) on delete cascade,
    size      varchar(10) check (type in ('small', 'medium', 'large'))
)

create table scooter
(
    id        serial primary key,
    vehicleId int references vehicle (id) on delete cascade,
    motorType varchar(10) check (type in ('electric', 'gas'))
)

create table customer
(
    id      serial primary key,
    name    varchar(255) not null,
    balance decimal(10, 2) default 0.0
)

create table rental
(
    id          SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers (id) ON DELETE CASCADE,
    vehicle_id  INT REFERENCES vehicles (id) ON DELETE CASCADE,
    rental_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    return_date TIMESTAMP,
    is_overdue  BOOLEAN   DEFAULT FALSE
)

create table transaction
(
    id          SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers (id) ON DELETE CASCADE,
    amount      DECIMAL(10, 2) NOT NULL,
    type        VARCHAR(10) CHECK (type IN ('FINE', 'PAYMENT')),
    timestamp   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)