--TABELA ALIMENTO

CREATE TABLE t_alimento (
    cd_alimento  CHAR(255) NOT NULL,
    tx_descricao VARCHAR2(100),
    vlr_calorias NUMBER NOT NULL,
    dt_consumo   DATE NOT NULL
);

ALTER TABLE t_alimento ADD CONSTRAINT t_alimento_pk PRIMARY KEY ( cd_alimento );

--TABELA ALTURA

CREATE TABLE t_altura (
    cd_altura    CHAR(255) NOT NULL,
    vlr_altura   NUMBER,
    dt_registro  DATE NOT NULL,
    t_imc_cd_imc CHAR(255) NOT NULL
);

CREATE UNIQUE INDEX t_altura__idx ON
    t_altura (
        t_imc_cd_imc
    ASC );

ALTER TABLE t_altura ADD CONSTRAINT t_altura_pk PRIMARY KEY ( cd_altura );

--TABELA ATIVIDADE

CREATE TABLE t_atividade (
    cd_atividade         CHAR(255) NOT NULL,
    tx_descricao         VARCHAR2(100),
    vlr_calorias         NUMBER NOT NULL,
    dt_registro          DATE NOT NULL,
    t_usuario_cd_usuario CHAR(255) NOT NULL
);

ALTER TABLE t_atividade ADD CONSTRAINT t_atividade_pk PRIMARY KEY ( cd_atividade );

--TABELA GENERO

CREATE TABLE t_genero (
    cd_genero CHAR(255) NOT NULL,
    nm_genero VARCHAR2(25) NOT NULL
);

ALTER TABLE t_genero ADD CONSTRAINT t_genero_pk PRIMARY KEY ( cd_genero );

--TABELA IMC

CREATE TABLE t_imc (
    cd_imc               CHAR(255) NOT NULL,
    vlr_imc              NUMBER NOT NULL,
    nm_status            VARCHAR2(30),
    dt_registro          DATE,
    t_peso_cd_peso       CHAR(255) NOT NULL,
    t_altura_cd_altura   CHAR(255) NOT NULL,
    t_usuario_cd_usuario CHAR(255) NOT NULL
);

CREATE UNIQUE INDEX t_imc__idx ON
    t_imc (
        t_peso_cd_peso
    ASC );

CREATE UNIQUE INDEX t_imc__idxv1 ON
    t_imc (
        t_altura_cd_altura
    ASC );

ALTER TABLE t_imc ADD CONSTRAINT t_imc_pk PRIMARY KEY ( cd_imc );

--TABELA PESO

CREATE TABLE t_peso (
    cd_peso      CHAR(255) NOT NULL,
    vlr_peso     NUMBER NOT NULL,
    dt_registro  DATE NOT NULL,
    t_imc_cd_imc CHAR(255) NOT NULL
);

CREATE UNIQUE INDEX t_peso__idx ON
    t_peso (
        t_imc_cd_imc
    ASC );

ALTER TABLE t_peso ADD CONSTRAINT t_peso_pk PRIMARY KEY ( cd_peso );

--TABELA PRESSAO ARTERIAL

CREATE TABLE t_pressao_arterial (
    cd_pressao_arterial  CHAR(255) NOT NULL,
    vlr_diastolica       INTEGER NOT NULL,
    vlr_sistolica        INTEGER NOT NULL,
    dt_registro          DATE NOT NULL,
    tx_situacao          VARCHAR2(100),
    t_usuario_cd_usuario CHAR(255) NOT NULL
);

ALTER TABLE t_pressao_arterial ADD CONSTRAINT t_pressao_arterial_pk PRIMARY KEY ( cd_pressao_arterial );

--TABELA TIPO

CREATE TABLE t_tipo (
    cd_tipo CHAR(255) NOT NULL,
    nm_tipo VARCHAR2(50) NOT NULL
);

ALTER TABLE t_tipo ADD CONSTRAINT t_tipo_alimento_pk PRIMARY KEY ( cd_tipo );

--TABELA TIPO DE ATIVIDADE

CREATE TABLE t_tipo_atv (
    cd_tipo CHAR(255) NOT NULL,
    nm_tipo VARCHAR2(50) NOT NULL
);

