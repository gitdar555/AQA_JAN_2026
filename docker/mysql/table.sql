CREATE TABLE Persons (
    PersonID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Gender VARCHAR(80) NOT NULL,
    Title VARCHAR(255) NOT NULL,
    Nat VARCHAR(255) NOT NULL
);

INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES ('TestFirstName', 'TestLastName', 'TestGender', 'TestTitle', 'TestNat');

select * from Persons;

select * from Persons where FirstName LIKE 'Abigail';

select FirstName, LastName from Persons WHERE Title = 'Mr';

update Persons SET FirstName = 'Abigail' WHERE FirstName = 'Test';