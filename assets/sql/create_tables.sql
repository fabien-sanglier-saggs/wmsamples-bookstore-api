-- Creation of books table
CREATE TABLE IF NOT EXISTS book (
  book_id serial NOT NULL,
  title	VARCHAR(100) NOT NULL,
  publish_date	DATE,
  author VARCHAR(50) NOT NULL,
  type VARCHAR(50) NOT NULL,
  price decimal,
  num_of_pages smallint,
  publisher VARCHAR(50) NOT NULL,
  language VARCHAR(50) NOT NULL,
  isbn VARCHAR(25) NOT NULL,
  PRIMARY KEY (book_id)
);