ALTER TABLE t_tipo_atv ADD CONSTRAINT t_tipo_atividade_pk PRIMARY KEY ( cd_tipo );

--TABELA DO USUARIO

CREATE TABLE t_usuario (
    cd_usuario         CHAR(255) NOT NULL,
    nm_usuario         VARCHAR2(200) NOT NULL,
    tx_email           VARCHAR2(50) NOT NULL,
    vlr_senha          VARCHAR2(25) NOT NULL,
    dt_nascimento      DATE NOT NULL,
    t_genero_cd_genero CHAR(255) NOT NULL
);

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_pk PRIMARY KEY ( cd_usuario );


----------------------------------------- TABELAS RELATIONS ----------------------------------------------

CREATE TABLE relation_10 (
    t_usuario_cd_usuario   CHAR(255) NOT NULL,
    t_alimento_cd_alimento CHAR(255) NOT NULL
);

ALTER TABLE relation_10 ADD CONSTRAINT relation_10_pk PRIMARY KEY ( t_usuario_cd_usuario,
                                                                    t_alimento_cd_alimento );

CREATE TABLE relation_2 (
    t_alimento_cd_alimento CHAR(255) NOT NULL,
    t_tipo_cd_tipo         CHAR(255) NOT NULL
);

ALTER TABLE relation_2 ADD CONSTRAINT relation_2_pk PRIMARY KEY ( t_alimento_cd_alimento,
                                                                  t_tipo_cd_tipo );

CREATE TABLE relation_9 (
    t_atividade_cd_atividade CHAR(255) NOT NULL,
    t_tipo_atv_cd_tipo       CHAR(255) NOT NULL
);

ALTER TABLE relation_9 ADD CONSTRAINT relation_9_pk PRIMARY KEY ( t_atividade_cd_atividade,
                                                                  t_tipo_atv_cd_tipo );
ALTER TABLE relation_10
    ADD CONSTRAINT relation_10_t_alimento_fk FOREIGN KEY ( t_alimento_cd_alimento )
        REFERENCES t_alimento ( cd_alimento );

ALTER TABLE relation_10
    ADD CONSTRAINT relation_10_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE relation_2
    ADD CONSTRAINT relation_2_t_alimento_fk FOREIGN KEY ( t_alimento_cd_alimento )
        REFERENCES t_alimento ( cd_alimento );

ALTER TABLE relation_2
    ADD CONSTRAINT relation_2_t_tipo_fk FOREIGN KEY ( t_tipo_cd_tipo )
        REFERENCES t_tipo ( cd_tipo );

ALTER TABLE relation_9
    ADD CONSTRAINT relation_9_t_atividade_fk FOREIGN KEY ( t_atividade_cd_atividade )
        REFERENCES t_atividade ( cd_atividade );

ALTER TABLE relation_9
    ADD CONSTRAINT relation_9_t_tipo_atv_fk FOREIGN KEY ( t_tipo_atv_cd_tipo )
        REFERENCES t_tipo_atv ( cd_tipo );

ALTER TABLE t_altura
    ADD CONSTRAINT t_altura_t_imc_fk FOREIGN KEY ( t_imc_cd_imc )
        REFERENCES t_imc ( cd_imc );

ALTER TABLE t_atividade
    ADD CONSTRAINT t_atividade_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_imc
    ADD CONSTRAINT t_imc_t_altura_fk FOREIGN KEY ( t_altura_cd_altura )
        REFERENCES t_altura ( cd_altura );

ALTER TABLE t_imc
    ADD CONSTRAINT t_imc_t_peso_fk FOREIGN KEY ( t_peso_cd_peso )
        REFERENCES t_peso ( cd_peso );

ALTER TABLE t_imc
    ADD CONSTRAINT t_imc_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_peso
    ADD CONSTRAINT t_peso_t_imc_fk FOREIGN KEY ( t_imc_cd_imc )
        REFERENCES t_imc ( cd_imc );

ALTER TABLE t_pressao_arterial
    ADD CONSTRAINT t_pres_art_t_us_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_usuario
    ADD CONSTRAINT t_usuario_t_genero_fk FOREIGN KEY ( t_genero_cd_genero )
        REFERENCES t_genero ( cd_genero );
