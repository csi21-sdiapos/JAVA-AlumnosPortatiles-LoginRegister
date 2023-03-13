--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: alumnos_portatiles; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA alumnos_portatiles;


ALTER SCHEMA alumnos_portatiles OWNER TO postgres;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: alumno; Type: TABLE; Schema: alumnos_portatiles; Owner: postgres
--

CREATE TABLE alumnos_portatiles.alumno (
    alumno_id bigint NOT NULL,
    alumno_apellidos character varying(255) NOT NULL,
    alumno_date timestamp without time zone NOT NULL,
    alumno_nombre character varying(255) NOT NULL,
    alumno_telefono character varying(255) NOT NULL,
    alumno_uuid uuid NOT NULL,
    portatil_id bigint
);


ALTER TABLE alumnos_portatiles.alumno OWNER TO postgres;

--
-- Name: alumno_alumno_id_seq; Type: SEQUENCE; Schema: alumnos_portatiles; Owner: postgres
--

CREATE SEQUENCE alumnos_portatiles.alumno_alumno_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE alumnos_portatiles.alumno_alumno_id_seq OWNER TO postgres;

--
-- Name: alumno_alumno_id_seq; Type: SEQUENCE OWNED BY; Schema: alumnos_portatiles; Owner: postgres
--

ALTER SEQUENCE alumnos_portatiles.alumno_alumno_id_seq OWNED BY alumnos_portatiles.alumno.alumno_id;


--
-- Name: portatil; Type: TABLE; Schema: alumnos_portatiles; Owner: postgres
--

CREATE TABLE alumnos_portatiles.portatil (
    portatil_id bigint NOT NULL,
    portatil_date timestamp without time zone NOT NULL,
    portatil_marca character varying(255) NOT NULL,
    portatil_modelo character varying(255) NOT NULL,
    portatil_uuid uuid NOT NULL
);


ALTER TABLE alumnos_portatiles.portatil OWNER TO postgres;

--
-- Name: portatil_portatil_id_seq; Type: SEQUENCE; Schema: alumnos_portatiles; Owner: postgres
--

CREATE SEQUENCE alumnos_portatiles.portatil_portatil_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE alumnos_portatiles.portatil_portatil_id_seq OWNER TO postgres;

--
-- Name: portatil_portatil_id_seq; Type: SEQUENCE OWNED BY; Schema: alumnos_portatiles; Owner: postgres
--

ALTER SEQUENCE alumnos_portatiles.portatil_portatil_id_seq OWNED BY alumnos_portatiles.portatil.portatil_id;


--
-- Name: alumno alumno_id; Type: DEFAULT; Schema: alumnos_portatiles; Owner: postgres
--

ALTER TABLE ONLY alumnos_portatiles.alumno ALTER COLUMN alumno_id SET DEFAULT nextval('alumnos_portatiles.alumno_alumno_id_seq'::regclass);


--
-- Name: portatil portatil_id; Type: DEFAULT; Schema: alumnos_portatiles; Owner: postgres
--

ALTER TABLE ONLY alumnos_portatiles.portatil ALTER COLUMN portatil_id SET DEFAULT nextval('alumnos_portatiles.portatil_portatil_id_seq'::regclass);


--
-- Data for Name: alumno; Type: TABLE DATA; Schema: alumnos_portatiles; Owner: postgres
--

INSERT INTO alumnos_portatiles.alumno VALUES (1, 'diaz', '2023-02-27 13:01:04.803', 'sergio', '666666666', 'a3a66b04-0449-4b47-afb8-bbeabea87302', 1);
INSERT INTO alumnos_portatiles.alumno VALUES (3, 'mena', '2023-02-27 13:01:40.979', 'javier', '888888888', 'd3d8edea-d331-4d89-83e9-01b0e6f3888b', 2);
INSERT INTO alumnos_portatiles.alumno VALUES (4, 'power', '2023-02-28 12:21:31.2', 'max', '111111111', 'a05ad087-b6ff-41d0-a9e9-40d1cede3d9b', 4);
INSERT INTO alumnos_portatiles.alumno VALUES (5, 'apellidos1', '2023-03-01 13:07:42.69', 'alumno1', '000000000', '2039b5ae-e806-4c79-956c-4288bf33bd79', 5);
INSERT INTO alumnos_portatiles.alumno VALUES (6, 'apellidos2', '2023-03-03 08:54:39.393', 'alumno2', '123456789', '909231ce-3fbf-4d18-ac20-93d87985461f', 7);


