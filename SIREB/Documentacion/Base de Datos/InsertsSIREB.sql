-- seleccionando base de datos --
USE  SIREB;

#insertando datos en la base de datos

-- insertando datos en tabla MotivosBajas --
INSERT INTO MotivosBajas (motivo,descripcion) VALUES ('Baja Medica','Baja por motivos de salud');
INSERT INTO MotivosBajas (motivo,descripcion) VALUES ('Baja por Mudanza','Baja por mudanza');
INSERT INTO MotivosBajas (motivo,descripcion) VALUES ('Baja a RA','Baja por paso a reserva Activa');
INSERT INTO MotivosBajas (motivo,descripcion) VALUES ('Baja disciplinaria','Baja por sanción disciplinaria');
INSERT INTO MotivosBajas (motivo,descripcion) VALUES ('Baja por Fallecimiento','Fallecimiento');
INSERT INTO MotivosBajas (motivo,descripcion) VALUES ('Baja Deshonrosa','Baja por motivos de incumplimento a directivas');

-- insertando datos en Tabla Grados --
INSERT INTO Grados (grado)VALUES ('Comandante General');
INSERT INTO Grados (grado) VALUES ('Comandante Mayor');
INSERT INTO Grados (grado) VALUES ('Comandante');
INSERT INTO Grados (grado) VALUES ('Sub-Comandate');
INSERT INTO Grados (grado) VALUES ('Oficial Principal');
INSERT INTO Grados (grado) VALUES ('Oficial Inspector');
INSERT INTO Grados (grado) VALUES ('Oficial Ayudante');
INSERT INTO Grados (grado) VALUES ('Sub Oficial Mayor');
INSERT INTO Grados (grado) VALUES ('Sub Oficial principal');
INSERT INTO Grados (grado) VALUES ('Sargento Primero');
INSERT INTO Grados (grado) VALUES ('Sargento');
INSERT INTO Grados (grado) VALUES ('Cabo Primero');
INSERT INTO Grados (grado) VALUES ('Cabo');
INSERT INTO Grados (grado) VALUES ('Bombero');#14


#-- insertando datos en tabla Personas (que seran bomberos) --
-- insertando datos en tabla Bomberos (unificadas Personas y Bomberos) --
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('28419615', 'Marcelo', 'david', 'Llanes', NULL, 3516636816, 'Chazarreta 401', '1980/12/22',40,'M','AB+','1999/03/15',NULL,NULL,1);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('28419620', 'Eduardo', 'Ruben', 'Llanes', NULL, '3571502089', 'Rio Magdalena 545','1981/02/12',40,'M','AB+','1999/03/15',NULL,NULL,1);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('27151345', 'Marcos', 'David', 'Aguilera', '4605021', '3571502081', 'Rio quillinzo y rio gallegos', '1980/3/21',40,'M', 'A+','1999/03/15',NULL,NULL,3);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('29666541', 'Veronica', 'Paola', 'Chocobares', '4602015', '3515502081', 'Acuña 157', '1987/12/06',37,'F', 'AB-','1999/03/15',NULL,NULL,14);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('30405647', 'Agustin', 'Javier', 'Pedruli', '4608999', '3571508963', 'Almafuerte 156', '1987/01/16',26,'X','0+' ,'1999/03/15',NULL,NULL,14);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('29458814', 'Agustina', 'Valentina', 'Cherry', NULL, '3571508445', 'Independencia 15', '1989/11/05',29,'F', 'B-','1999/03/15',NULL,NULL,14);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('28712211', 'Mariela', 'Antonella', 'Villafañe', NULL, '3571506021', 'Arenales 257', '1986/12/22',36,'F', 'AB-','1999/03/15',NULL,NULL,14);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('37654832', 'Carlos', 'Martin', 'Airabedean', '4608451', '3571502010', 'De la Torre 25', '1988/12/22',32,'M', 'A+','1999/03/15',NULL,NULL,14);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('31541215', 'Gustavo', 'Efrain', 'Rosso', '4601587', '3571608524', 'San Pedro 456', '1970/12/22',50,'M', 'AB-','1999/03/15',NULL,NULL,14);
INSERT INTO Bomberos (DNI,nombre1, nombre2, apellido, telefonoCasa, telefonoCelular, direccion, fechaNacimiento, edad, genero, factorSanguineo, fechaAlta, fechaBaja, idMotivoBaja, idGrado) VALUES ('32645578', 'Diego', 'Agustin', 'Palomeque', '4607045', '3571506323', 'España 415', '1980/05/13',40,'M', 'B+','1999/03/15',NULL,NULL,14);




