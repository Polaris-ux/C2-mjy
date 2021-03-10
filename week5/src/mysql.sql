#1
CREATE TABLE IF NOT EXISTS cqupt_student(
    studentid VARCHAR(10),
    name VARCHAR(20),
    sex VARCHAR(2),
    age INTEGER,
    Fee DECIMAL(10,2),
    address VARCHAR(50),
    memo VARCHAR(300)
    );

#2
CREATE TABLE CourseAa(
                         Aa1 VARCHAR(20),
                         Aa2 INTEGER,
                         Aa3 DECIMAL(10)
);

#3
CREATE TABLE ChooseBb(
                         Bb1 VARCHAR(30),
                         Bb2 INTEGER,
                         Bb3 DECIMAL(6)
);

#4
ALTER TABLE ChooseBb ADD Bb4 VARCHAR(20) NOT NULL DEFAULT "系统测试值";

#5
ALTER TABLE choosebb ADD Bb5 VARCHAR(10) PRIMARY KEY;

#6
CREATE OR REPLACE VIEW View_Choosebb
AS
SELECT Bb1 View_bb1,Bb4 View_bb2,Bb5 View_bb3
FROM choosebb;

#7
DROP VIEW View_Choosebb;

#8
CREATE INDEX index_bb2 ON choosebb(Bb2 ASC);
CREATE INDEX index_bb4 ON choosebb(Bb4 DESC);

#9
ALTER TABLE choosebb DROP INDEX index_bb2;

#10
CREATE TABLE test(
                     Name VARCHAR(20),
                     Age INTEGER,
                     score NUMERIC(10,2),
                     Address VARCHAR(60)
);

#11
INSERT INTO test VALUES('赵一',20,580.00,'重邮宿舍12-3-5'),
('钱二',19,540.00,'南福苑5-2-9'),
('孙三',21,555.50,'学生新区21-5-15'),
('李四',22,505.00,'重邮宿舍8-6-22'),
('周五',20,495.50,'学生新区23-4-8'),
('吴六',19,435.00,'南福苑2-5-12');

#12
CREATE TABLE test_temp(
                          Name VARCHAR(20),
                          Age INT,
                          Score NUMERIC(10,2),
                          Address VARCHAR(60)
);

#13
INSERT INTO test_temp VALUES
('郑七',21,490.50,'重邮宿舍 11-2-1'),
('张八',20,560.00,'南福苑 3-3-3'),
('王九',10,515.00,'学生新区 19-7-1');

#14
INSERT INTO test
SELECT * FROM test_temp;

#15
UPDATE test SET score=score+5
WHERE age<=20;

#16
UPDATE test SET age=age-1
WHERE Address LIKE "%南福苑%";

#17
DELETE FROM test WHERE age>=21 AND score>=500;

#18
DELETE FROM test WHERE score<550 AND address LIKE "重邮宿舍%";

#19
CREATE TABLE student(
                        SNO VARCHAR(20),
                        Name VARCHAR(10),
                        Age INTEGER,
                        College VARCHAR(30)
);

#20
CREATE TABLE Course(
                       CourseID VARCHAR(15),
                       CourseName VARCHAR(30),
                       CourseBeforeID VARCHAR(15)
);

#21
CREATE TABLE Choose(
                       SNO VARCHAR(20),
                       CourseID VARCHAR(30),
                       Score DECIMAL(5,2)
);

#22
INSERT INTO student VALUES
('S00001','张三',20,'计算机学院'),
('S00002','李四',19,'通信学院'),
('S00003','王五',21,'计算机学院');

#23
INSERT INTO Course VALUES
('C1','计算机引论',NULL),
('C2','C语言','C1'),
('C3','数据结构','C2');

#24
INSERT INTO choose VALUES
('S00001','C1',95),
('S00001','C2',80),
('S00001','C3',84),
('S00002','C1',80),
('S00002','C2',85),
('S00003','C1',78),
('S00003','C3',70);

#25
SELECT SNO,name FROM student
WHERE College='计算机学院';

#26
SELECT * FROM student
WHERE Age BETWEEN 20 AND 23;

#27
SELECT COUNT(*) FROM student;

#28
SELECT MAX(Score),MIN(Score),SUM(Score),AVG(Score)
FROM Choose
WHERE CourseID='C1';

#29
SELECT CourseID,CourseName
FROM Course
WHERE CourseBeforeID IS NULL;

#30
SELECT s.SNO,Name,CourseName,Score
FROM Choose c
         JOIN Course c1
              ON c.CourseID=c1.CourseID
         JOIN student s
              ON s.SNO=c.SNO;

#31
SELECT * FROM student s
WHERE EXISTS(
        SELECT SNO FROM student s1
        WHERE s.College=(
            SELECT College FROM student
            WHERE name='张三'
        )
    ) AND name <> '张三';

#32
/*SELECT s.SNO,Score
FROM student s
JOIN Choose c
ON s.SNO=c.SNO
WHERE c.CourseID='C1' AND c.Score<(
SELECT SCORE FROM Choose c1
WHERE SNO=(
SELECT SNO FROM student
WHERE name='张三'
) AND c1.CourseID='C1'
);*/
SELECT SNO,Score
FROM Choose c
WHERE Score<(
    SELECT Score FROM Choose c1
    WHERE SNO=(
        SELECT SNO FROM student
        WHERE `Name`='张三'
    ) AND CourseID='C1'
) AND CourseID='C1';

#33
SELECT SNO FROM Choose
WHERE CourseID='C1'
UNION ALL
SELECT SNO FROM choose
WHERE CourseID='C3';

#34
SELECT SNO FROM Choose
WHERE CourseID='C1'
UNION
SELECT SNO FROM Choose
WHERE CourseID='C3';