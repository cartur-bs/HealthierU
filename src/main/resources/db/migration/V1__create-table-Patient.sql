CREATE TABLE Patient (
id UUID PRIMARY KEY UNIQUE NOT NULL,
patientName TEXT NOT NULL,
age INT NOT NULL,
genre TEXT NOT NULL,
address TEXT NOT NULL,
phoneNumber TEXT NOT NULL
);