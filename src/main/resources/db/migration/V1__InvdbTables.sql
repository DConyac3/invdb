CREATE TABLE device(
             serialNumber VARCHAR(50) NOT NULL PRIMARY KEY,
             os VARCHAR(100),
             model VARCHAR(100) NOT NULL,
             dop DATE
);

CREATE TABLE employee(
             id UUID NOT NULL PRIMARY KEY,
             firstName VARCHAR(50) NOT NULL,
             lastName VARCHAR(50) NOT NULL,
             title VARCHAR(100),
             device_sn VARCHAR(50) REFERENCES device(serialNumber)
);