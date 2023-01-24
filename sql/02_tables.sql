drop table if exists surveyquestions; 
drop table if exists surveyreplies; 
drop table if exists usersurveytoken; 
drop table if exists surveys; --
drop table if exists questions; --

drop table if exists candidates; ---
drop table if exists candidate_states; ---
drop table if exists coursepage; --

drop table if exists users; --
drop table if exists roles; --


create table roles (
	id bigint NOT NULL AUTO_INCREMENT, 
	label VARCHAR(50),
	description VARCHAR(2000),
	level int,
	primary key(id),
	CONSTRAINT level UNIQUE (level)
);
insert into roles(id, label, description, level) VALUES (1, 'admin', 'administrator', 0);
insert into roles(id, label, description, level) VALUES (2, 'developer', 'developer', 10);
insert into roles(id, label, description, level) VALUES (3, 'permanent, external consultant', 'dipendente, attualmente impiegato in activita di consulenza esterna', 50);
insert into roles(id, label, description, level) VALUES (4, 'java course candidate', 'candidato a partecipare a corso java', 90);
insert into roles(id, label, description, level) VALUES (5, 'guest', 'guest', 100);
insert into roles(id, label, description, level) VALUES (6, 'hr', 'human resources collegue', 5);

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `regdate` datetime NOT NULL,
  `role` int(11) NOT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqueEmail` (`email`),
  KEY `role` (`role`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role`) REFERENCES `roles` (`level`)
);

insert into users (email,firstname,lastname, password, regdate, dateofbirth, role) VALUES ('1@2.3','bbb','aaa', 'aaa', '2018-11-01', '2018-11-01',10);


CREATE TABLE `coursepage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) NOT NULL,
  `code` varchar(100) NOT NULL,
  `body_text` mediumtext NOT NULL,
  `file_name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
);
INSERT INTO `coursepage` VALUES (1,'Candidatura generica','MIGEN01','Candidatura spontanea',NULL),(2,'Candidatura corso FullStackWeb+Java 01 Milano','MICEACFS01','Candidatura partecipazione a I Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Gen18-Mar18',NULL),(3,'Candidatura corso FullStackWeb+Java 02 Milano','MICEACFS02','Candidatura partecipazione a II Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Apr18-Giu18',NULL),(4,'Candidatura corso FullStackWeb+Java 03 Milano','MICEACFS03','Candidatura partecipazione a III Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Nov18-Gen19',NULL),(5,'Candidatura corso FullStackWeb+Java 04 Milano','MICEACFS04','Candidatura partecipazione a IV Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Mar19-Mag19',NULL),(6,'Candidatura corso FullStackWeb+Java 05 Milano','MICEACFS05','Corso FullStack Java 05 - Milano',NULL),(9,'Corso Fullstack java developer Roma-Milano 01','FSRMMI01','https://proximainformatica.com/',NULL);