-- insertando datos en Tabla Privilegios
INSERT INTO Privilegios (tipoPrivilegio, descripcion) VALUES ('Administrador de Sistema','Gestion de sistema');
INSERT INTO Privilegios (tipoPrivilegio, descripcion) VALUES ('Administrador de Personal','Gestion de personal');
INSERT INTO Privilegios (tipoPrivilegio, descripcion) VALUES ('Administrador de Vehiculos','Gestion de Vehiculos');
INSERT INTO Privilegios (tipoPrivilegio, descripcion) VALUES ('Administrador de reportes','Gestion de reportes');
INSERT INTO Privilegios (tipoPrivilegio, descripcion) VALUES ('Despachador','Usuario que genera despacho de intervenciones');

-- insertando datos en tabla Estados --
INSERT INTO Estados (estado, descripcion) VALUES ('Finalizado con intervención','Intervencion finalizada');
INSERT INTO Estados (estado, descripcion) VALUES ('Finalizado sin intervención','Intervencion finalizada sin intervencion');
INSERT INTO Estados (estado, descripcion) VALUES ('Falsa Alarma','Falsa Alarma');

-- isertando datos en tabla BarriosZonas --
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Panamericano',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Sarmiento',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Cabero',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Aeronautico',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Norte',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Villa Zoila',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Medialuna',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Parque Industrial',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Hospital Regional',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Clinica Modelo',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Clinica Savio',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Belgrano',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Castagnino',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Monte Grande',1);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Almafuerte',0);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Tancacha',0);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Villa Ascasubi',0);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Los Tres Pozos',0);
INSERT INTO BarriosZonas (barrioZona, jurisdiccion) VALUES ('Petroquimica RIII',1);#19

-- insertando datos en tabla Tipos --
# configuran los tipos principales de eventos
INSERT INTO Tipos (tipo, descripcion) VALUES ('Incendio','incendio');
INSERT INTO Tipos (tipo, descripcion) VALUES ('Rescate','rescate de personas o animales');
INSERT INTO Tipos (tipo, descripcion) VALUES ('Busqueda','Busqueda de personas o animales');
INSERT INTO Tipos (tipo, descripcion) VALUES ('Servicio','Servicios que brinda el cuartel');#4
INSERT INTO Tipos (tipo, descripcion) VALUES ('Terremoto','Desastre Natural');
INSERT INTO Tipos (tipo, descripcion) VALUES ('Inundación','Desastre Natural');
-- insertando datos en tabla SubTipos --
#configuran los subtipos de los tipos principales de eventos
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Estructural Casa','incendio de casa');#1
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Estructural Casa multiple','evento que implica dos o mas domicilios');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Estructural Oficina','incendio en oficinas');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Estructural Comercio','incendio en comercio');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Estructural Industrial','incendio en industrias');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Estructural Deposito','incendio en deposito');#6
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Estructural Basural','incendio de casa');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Forestal','incendio en bosques o reservas naturales');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Pastizales','incendio de arbustos , malezas');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Vehicular simple','evento que implica un vehiculo');#10
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Vehicular multiple','evento que implica dos o mas vehiculos');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('En Altura simple','rescate de una persona en altura');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('En Altura Multiple','rescate de dos o mas personas en altura');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Aeronautico','incendio de aeronaves en tierra');#14
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Aeronautico','incendio de aeronaves en vuelo');#15
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Persona extraviada','persona con busqueda de paradero');#16
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Persona atrapada','Persona atrapada');#17
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Animal','rescate de animal');#18
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Óbito','QRJ');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Ambulancia','servicio');#20
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Extracción Panal avispas','Servicio');#21
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Extraccion Panal Abejas','servicio');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('transporte de agua ','servicio');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Otros servicios','servicio no categorizado');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Representación','Servicio Institucional');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Capacitación','servicio de o para capacitación');
INSERT INTO SubTipos (subTipo, descripcion) VALUES ('Prevención','Prevención');#27

