
CREATE DATABASE "Compte"
    WITH
    OWNER = "Berete"
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS public.client
(
    idclient text NOT NULL,
    nom text ,
    prenom text ,
    date_naisssance date,
    CONSTRAINT client_pkey PRIMARY KEY (idclient)
);



CREATE TABLE IF NOT EXISTS public.adresseclient
(
    idAdresse serial PRIMARY key,
    email text ,
    telephone integer,
    adresse text ,
    ville text ,
    code_postal text , clientid text,
    CONSTRAINT adresseclient_idclient_fkey FOREIGN KEY (clientid)
        REFERENCES public.client (idclient) MATCH SIMPLE
       
);
CREATE TABLE IF NOT EXISTS public.compteclient
(
    numerocompte text  NOT NULL,
    cle_securite text ,
    type text ,
    date_ouverture date,
    idclient text ,
    CONSTRAINT compteclient_pkey PRIMARY KEY (numerocompte),
    CONSTRAINT compteclient_idclient_fkey FOREIGN KEY (idclient)
        REFERENCES public.client (idclient) MATCH SIMPLE
        
);
CREATE TABLE IF NOT EXISTS public.operation
(
    idOpeartion serial PRIMARY key ,
    montant double precision,
    type text ,
    date_retrait date,
    numerocompte text,
    CONSTRAINT operation_numerocompte_fkey FOREIGN KEY (numerocompte)
        REFERENCES public.compteclient (numerocompte) MATCH SIMPLE
      
);



SELECT numerocompte,cle_securite,"type",date_ouverture,idclient,solde FROM compteclient;
