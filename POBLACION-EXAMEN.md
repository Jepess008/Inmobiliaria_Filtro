## Proyecto BASES DE DATOS

JEFFERSON DARIO BELTRAN LASPRILLA - Campuslands

### Poblacion Base de Datos

//CIUDAD

INSERT INTO Ciudad (nombre) VALUES ('NombreCiudad1');
INSERT INTO Ciudad (nombre) VALUES ('NombreCiudad2');

//OFICINA

INSERT INTO oficina (nombre, direccion, id_ciudad) VALUES ('Oficina A', 'Dirección A', 1);
INSERT INTO oficina (nombre, direccion, id_ciudad) VALUES ('Oficina B', 'Dirección B', 2);



//ZONA

INSERT INTO zona (nombre) VALUES ('Zona A');
INSERT INTO zona (nombre) VALUES ('Zona B');



//PROPIETARIO

INSERT INTO propietario (nombre, apellido, telefono) VALUES ('Juan', 'Gómez', '123456789');
INSERT INTO propietario (nombre, apellido, telefono) VALUES ('María', 'Pérez', '987654321');
INSERT INTO propietario (nombre, apellido, telefono) VALUES ('Luis', 'Martínez', '555123456');
INSERT INTO propietario (nombre, apellido, telefono) VALUES ('Ana', 'López', '999888777');



//CLIENTE
INSERT INTO cliente (nombre, apellido, telefono) VALUES ('Juan', 'Gómez', '123456789');
INSERT INTO cliente (nombre, apellido, telefono) VALUES ('María', 'Pérez', '987654321');
INSERT INTO cliente (nombre, apellido, telefono) VALUES ('Luis', 'Martínez', '555123456');
INSERT INTO cliente (nombre, apellido, telefono) VALUES ('Ana', 'López', '999888777');



//Caracteristicas

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('200m2', 'Sí', 3, 2, 1, 1, 'Jardín trasero', 4, 'Soleado', 'Sí');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('150m2', 'No', 2, 1, 1, 1, 'Balcón con vista al mar', 3, 'Interior', 'No');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('300m2', 'Sí', 4, 3, 2, 2, 'Piscina privada', 5, 'Con terraza', 'Sí');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('180m2', 'Sí', 3, 2, 1, 1, 'Vistas a la montaña', 4, 'Sin amueblar', 'Sí');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('250m2', 'No', 4, 2, 1, 1, 'Garaje para dos coches', 5, 'Exterior', 'No');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('220m2', 'Sí', 3, 3, 1, 1, 'Chimenea', 4, 'Reformado recientemente', 'Sí');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('280m2', 'No', 5, 3, 2, 1, 'Patio interior', 6, 'Ático', 'No');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('200m2', 'Sí', 4, 2, 1, 1, 'Sistema de seguridad', 4, 'Luminoso', 'Sí');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('300m2', 'Sí', 6, 4, 3, 2, 'Gimnasio propio', 7, 'Con jardín', 'Sí');

INSERT INTO caracteristicas (tamaño_parcela, urbanizacion, habitaciones, baños, aseos, cocinas, especificas, num_puertas, diagano, acondicionado) VALUES ('180m2', 'No', 3, 1, 1, 1, 'Amueblado', 3, 'Tranquilo', 'No');



//TIPO

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Piso Nuevo', 1);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Casa', 2);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Villa', 3);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Local', 4);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Piso Usado', 5);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Villa', 6);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Local', 7);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Casa', 8);

INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Piso Nuevo', 9);
INSERT INTO tipo (nombre_tipo, id_caracteristicas) VALUES ('Piso Usado', 10);



//Visita

INSERT INTO visita (Estado, fecha, hora, comentario, id_cliente) VALUES ('Pendiente', '2024-04-12', '10:00', 'Visita pendiente de confirmación', 1);
INSERT INTO visita (Estado, fecha, hora, comentario, id_cliente) VALUES ('Confirmada', '2024-04-13', '11:30', 'Visita confirmada por el cliente', 2);
INSERT INTO visita (Estado, fecha, hora, comentario, id_cliente) VALUES ('Pendiente', '2024-04-14', '14:00', 'Visita pendiente de confirmación', 3);
INSERT INTO visita (Estado, fecha, hora, comentario, id_cliente) VALUES ('Confirmada', '2024-04-15', '16:30', 'Visita confirmada por el cliente', 4);



//Inmueble

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF001', '100 m2', 'Calle 123', 'Disponible', 100000, 'Sí', 1, 1, 1, 1);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF002', '150 m2', 'Avenida 456', 'Disponible', 150000, 'Sí', 2, 2, 2, 2);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF003', '200 m2', 'Calle Principal', 'No Disponible', 200000, 'No', 3, 1, 1, 3);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF004', '120 m2', 'Calle Secundaria', 'Disponible', 120000, 'Sí', 4, 2, 2, 4);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF005', '180 m2', 'Avenida 789', 'Disponible', 180000, 'Sí', 1, 2, 1, 5);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF006', '90 m2', 'Calle 456', 'Disponible', 90000, 'Sí', 2, 1, 2, 6);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF007', '210 m2', 'Calle 789', 'No Disponible', 210000, 'No', 3, 2, 1, 7);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF008', '130 m2', 'Avenida Principal', 'Disponible', 130000, 'Sí', 4, 1, 2, 8);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF009', '140 m2', 'Calle Secundaria', 'Disponible', 140000, 'Sí', 1, 2, 1, 9);

INSERT INTO inmueble (ref, superficie, direccion, disponible, precio, llaves, id_propietario, id_zona, id_oficina, id_tipo) VALUES ('REF010', '160 m2', 'Avenida 123', 'No Disponible', 160000, 'No', 2, 1, 2, 10);



visita_inmueble
INSERT INTO visita_inmueble (id_visita, id_inmueble) VALUES (1, 1);
INSERT INTO visita_inmueble (id_visita, id_inmueble) VALUES (2, 2);
INSERT INTO visita_inmueble (id_visita, id_inmueble) VALUES (3, 3);
INSERT INTO visita_inmueble (id_visita, id_inmueble) VALUES (4, 4);
