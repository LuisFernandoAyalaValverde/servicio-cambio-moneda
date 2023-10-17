/*insert*/
INSERT INTO MONEDA (codigo, descripcion) VALUES ('USD', 'Dólar estadounidense');
INSERT INTO MONEDA (codigo, descripcion) VALUES ('EUR', 'Euro');
INSERT INTO MONEDA (codigo, descripcion) VALUES ('GBP', 'Libra esterlina');
INSERT INTO MONEDA (codigo, descripcion) VALUES ('JPY', 'Yen japonés');
INSERT INTO MONEDA (codigo, descripcion) VALUES ('CAD', 'Dólar canadiense');

INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (1, 2, 0.85);
INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (2, 1, 1.18);

INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (3, 4, 143.91);
INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (4, 3, 0.007);

INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (5, 1, 0.79);
INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (1, 5, 1.27);

INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (2, 3, 0.88);
INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (3, 2, 1.14);

INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (4, 5, 94.36);
INSERT INTO tipo_cambio (moneda_origen_id, moneda_destino_id, valor) VALUES (5, 4, 0.011);