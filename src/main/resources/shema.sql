CREATE TABLE `additionalmaterials` (
                                       `idAdditionalMaterials` int NOT NULL,
                                       `AdditionalMaterialsType` varchar(45) NOT NULL DEFAULT 'BOOK',
                                       `AdditionalMaterialsName` varchar(45) NOT NULL,
                                       PRIMARY KEY (`idAdditionalMaterials`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `teachers` (
                            `idTeachers` int NOT NULL,
                            `TeachersFirstName` varchar(45) DEFAULT NULL,
                            `TeachersSecondName` varchar(45) DEFAULT NULL,
                            `TeachersPhone` int NOT NULL,
                            `TeachersEmail` varchar(45) NOT NULL,
                            PRIMARY KEY (`idTeachers`),
                            UNIQUE KEY `TeachersPhone_UNIQUE` (`TeachersPhone`),
                            UNIQUE KEY `TeachersEmail_UNIQUE` (`TeachersEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `students` (
                            `idstudents` int NOT NULL,
                            `studentsFirstName` varchar(45) NOT NULL,
                            `studentsSecondName` varchar(45) NOT NULL,
                            `studentsPhone` int NOT NULL,
                            `studentsEmail` varchar(45) NOT NULL,
                            PRIMARY KEY (`idstudents`),
                            UNIQUE KEY `studentsPhone_UNIQUE` (`studentsPhone`),
                            UNIQUE KEY `studentsEmail_UNIQUE` (`studentsEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `lessons` (
                           `idLessons` int NOT NULL AUTO_INCREMENT,
                           `LessonsName` varchar(45) NOT NULL,
                           `HomeworkId` int NOT NULL,
                           `TeacherId` int NOT NULL,
                           `AMid` int NOT NULL,
                           PRIMARY KEY (`idLessons`),
                           KEY `hw_lessons` (`HomeworkId`),
                           KEY `tc_lessons` (`TeacherId`),
                           CONSTRAINT `hw_lessons` FOREIGN KEY (`HomeworkId`) REFERENCES `homework` (`idHomeWork`),
                           CONSTRAINT `tc_lessons` FOREIGN KEY (`TeacherId`) REFERENCES `teachers` (`idTeachers`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `homework` (
                            `idHomeWork` int NOT NULL,
                            `HomeWorkTask` varchar(45) NOT NULL,
                            `HomeWorkdeadline` date NOT NULL,
                            PRIMARY KEY (`idHomeWork`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `courses` (
                           `idCourses` int NOT NULL,
                           `LessonId` int NOT NULL,
                           `Name` varchar(45) NOT NULL,
                           PRIMARY KEY (`idCourses`),
                           UNIQUE KEY `Name_UNIQUE` (`Name`),
                           KEY `les_courses` (`LessonId`),
                           CONSTRAINT `les_courses` FOREIGN KEY (`LessonId`) REFERENCES `lessons` (`idLessons`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `c_w_s` (
                         `coursesid` int NOT NULL,
                         `studentsid` int NOT NULL,
                         PRIMARY KEY (`coursesid`,`studentsid`),
                         KEY `cws_studentsid` (`studentsid`),
                         CONSTRAINT `cws_coursesid` FOREIGN KEY (`coursesid`) REFERENCES `courses` (`idCourses`),
                         CONSTRAINT `cws_studentsid` FOREIGN KEY (`studentsid`) REFERENCES `students` (`idstudents`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
