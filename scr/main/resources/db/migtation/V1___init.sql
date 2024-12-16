CREATE TABLE articles (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    comments_count INT DEFAULT 0,
    trending BOOLEAN DEFAULT FALSE
);
