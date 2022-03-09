CREATE TABLE premiere (
  id BIGINT NOT NULL,
   title VARCHAR(255),
   description VARCHAR(255),
   agecategory VARCHAR(255),
   capacity INTEGER,
   version INTEGER,
   CONSTRAINT pk_premiere PRIMARY KEY (id)
);
CREATE TABLE ticket (
  id BIGINT NOT NULL,
   premiere_id BIGINT,
   place INTEGER,
   row INTEGER,
   version INTEGER,
   CONSTRAINT pk_ticket PRIMARY KEY (id)
);

ALTER TABLE ticket ADD CONSTRAINT FK_TICKET_ON_PREMIERE FOREIGN KEY (premiere_id) REFERENCES premiere (id);
CREATE SEQUENCE  IF NOT EXISTS "public.seq_premiere" START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS "public.seq_ticket" START WITH 1 INCREMENT BY 1;