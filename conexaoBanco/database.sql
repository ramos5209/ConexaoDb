CREATE DATABASE cursojdbc;




CREATE TABLE departamento (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE vendedor (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(100) NOT NULL,
    dataNascimento DATETIME NOT NULL,
    salarioBase DOUBLE NOT NULL,
    idDepartamento INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idDepartamento) REFERENCES departamento (id)
);

INSERT INTO departamento (nome) VALUES 
    ('Computadores'),
    ('Eletrônicos'),
    ('Moda'),
    ('Livros');

INSERT INTO vendedor (nome, email, dataNascimento, salarioBase, idDepartamento) VALUES 
  ('João Silva', 'joao@gmail.com', '1995-07-15 00:00:00', 25000, 1),
  ('Maria Souza', 'maria@gmail.com', '1983-09-22 00:00:00', 22000, 2),
  ('Pedro Santos', 'pedro@gmail.com', '1990-03-10 00:00:00', 19000, 3),
  ('Ana Oliveira', 'ana@gmail.com', '1985-06-05 00:00:00', 16000, 4),
  ('Lucas Almeida', 'lucas@gmail.com', '1992-11-18 00:00:00', 13000, 1),
  ('Fernanda Costa', 'fernanda@gmail.com', '1980-02-27 00:00:00', 10000, 2),
  ('Rafael Lima', 'rafael@gmail.com', '1994-08-08 00:00:00', 8500, 3),
  ('Juliana Pereira', 'juliana@gmail.com', '1987-12-13 00:00:00', 7500, 4),
  ('Carla Mendes', 'carla@gmail.com', '1993-05-25 00:00:00', 6000, 1),
  ('Gustavo Rocha', 'gustavo@gmail.com', '1998-10-01 00:00:00', 5500, 2);