-- insertando datos en tabla TiposIntervenciones --
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,1,'IN-EST-CA','incendio estructural de vivienda');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,2,'INC-EST-CAM','incendio estructural de multiples viviendas');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,3,'INC-EST-OF','incendio estructural de oficinas');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,4,'INC-EST-COM','incendio estructural de comercio');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,5,'INC-EST-IND','incendio estructural en industria');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,6,'INC-EST-DEP','incendio estructural en deposito');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,7,'INC-ES-BAS','incendio en basural');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,8,'INC-FOR','icendio forestal');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,9,'INC-PAS','incendio de pastizales');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,10,'INC-VEH-SIM','incendio vehicular');#10
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,11,'INC-VEH-MUL','incendio vehicular multiple');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (1,14,'INC-AER-TIE','incendio de aeronaves en tierra');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (2,12,'RES-ALT-SIM','rescate en altura simple');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (2,13,'RES-ALT-MUL','rescate en altura multiple');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (2,17,'RES-PER-ATR','rescate,de persona atrapada');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (2,18,'RES-ANI','rescate de animal');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (3,19,'BUS-PER-OBT','busqueda de persona muerta');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (3,16,'BUS-PER-EXT','busqueda de persona extraviada');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (4,20,'SER-AMB','servicio de ambulancia');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (4,21,'SER-EXT-AVI','servicio de extraccion de avispas');#20
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (4,22,'SER-EXT-ABJ','servicio de extraccion de abejas');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (4,23,'SER-TRA-AGU','servicio de traslado de agua');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (4,24,'SER-OTR-SER','servicios otros servicios');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (3,25,'SER-REP-INS','servicios representacion institucional');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (3,26,'SER-CAP','servicios de capacitación');
INSERT INTO TiposIntervenciones (idTipo,idSubTipo,codigo,descripcion) VALUES (3,27,'SER-PREV','servicios de prevención');

-- insertando datos en tabla TipoAvisos --
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('100','numero de emergencia');
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('421234','Linea rotativa');
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('412234','Linea rotativa');
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('1563685','Linea celular');
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('Radial RA ','Radial Radio Aficionado');
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('Radial SE', 'Radial Servicios de emergencia');
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('Presencial','Presencial en cuartel');
INSERT INTO TipoAvisos (avisoTipo,descripcion) VALUES ('Autoconvocado','Autoconvocado');#8