--
-- Data for Name: portatil; Type: TABLE DATA; Schema: alumnos_portatiles; Owner: postgres
--

INSERT INTO alumnos_portatiles.portatil VALUES (1, '2023-02-27 13:00:30.121', 'macbook', 'm2', '818278f4-0e33-4761-9d42-96969e9071b1');
INSERT INTO alumnos_portatiles.portatil VALUES (2, '2023-02-27 13:00:35.011', 'axus', 'a1', 'dec4bd3b-433f-4ddb-8c7e-2b30a3533d74');
INSERT INTO alumnos_portatiles.portatil VALUES (3, '2023-02-27 13:00:39.674', 'hp', 'z3', 'c7bb6f10-3a28-49b8-be4f-a3c0f78a14b4');
INSERT INTO alumnos_portatiles.portatil VALUES (4, '2023-02-28 12:21:02.303', 'xxxx', 'yyyy', '440ba368-1a7a-4d31-9c43-83b8af1bf6e2');
INSERT INTO alumnos_portatiles.portatil VALUES (5, '2023-03-01 13:01:26.584', 'dell', 'instituto', 'b63a80d6-062a-47b1-b587-4f46d05921b1');
INSERT INTO alumnos_portatiles.portatil VALUES (6, '2023-03-03 08:49:38.212', 'xiaomi', 'zzz', '6bc22a2d-16fc-4f07-b698-128a22621bbe');
INSERT INTO alumnos_portatiles.portatil VALUES (7, '2023-03-03 08:53:30.121', 'oppo', 'obsoleto', 'b63e1027-de4b-4a28-8c0b-b425768932ca');


--
-- Name: alumno_alumno_id_seq; Type: SEQUENCE SET; Schema: alumnos_portatiles; Owner: postgres
--

SELECT pg_catalog.setval('alumnos_portatiles.alumno_alumno_id_seq', 6, true);


--
-- Name: portatil_portatil_id_seq; Type: SEQUENCE SET; Schema: alumnos_portatiles; Owner: postgres
--

SELECT pg_catalog.setval('alumnos_portatiles.portatil_portatil_id_seq', 7, true);


--
-- Name: alumno alumno_pkey; Type: CONSTRAINT; Schema: alumnos_portatiles; Owner: postgres
--

ALTER TABLE ONLY alumnos_portatiles.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (alumno_id);


--
-- Name: portatil portatil_pkey; Type: CONSTRAINT; Schema: alumnos_portatiles; Owner: postgres
--

ALTER TABLE ONLY alumnos_portatiles.portatil
    ADD CONSTRAINT portatil_pkey PRIMARY KEY (portatil_id);


--
-- Name: alumno uk_4wb2lv8x6hu514patt202k59l; Type: CONSTRAINT; Schema: alumnos_portatiles; Owner: postgres
--

ALTER TABLE ONLY alumnos_portatiles.alumno
    ADD CONSTRAINT uk_4wb2lv8x6hu514patt202k59l UNIQUE (alumno_telefono);


--
-- Name: alumno fk_portatil_id; Type: FK CONSTRAINT; Schema: alumnos_portatiles; Owner: postgres
--

ALTER TABLE ONLY alumnos_portatiles.alumno
    ADD CONSTRAINT fk_portatil_id FOREIGN KEY (portatil_id) REFERENCES alumnos_portatiles.portatil(portatil_id);

----------------------------------------------------------------------------------------------------------------------------------

--
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    enabled smallint NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.authorities VALUES ('sergio', 'ROLE_USER');
INSERT INTO public.authorities VALUES ('sergio', 'ROLE_EMPLOYEE');
INSERT INTO public.authorities VALUES ('sergio', 'ROLE_ADMIN');
INSERT INTO public.authorities VALUES ('moises', 'ROLE_USER');
INSERT INTO public.authorities VALUES ('moises', 'ROLE_EMPLOYEE');
INSERT INTO public.authorities VALUES ('javier', 'ROLE_USER');


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES ('sergio', '123', 1);
INSERT INTO public.users VALUES ('moises', '123', 1);
INSERT INTO public.users VALUES ('javier', '123', 1);


--
-- Name: authorities authorities_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT authorities_pk PRIMARY KEY (username, authority);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: authorities authorities_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT authorities_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- PostgreSQL database dump complete
--