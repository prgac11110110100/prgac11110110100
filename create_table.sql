-- https://www.postgresql.org/docs/9.6/ddl-schemas.html

--  acces mechanism on postgresql 9.6
--  database.schema.table or other objects
--

-- criacao de sequence
CREATE SCHEMA testejava; 


-- drop sequence testejava_rastrear;
CREATE SEQUENCE testejava_rastrear start 2 increment 2;


--drop table testejava.rastrear; 
CREATE TABLE testejava.rastrear (
  id                SERIAL PRIMARY KEY,
  id_encomenda      VARCHAR(20),
  descr_encomenda   VARCHAR(100),
  nota_fiscal       VARCHAR(15) ,
  situacao_rastreio varchar(30) , 
  dt_rastreio       varchar(20)  
);      
