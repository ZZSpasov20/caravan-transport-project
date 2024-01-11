CREATE TABLE Clients(
	ClientId INT PRIMARY KEY IDENTITY(1,1),
	FirstName NVARCHAR(50) NOT NULL,
	LastdName NVARCHAR(50) NOT NULL,
	EmailAddress NVARCHAR(65) NOT NULL,
	Password NVARCHAR(65) NOT NULL
);


CREATE TABLE Caravans(
	CaravanId INT PRIMARY KEY IDENTITY(1,1),
	RentalPrice DECIMAL(5,2) NOT NULL,
	IsAvaliable INT NOT NULL CHECK (IsAvaliable = 1 OR IsAvaliable = 0),
	Manufacturer NVARCHAR(65) NOT NULL,
	ModelName NVARCHAR(65) NOT NULL
);

CREATE TABLE Reviews(
	ReviewId INT PRIMARY KEY IDENTITY(1,1),
	Rating INT NOT NULL,
	Comment NVARCHAR(1500)
);

CREATE TABLE Rentals(
	RentalId INT PRIMARY KEY IDENTITY(1,1),
	StartDate DATE  NOT NULL,
	EndDate DATE  NOT NULL,
	ClientId INT  NOT NULL,
	CaravanId INT  NOT NULL,
	ReviewId INT  DEFAULT 1
);
ALTER TABLE Rentals
ADD FOREIGN KEY (ClientId) REFERENCES Clients(ClientId);
ALTER TABLE Rentals
ADD FOREIGN KEY (CaravanId) REFERENCES Caravans(CaravanId);
ALTER TABLE Rentals
ADD FOREIGN KEY (ReviewId) REFERENCES Reviews(ReviewId);


INSERT INTO Clients (FirstName, LastdName, EmailAddress, Password) VALUES ('Davie', 'Makiver', 'dmakiver0@geocities.jp', 'xO5?T#yi,a+O(Y`');
INSERT INTO Clients (FirstName, LastdName, EmailAddress, Password) VALUES ('Maurita', 'Gwyther', 'mgwyther1@cmu.edu', 'fF7Jxp8t/I0S(X');
INSERT INTO Clients (FirstName, LastdName, EmailAddress, Password) VALUES ('Lay', 'Wride', 'lwride2@spiegel.de', 'hK5u8c{&oV#H>rN');
INSERT INTO Clients (FirstName, LastdName, EmailAddress, Password) VALUES ('Janel', 'Hubbard', 'jhubbard3@businessinsider.com', 'dQ6,>V#n5V!');
INSERT INTO Clients (FirstName, LastdName, EmailAddress, Password) VALUES ('Chev', 'Autie', 'cautie4@ifeng.com', 'tH3!VerwB~~<');

INSERT INTO Caravans (RentalPrice, IsAvaliable, Manufacturer, ModelName) VALUES (94.57, 0, 'Freedom Caravans', 'Freedom Explorer');
INSERT INTO Caravans (RentalPrice, IsAvaliable, Manufacturer, ModelName) VALUES (143.23, 1, 'Bailey', 'Pegasus Grande');
INSERT INTO Caravans (RentalPrice, IsAvaliable, Manufacturer, ModelName) VALUES (184.17, 1, 'Coachman', 'Elegance');
INSERT INTO Caravans (RentalPrice, IsAvaliable, Manufacturer, ModelName) VALUES (116.72, 0, 'Adria', 'Adria Altea');
INSERT INTO Caravans (RentalPrice, IsAvaliable, Manufacturer, ModelName) VALUES (55.20, 0, 'Airstream', 'Basecamp');

INSERT INTO Reviews (Rating, Comment) VALUES ( 0, 'No review');
INSERT INTO Reviews (Rating, Comment) VALUES ( 6, 'It is a bit dirty');
INSERT INTO Reviews (Rating, Comment) VALUES ( 8, 'Love it. The caravan is really good. I would definitely rent it again');
INSERT INTO Reviews (Rating, Comment) VALUES ( 7, 'The trip was amazing. The caravan was not bad at all, but it is hard to change its tires!');


INSERT INTO Rentals (StartDate, EndDate, ClientId, CaravanId, ReviewId) VALUES ( '2023-9-4', '2023-9-10', 1, 5, 2);
INSERT INTO Rentals (StartDate, EndDate, ClientId, CaravanId, ReviewId) VALUES ( '2023-9-4', '2023-9-10', 2, 3, 3);
INSERT INTO Rentals (StartDate, EndDate, ClientId, CaravanId) VALUES ( '2023-9-4', '2023-9-10', 3, 4);
INSERT INTO Rentals (StartDate, EndDate, ClientId, CaravanId, ReviewId) VALUES ( '2023-9-4', '2023-9-10', 2, 3, 4);
INSERT INTO Rentals (StartDate, EndDate, ClientId, CaravanId) VALUES ( '2024-1-15', '2024-1-18', 4, 2 );
INSERT INTO Rentals (StartDate, EndDate, ClientId, CaravanId) VALUES ( '2024-1-15', '2024-1-19', 5, 3 );

