CREATE TABLE PUBLIC.talk (
  id INTEGER NOT NULL, 
  talk_id INTEGER NOT NULL,
  date_id INTEGER NOT NULL,
  title VARCHAR(255),
  foreign_language_title VARCHAR(255),
  source_material VARCHAR(128),
  PRIMARY KEY(id) );
  