CREATE TABLE `candidate_states` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `status_code` int(11) NOT NULL,
  `status_label` varchar(300) DEFAULT NULL,
  `status_description` varchar(1000) DEFAULT NULL,
  `status_color` varchar(7) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `status_code` (`status_code`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `candidate_states_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);

INSERT INTO `candidate_states` VALUES (1,4,1,'DA VALUTARE','entry appena effettuata. Stato: DA VALUTARE - DEFAULT','#f60000'),(2,4,2,'ha rinunciato','Ha rinunciato di sua scelta al corso','#f98742'),(3,4,3,'inadeguato standing/comportamentale','Scartato per inadeguatezza in termini di standing o criticità comportamentali','#f9c842'),(4,4,4,'inadeguato background','Scartato per inadeguatezza del suo backround','#f9ec14'),(5,4,5,'da tenere in considerazione per corso formatemp','inadeguato backround/standing/altre criticità ma potrebbe rientrare in caso di formatemp','#0e81ec'),(6,4,6,'background solo parzialmente adeguato, NON LAUREATO/NON LAUREANDO','background parzialmente adeguato, tenere in considerazione nella fase finale della selezione. NON LAUREATO/NON LAUREANDO','#2585de'),(7,4,7,'background solo parzialmente adeguato, LAUREATO/LAUREANDO in materie informatiche, matematiche o affini','background parzialmente adeguato, tenere in considerazione nella fase finale della selezione. LAUREATO/LAUREANDO in materie informatiche, matematiche o affini','#25ded3'),(8,4,8,'OK. Background di prima scelta. NON LAUREATO/LAUREANDO. Buona motivazione e backgound','OK già da subito.','#7af914'),(9,4,9,'OK. Background di prima scelta. LAUREATO/LAUREANDO. Buona motivazione e backgound','OK già da subito.','#63b81e');

CREATE TABLE `candidates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `domicile_city` varchar(100) DEFAULT NULL,
  `study_qualification` varchar(300) DEFAULT NULL,
  `graduate` tinyint(1) DEFAULT NULL,
  `high_graduate` tinyint(1) DEFAULT NULL,
  `still_high_study` tinyint(1) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `cv_external_path` varchar(1000) DEFAULT NULL,
  `course_code` varchar(100) NOT NULL,
  `candidacy_date_time` datetime NOT NULL,
  `label` varchar(200) DEFAULT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `regdate` datetime NOT NULL,
  `technical_note` varchar(2000) DEFAULT NULL,
  `hr_note` varchar(2000) DEFAULT NULL,
  `inserted_by` bigint(20) NOT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `candidate_state_code` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `course_code` (`course_code`),
  KEY `inserted_by` (`inserted_by`),
  KEY `candidate_state_code` (`candidate_state_code`),
  CONSTRAINT `candidates_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `candidates_ibfk_2` FOREIGN KEY (`course_code`) REFERENCES `coursepage` (`code`),
  CONSTRAINT `candidates_ibfk_4` FOREIGN KEY (`inserted_by`) REFERENCES `users` (`id`),
  CONSTRAINT `candidates_ibfk_5` FOREIGN KEY (`candidate_state_code`) REFERENCES `candidate_states` (`status_code`)
);

create table questions (
    id bigint primary key not null auto_increment,
    label varchar(500) not null,
    description varchar(3000),
    ansa VARCHAR(255),
	ansb VARCHAR(255),
	ansc VARCHAR(255),
	ansd VARCHAR(255),
	anse VARCHAR(255),
	ansf VARCHAR(255),
	ansg VARCHAR(255),
	ansh VARCHAR(255),
	cansa BIT,
	cansb BIT,
	cansc BIT,
	cansd BIT,
	canse BIT,
	cansf BIT,
	cansg BIT,
	cansh BIT,
	full_answer VARCHAR(3000)
);

create table surveys(
	id bigint primary key not null auto_increment,
	label VARCHAR(50) NOT NULL,
	time bigint,
	description VARCHAR(2000)
);

create table usersurveytoken (
	id bigint NOT NULL AUTO_INCREMENT, 
	userid bigint not null,
	surveyid bigint not null,
	generatedtoken VARCHAR(50),
	expirationdate datetime,
	expired boolean,
	primary key(id),
	CONSTRAINT uniqueToken UNIQUE (generatedtoken),
	foreign key (userid) references users(id),
	foreign key (surveyid) references surveys(id)
);

create table surveyquestions (
    id bigint primary key auto_increment,
    survey_id bigint not null,
    question_id bigint not null,
    position int,
    foreign key (survey_id) references surveys(id),
    foreign key (question_id) references questions(id),
    CONSTRAINT UC_SurveyQuestion UNIQUE (survey_id,question_id)
    
);

create table surveyreplies(
	id bigint primary key not null auto_increment,
	survey_id bigint not null,
	user_id bigint not null,
	starttime datetime,
	endtime datetime,
	answers varchar(5000),
	pdffilename varchar(100),
	points varchar(50),
	foreign key(survey_id) references surveys(id),
	foreign key(user_id) references users(id)
);