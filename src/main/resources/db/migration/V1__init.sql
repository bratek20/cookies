CREATE TABLE cookies
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    identity_id VARCHAR(64) NOT NULL,
    flavor     VARCHAR(64) NOT NULL,
    amount     INT NOT NULL
);