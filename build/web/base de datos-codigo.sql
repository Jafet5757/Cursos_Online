create database escuela;
use escuela;

--Tabla carrera
create table carrera(
clave_c int,
nom_c varchar(50),
durac_c float,
constraint pk_cc primary key (clave_c));

--insertar datos
insert into carrera values(1,'Inteligencia artificial',3);
insert into carrera values(2,'Sistemas',3);

--Tabla materia
create table materia(
clave_m int,
nom_m varchar(50),
cred_m float,
constraint pk_cm primary key (clave_m));

insert into materia values(1,'Calculo',16);
insert into materia values(2,'Fisica',23);

--Tabla del profesor
create table profesor(
clave_p int,
nom_p varchar(150),
dir_p varchar(200),
tel_p bigint,
hot_p datetime,
constraint pk_cp primary key (clave_p));

insert into profesor values(1,'Jafet','neza',5151151,'7:00');
insert into profesor values (2,'Juan','alle rosa',15451,'9:59');

/*tabla alumna 
	con llave foranea*/
create table alumno(
mat_alu int,
nom_alu varchar(150),
edad_alu int,
sem_alu int,
gen_alu varchar(10),
clave_c1 int, --esta es la clave foranea de la carrera
constraint pk_calu primary key(mat_alu),
constraint fk_fc1 foreign key(clave_c1) references carrera (clave_c));

--Con la llave foranea
insert into alumno values (1,'kevin',18,6,'men',1);

--alumno´profesor
create table alu_pro(
mat_alu1 int,
clave_p1 int,
constraint fk_falu1 foreign key(mat_alu1) references alumno(mat_alu),
constraint fk_fp1 foreign key(clave_p1) references profesor (clave_p));

insert into alu_pro values(1,1);

--Materia-alumno
create table mat_alu(
clave_m1 int,
mat_alu2 int,
constraint fk_fm1 foreign key (clave_m1) references materia (clave_m),
constraint fk_falu2 foreign key (mat_alu2) references alumno (mat_alu));

insert mat_alu values(1,1)

--Meteria-profesor
create table mat_pro(
clave_m2 int,
clave_p2 int,
constraint fk_fm2 foreign key(clave_m2) references materia(clave_m),
constraint fk_fp2 foreign key(clave_p2) references profesor(clave_p));

insert into mat_pro values(2,2);


--Consultas
select * from carrera;
select * from alumno;
select * from mat_pro;
select * from profesor;

--insertss
insert into carrera values (3,'diseño',3)

insert into materia values(3,'dibujo',15)
insert into materia values(4,'programacion',20)

insert into alumno values(2,'sergio',19,7,'hombre',2)
insert into alumno values(3,'julieta',20,6,'mujer',3)

insert into alu_pro values(2,2)
insert into alu_pro values(3,2)

insert into mat_alu values(4,2)
insert into mat_alu values(3,3)
insert into mat_alu values (4,1)

--consultas JOINS
SELECT * FROM ALUMNO

SELECT NOM_ALU,EDAD_ALU,SEM_ALU,NOM_C
FROM ALUMNO INNER JOIN CARRERA ON ALUMNO.CLAVE_C1=CARRERA.CLAVE_C

SELECT NOM_ALU,EDAD_ALU,SEM_ALU,NOM_C,NOM_P
FROM ALUMNO INNER JOIN CARRERA ON ALUMNO.CLAVE_C1=CARRERA.CLAVE_C
INNER JOIN ALU_PRO ON ALU_PRO.MAT_ALU1=ALUMNO.MAT_ALU
INNER JOIN PROFESOR ON PROFESOR.CLAVE_P=ALU_PRO.CLAVE_P1

SELECT NOM_ALU,EDAD_ALU,SEM_ALU,NOM_C,NOM_P,NOM_M
FROM ALUMNO INNER JOIN CARRERA ON ALUMNO.CLAVE_C1=CARRERA.CLAVE_C
INNER JOIN ALU_PRO ON ALU_PRO.MAT_ALU1=ALUMNO.MAT_ALU
INNER JOIN PROFESOR ON PROFESOR.CLAVE_P=ALU_PRO.CLAVE_P1
INNER JOIN MAT_ALU ON MAT_ALU.MAT_ALU2=ALUMNO.MAT_ALU
INNER JOIN MATERIA ON MATERIA.CLAVE_M=MAT_ALU.CLAVE_M1