-- insertando datos en tabla Intervenciones --
INSERT INTO Intervenciones (ticket, fecha, horaInicio, horaFin, nombreAlertante, apellidoAlertante, contactoAlertante, direccion1, direccion2,  informeIntervencion, idTipoAviso, idEstado, idBarrioZona, jefeBrigada, idTipoIntervencion) VALUES (2010211,'2021/10/20','10:24:58','13:07:25','Carlos','Villagran',3571502080,'Rio Amazonas 154',NULL,'Se llega al domiclio y se estraen 5 panales de avispas africanas de 7 cm cada una, un delirio, no hubo heridos, se finaliza sin novedad', 2,1,1,1,20);
INSERT INTO Intervenciones (ticket, fecha, horaInicio, horaFin, nombreAlertante, apellidoAlertante, contactoAlertante, direccion1, direccion2,  informeIntervencion, idTipoAviso, idEstado, idBarrioZona, jefeBrigada, idTipoIntervencion) VALUES (2010212,'2021/10/20','15:58:20','16:15:41','Alberto','Sanata',3571504151,'Mitre','Alsina','Se llega al QTH  y se encuentra una renoleta en llamas, se ataca con manguera de 1 y 3/4, se controla el incendio',1,1,4,7,2);
INSERT INTO Intervenciones (ticket, fecha, horaInicio, horaFin, nombreAlertante, apellidoAlertante, contactoAlertante, direccion1, direccion2,  informeIntervencion, idTipoAviso, idEstado, idBarrioZona, jefeBrigada, idTipoIntervencion) VALUES (2210211,'2021/10/22','06:15:20','07:30:15','Cacho','Fontana',3571668214,'Rio Bamba 542',NULL,'Se llega al QTH, a retirar QRJ, QRQ a pedido de la justicia, es espera policia forense',2,2,4,7,2);
INSERT INTO Intervenciones (ticket, fecha, horaInicio, horaFin, nombreAlertante, apellidoAlertante, contactoAlertante, direccion1, direccion2,  informeIntervencion, idTipoAviso, idEstado, idBarrioZona, jefeBrigada, idTipoIntervencion) VALUES (2210212,'2021/10/22','10:11:20','11:40:15','Mario','Bross',4506088,'Dean Funes 315',NULL,'se rescata a una damajuana de vino que estaba extraviada',2,3,10,9,1);
INSERT INTO Intervenciones (ticket, fecha, horaInicio, horaFin, nombreAlertante, apellidoAlertante, contactoAlertante, direccion1, direccion2,  informeIntervencion, idTipoAviso, idEstado, idBarrioZona, jefeBrigada, idTipoIntervencion) VALUES (2210213,'2021/10/22','14:20:20','16:17:52','Eleanor','Rigby',3571502056,'Ruta a tancacha',NULL,'Se trabaja con dotaciones de tancacha, incendio de pastizales sobre ruta',1,1,1,9,4);
INSERT INTO Intervenciones (ticket, fecha, horaInicio, horaFin, nombreAlertante, apellidoAlertante, contactoAlertante, direccion1, direccion2,  informeIntervencion, idTipoAviso, idEstado, idBarrioZona, jefeBrigada, idTipoIntervencion) VALUES (2210214,'2021/10/22','16:40:08','16:59:52','Bruce','Wayne',4502335,'Marconi','San Miguel','Llenado de pileta ',1,1,8,10,2);
INSERT INTO Intervenciones (ticket, fecha, horaInicio, horaFin, nombreAlertante, apellidoAlertante, contactoAlertante, direccion1, direccion2,  informeIntervencion, idTipoAviso, idEstado, idBarrioZona, jefeBrigada, idTipoIntervencion) VALUES (2310211,'2021/10/23','22:05:12','22:32:15','Beatriz','Sarlo',4503235,'interfabrica',NULL,'Prevencion por traslado de cuba de acido',1,2,8,2,2);

-- insertando datos en la tabla Cuarteles --
#hay que pensar en destacamentos(¿cuantos cuarteles tienen destacamentos?)
INSERT INTO Cuarteles (idCuartel, regionalNumero, CuartelNumero, Direccion, JefeCuartel, logo) VALUES(1,12,5,'Sarmiento 675',1,NULL);

-- insertando datos en tabla TiposBombas --
INSERT INTO TiposBombas (bombaTipo) VALUES ('Centrifuga');
INSERT INTO TiposBombas (BombaTipo) VALUES ('Aspirada');

-- insertando datos en la tabla EstadoMoviles --
INSERT INTO EstadoMoviles (estado) VALUES ('En Servicio');
INSERT INTO EstadoMoviles (estado) VALUES ('Fuera de Servicio');
INSERT INTO EstadoMoviles (estado) VALUES ('En Reparacion');
INSERT INTO EstadoMoviles (estado) VALUES ('En funcionamiento con desperfectos');

