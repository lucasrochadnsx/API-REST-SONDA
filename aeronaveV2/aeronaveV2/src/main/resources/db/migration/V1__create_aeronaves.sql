CREATE TABLE aeronaves (
                           id BIGSERIAL PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           fabricante VARCHAR(50) NOT NULL,
                           ano_fabricacao INT NOT NULL,
                           descricao TEXT,
                           vendido BOOLEAN NOT NULL DEFAULT FALSE,
                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);