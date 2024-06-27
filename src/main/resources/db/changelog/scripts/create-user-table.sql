CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    national_id VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(255) NOT NULL UNIQUE,
    image_url VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    INDEX idx_national_id (national_id),
    INDEX idx_username (username)
);