-- insertando datos en la tabla TiposMoviles --
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Ataque Liviano','Vehiculo de hasta 4K litros');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Ataque Pesado', 'Vehiculo de mas de 4K litros');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Transporte de personal','Vehiculo para transporte');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Tanque','Vehiculo De suministro de agua ');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Escalera','Vehiculo Escalera hasta 35 mts');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Forestal liviano','Vehiculo Forestal hasta 5K kilos');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Forestal Pesado','Vehiculo forestal de mas de 5K kilos');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Generador','Vehiculo para Generacion de EE');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Acuatico','Vehiculo para uso en rios y lagos');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Ambulancia','Vehiculo para AMP');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Transporte de personal','Vehiculo para transporte');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Unidad de Rescate ','Vehiculo para Extricacion Vehicular');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Mando','Vehiculo para Mando y coordinacion');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('NRBQ','Vehiculo Hazmat');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('Transporte de personal','Vehiculo para transporte');
INSERT INTO TiposMoviles (tipo,descripcion) VALUES ('N/A','sin descripcion');#16

-- insertando datos en tabla Moviles --
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(1,'Ford','3000',9,1,1,1);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(6,'Mac','Emerson',13,2,1,2);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(8,'Ford','4000',3,1,4,4);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(15,'Iveco','Daily',5,NULL,1,10);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(16,'Mac','Expedition',6,1,1,1);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(22,'Simon','Duplex',7,2,1,14);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(19,'Renaul','JN90',6,2,1,6);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(20,'PowerHorse','Gennex',0,NULL,1,8);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(10,'Mercedez benz','1626',6,1,2,13);
INSERT INTO Moviles (numeroMovil,Marca,Modelo,plaza,idTipoBomba,idEstadoMovil,idTipoMovil) VALUES(11,'Spartan','SaulsBury',10,2,1,14);

-- insertando datos en tabla OtrosServicios --
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('DC','Defensa Civil');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('CRA','Cruz Roja Argentina');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('Policia Municipal','Inspectores de transito');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('URTA','Policia de Rio III');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('GA','Guardia Urbana');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('Bomberos PRIII','Bomberos Petroquimica');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('Bomberos Atanor','Bomberos Atano');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('Bomberos FMRT','Bomberos Fabrica Militar Rio III');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('Lomar','Servicios de Emergencia Lomar');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('Ambulancia Municipal','Ambulancias del municipio');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('Policia Federal','Policia Federal');
INSERT INTO OtrosServicios (servicio,descripcion) VALUES ('S/S','Sin servicios adicionales');#12

--  insertando datos en OtrosServiciosEnIntervenciones --
INSERT INTO OtrosServiciosEnIntervenciones (ticket,idOtroServicio) VALUES (2010212,12);
INSERT INTO OtrosServiciosEnIntervenciones (ticket,idOtroServicio) VALUES (2010211,2);
INSERT INTO OtrosServiciosEnIntervenciones (ticket,idOtroServicio) VALUES (2010211,1);
INSERT INTO OtrosServiciosEnIntervenciones (ticket,idOtroServicio) VALUES (2010212,11);
INSERT INTO OtrosServiciosEnIntervenciones (ticket,idOtroServicio) VALUES (2210213,3);
INSERT INTO OtrosServiciosEnIntervenciones (ticket,idOtroServicio) VALUES (2210213,1);
INSERT INTO OtrosServiciosEnIntervenciones (ticket,idOtroServicio) VALUES (2210214,12);

