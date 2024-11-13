INSERT INTO person (nm_person, tp_person, nm_email, nr_telephone)
VALUES
    ('João da Silva', 'F', 'joao@email.com', '(11) 98765-4321'),
    ('Maria Souza', 'F', 'maria@email.com', '(21) 12345-6789'),
    ('Pedro Gomes', 'M', 'pedro@email.com', '(12) 34567-8901'),
    -- ... (adicione mais linhas conforme necessário)
    ('Ana Oliveira', 'F', 'ana@email.com', '(19) 98765-4321');

-- Inserindo dados na tabela document
INSERT INTO document (person_id, nr_document, tp_document)
VALUES
    (1, '12345678901', 'CPF'),
    (1, 'ABCDEFGHIJ', 'RG'),
    (2, '98765432109', 'CPF'),
    -- ... (adicione mais linhas, relacionando com os IDs da tabela person)
    (4, '98765432110', 'CPF');

-- Inserindo dados na tabela address
INSERT INTO address (person_id, nm_address, nr_address, nm_city, nm_state, nm_country)
VALUES
    (1, 'Rua das Flores, 123', '123', 'São Paulo', 'SP', 'Brasil'),
    (2, 'Avenida Brasil, 456', '456', 'Rio de Janeiro', 'RJ', 'Brasil'),
    -- ... (adicione mais linhas, relacionando com os IDs da tabela person)
    (4, 'Rua Central, 789', '789', 'Belo Horizonte', 'MG', 'Brasil');

-- Inserindo dados na tabela contact
INSERT INTO contact (person_id, nm_contact, nr_telephone, nm_email)
VALUES
    (1, 'Celular', '(11) 98765-4322', 'celular@email.com'),
    (2, 'Trabalho', '(21) 12345-6780', 'trabalho@email.com'),
    -- ... (adicione mais linhas, relacionando com os IDs da tabela person)
    (4, 'Pessoal', '(19) 98765-4320', 'pessoal@email.com');