CREATE TABLE `additionalmaterials` (
                                       `idAdditionalMaterials` int NOT NULL,
                                       `AdditionalMaterialsType` varchar(45) NOT NULL DEFAULT 'BOOK',
                                       `AdditionalMaterialsName` varchar(45) NOT NULL,
                                       `lessons_id` int DEFAULT NULL,
                                       PRIMARY KEY (`idAdditionalMaterials`),
                                       KEY `lessons_ad` (`lessons_id`),
                                       CONSTRAINT `lessons_ad` FOREIGN KEY (`lessons_id`) REFERENCES `lessons` (`idLessons`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `c_w_s` (
                         `coursesid` int NOT NULL,
                         `studentsid` int NOT NULL,
                         PRIMARY KEY (`coursesid`,`studentsid`),
                         KEY `cws_studentsid` (`studentsid`),
                         CONSTRAINT `cws_coursesid` FOREIGN KEY (`coursesid`) REFERENCES `courses` (`idCourses`),
                         CONSTRAINT `cws_studentsid` FOREIGN KEY (`studentsid`) REFERENCES `students` (`idstudents`)
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

CREATE TABLE `homework` (
                            `idHomeWork` int NOT NULL,
                            `HomeWorkTask` varchar(45) NOT NULL,
                            `HomeWorkdeadline` date NOT NULL,
                            `lessons_id` int DEFAULT NULL,
                            PRIMARY KEY (`idHomeWork`),
                            KEY `lessons_hw` (`lessons_id`),
                            CONSTRAINT `lessons_hw` FOREIGN KEY (`lessons_id`) REFERENCES `lessons` (`idLessons`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `lessons` (
                           `idLessons` int NOT NULL AUTO_INCREMENT,
                           `LessonsName` varchar(45) NOT NULL,
                           `TeacherId` int NOT NULL,
                           `create_date` date DEFAULT NULL,
                           PRIMARY KEY (`idLessons`),
                           KEY `tc_lessons` (`TeacherId`),
                           CONSTRAINT `tc_lessons` FOREIGN KEY (`TeacherId`) REFERENCES `teachers` (`idTeachers`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

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

    *****************************************Task40******************************

    1.
SELECT * FROM online_school.students
order by studentsSecondName;

2.
SELECT LessonsName,create_date,  count(additionalmaterials.lessons_id) as AMCount FROM online_school.lessons, additionalmaterials
where (lessons.idLessons = additionalmaterials.lessons_id) and
    (create_date < '2023-01-01')
group by LessonsName,create_date
order by create_date;

3.
SELECT *
FROM `lessons`
WHERE `create_date` = (
    SELECT MIN(`create_date`)
    FROM `lessons`
)
ORDER BY (
             SELECT COUNT(*)
             FROM `homework`
             WHERE `lessons_id` = `lessons`.`idLessons`
         ) DESC
    LIMIT 1;


4.
SELECT count(AdditionalMaterialsType), AdditionalMaterialsType FROM online_school.additionalmaterials
group by AdditionalMaterialsType;

5.
SELECT * FROM online_school.teachers
where TeachersSecondName REGEXP '^[A-N]';

6.
SELECT studentsFirstName,studentsSecondName,  count(c_w_s.coursesid) as courseCount FROM online_school.students, c_w_s
where (students.idstudents = c_w_s.studentsid)
group by studentsFirstName, studentsSecondName
order by studentsSecondName;

*********************************41**************************************************

1.
SELECT l.LessonsName, l.create_date, t.TeachersSecondName, t.TeachersFirstName
FROM lessons l
         JOIN teachers t ON l.TeacherId = t.idTeachers
order by create_date;
2.
SELECT  t.TeachersSecondName, t.TeachersFirstName, count(l.TeacherId), l.TeacherId
FROM lessons l
         JOIN teachers t ON l.TeacherId = t.idTeachers
group by TeacherId;
3.
SELECT  t.TeachersSecondName, t.TeachersFirstName, l.create_date, l.LessonsName, l.TeacherId
FROM lessons l
         JOIN teachers t ON l.TeacherId = t.idTeachers
where l.TeacherId = '3'
order by create_date;
4.
SELECT
    c.idCourses,
    c.Name,
    COUNT(DISTINCT l.idLessons) AS LessonCount,
    COUNT(DISTINCT s.idstudents) AS StudentCount,
    COUNT(DISTINCT t.idTeachers) AS TeacherCount,
    COUNT(DISTINCT hw.idHomeWork) AS HomeworkCount,
    COUNT(DISTINCT ad.idAdditionalMaterials) AS AdditionalMaterialsCount
FROM
    courses c
        LEFT JOIN
    lessons l ON c.idCourses = l.courses_id
        LEFT JOIN
    c_w_s cws ON c.idCourses = cws.coursesid
        LEFT JOIN
    students s ON cws.studentsid = s.idstudents
        LEFT JOIN
    teachers t ON l.TeacherId = t.idTeachers
        LEFT JOIN
    homework hw ON l.idLessons = hw.lessons_id
        LEFT JOIN
    additionalmaterials ad ON l.idLessons = ad.lessons_id
GROUP BY
    c.idCourses, c.Name;
5.
SELECT DATE_FORMAT(create_date, '%M') AS month, COUNT(*) AS lecture_count
FROM lessons
GROUP BY month
    6.
SELECT 'homework' AS category, COUNT(idHomeWork) AS count
FROM homework
UNION ALL
SELECT 'AM' AS category, COUNT(idAdditionalMaterials) AS count
FROM additionalmaterials
ORDER BY count DESC
    LIMIT 1;