-- insertando datos en tabla PrivilegiosBomberos --
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (1,4,'2000/10/01','2000/10/15');
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (1,1,'2000/10/15',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (2,5,'1999/03/15',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (3,5,'199/03/16',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (4,5,'1995/10/23',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (4,3,'1996/02/18',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (5,5,'2010/10/25',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (6,5,'2019/03/08',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (7,5,'2021/12/10',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (8,5,'2000/11/30',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (9,5,'2017/08/10','2021/10/28');
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (10,5,'2000/01/10',NULL);
INSERT INTO PrivilegiosBomberos (idBombero,idPrivilegio,fechaAlta,fechaBaja) VALUES (9,2,'2021/10/28',NULL);

-- insertando datos en tabla DespliegueMoviles --
#moviles asignados a una intervencion
INSERT INTO DespliegueMoviles (ticket,idMovil,horaSalida,horaLlegada) VALUES (2010211,1,'10:26:14','10:28:41');#1
INSERT INTO DespliegueMoviles (ticket,idMovil,horaSalida,horaLlegada) VALUES (2010212,2,'15:59:14','16:10:40');#2
INSERT INTO DespliegueMoviles (ticket,idMovil,horaSalida,horaLlegada) VALUES (2210211,10,'06:21:05','06:29:35');#3
INSERT INTO DespliegueMoviles (ticket,idMovil,horaSalida,horaLlegada) VALUES (2210212,1,'10:14:14','10:18:41');#4
INSERT INTO DespliegueMoviles (ticket,idMovil,horaSalida,horaLlegada) VALUES (2210213,7,'14:30:05','14:35:54');#5
INSERT INTO DespliegueMoviles (ticket,idMovil,horaSalida,horaLlegada) VALUES (2210214,1,'15:00:00','15:18:23');#6
INSERT INTO DespliegueMoviles (ticket,idMovil,horaSalida,horaLlegada) VALUES (2310211,4,'22:09:15','22:18:09');#7

-- insertando datos en la tabla DespliegueBomberos --
#Intervencion 1
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,1,1);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,2,1);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,7,1);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,9,1);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,10,1);
-- llegaron pero quedaron en cuartel --
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,5,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,6,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010211,8,NULL);

#intervencion 2
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,4,2);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,3,2);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,6,2);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,8,2);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,9,2);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,10,2);
-- llegaron pero quedaron en el cuartel --
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,1,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2010212,5,NULL);
#intervencion 3
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210211,4,3);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210211,10,3);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210211,8,3);
-- llegaron pero qudaron en el cuartel --
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210211,6,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210211,1,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210211,7,NULL);
#intervencion 4
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210212,1,4);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210212,2,4);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210212,5,4);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210212,9,4);
-- llegaron pero quedaron en el cuartel --
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210212,8,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210212,7,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210212,4,NULL);
#intervencion 5
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210213,6,5);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210213,7,5);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210213,9,5);
-- llegaron pero quedaron en el cuartel --
#intervencion 6
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210214,8,6);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210214,7,6);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210214,6,6);
-- llegaron pero quedaron en el cuartel --
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210214,4,NULL);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2210214,5,NULL);
#intervencion 7
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2310211,10,7);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2310211,8,7);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2310211,9,7);
-- llegaron pero se quedaron en el cuartel --
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2310211,6,7);
INSERT  INTO DespliegueBomberos (ticket,idBombero,idDespliegueMovil) VALUES (2310211,2,7);

-- insertando datos en la tabla Registros --
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (1,'2021-10-20 05:45:58',NULL,0);
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (5,'2021-10-20 10:23:58','2021-10-20 13:09:41',1);
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (7,'2021-10-20 15:58:00','2021-10-20 16:19:25',1);
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (6,'2021-10-22 06:14:11','2021-10-22 07:35:09',1);
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (8,'2021-10-22 10:09:12','2021-10-22 11:49:16',1);
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (5,'2021-10-22 14:18:00','2021-10-22 16:21:40',1);
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (5,'2021-10-22 16:38:50','2021-10-22 17:06:33',1);
INSERT INTO Registros (idBombero,login,logout,ingreso) VALUES (2,'2021-10-23 22:03:00','2021-10-23 22:36:39',1);

-- insertando ningun datos en la tabla usuariocontraseña --
INSERT	INTO SIREB.UsuarioContraseña (usuario,contraseña) VALUES ("admin","admin");
INSERT INTO SIREB.UsuarioContraseña (usuario, contraseña,idBombero) VALUES ("bomberito1","bomberito1",1);  
INSERT INTO SIREB.UsuarioContraseña (usuario, contraseña,idBombero) VALUES ("bomberito2","bomberito2",2); 



