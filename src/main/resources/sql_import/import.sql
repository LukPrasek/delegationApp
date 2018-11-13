INSERT INTO `employees` (emp_Id, name, surname, birthday, start_working_date, employee_position)
VALUES (1,'Luk','Pras','1987-12-31','1987-12-31','DIRECTOR'),(2,'Pawel','Kowalski','1975-02-01','2018-02-01','WORKER'),(3,'Michal','Nowak','1975-02-01','2018-03-01','WORKER'),(6,'Kamil','Keska','1975-02-01','2018-03-05','WORKER'),(14,'Zenon','Malinowski','1975-02-01','2018-03-05','WORKER'),(15,'Roman','Bieniek','1975-02-01','2018-02-01','WORKER'),(16,'Romek','Grad','1975-02-01','2018-03-05','SUPERVISOR'),(17,'Marcin','Kopycki','1975-02-01','2017-05-01','WORKER');
INSERT INTO `cars` (car_Id, brand, model, seats_number, emp_id)
VALUES (1,'Mercedes','Vito',3,16),(2,'Hyundai','i40',5,3),(25,'Toyota','Avensis',5,1),(34,'VW','Passat',5,2);
INSERT INTO `passengers` (passenger_id, car_id, emp_id)
VALUES (1,1,14),(2,2,15),(3,25,17);
INSERT INTO `site` (id, address, name)
VALUES (1,'Ul. Warszawska 3, 05-735 Wroclaw', 'Amazon'),(2	,'BahnStrasse 3, 35789 Bissingen','VW Zwickau'),(3, 'Ul. Sienkiewicza 3, 35-456 Wrocław', 'BauHaus');





