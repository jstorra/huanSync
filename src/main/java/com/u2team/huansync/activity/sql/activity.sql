DROP DATABASE IF EXISTS db_huansync;
CREATE DATABASE db_huansync;
USE db_huansync;

CREATE TABLE tbl_categoryCosplay(
    categoryCosplayId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameCosplay VARCHAR(255) NOT NULL UNIQUE,
    deletable BOOLEAN NOT NULL
);

CREATE TABLE tbl_activities (
    activityId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameActivity VARCHAR(255) NOT NULL,
    typeActivity ENUM("cosplay", "trivia") NOT NULL,
    categoryCosplayId INT,
    numParticipants INT NOT NULL,
    eventId INT,
    startTime TIME NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    completed BOOLEAN NOT NULL
);

CREATE TABLE tbl_trivias (
	triviaId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    activityId INT NOT NULL,
    participantOneId INT NOT NULL,
    participantTwoId INT NOT NULL,
    winnerId INT NOT NULL,
    inchargedId INT NOT NULL
);

CREATE TABLE tbl_prizes (
	prizeId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    typePrize ENUM("manga", "multimedia", "art", "figures", "souvenirs", "clothing", "technology") NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    statusPrize ENUM("available", "awarded") NOT NULL,
    activityId INT,
    winnerId INT
);

CREATE TABLE tbl_questions (
    questionId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL UNIQUE,
    answer VARCHAR(255) NOT NULL,
    category ENUM("Naruto", "SPYxFamily", "Jujutsu Kaisen", "Harry Potter", "Comics") NOT NULL,
    difficulty ENUM("easy", "medium", "hard") NOT NULL
);

/* Categories*/

INSERT INTO tbl_categoryCosplay (nameCosplay, deletable) VALUES
('Anime Characters', false),
('Fantasy Creatures', true),
('Superheroes', false),
('Videogame Characters', true),
('Sci-Fi Icons', false);

/* Activities */

INSERT INTO tbl_activities (nameActivity, typeActivity, categoryCosplayId, numParticipants, startTime, price, completed) VALUES
('Cosplay Contest', 'cosplay', 1, 50, '14:00:00', 25.99, false),
('Anime Trivia', 'trivia', NULL, 8, '15:30:00', 10.50, true),
('Sci-Fi Cosplay Showcase', 'cosplay', 5, 40, '16:45:00', 18.75, false),
('Fantasy Trivia Challenge', 'trivia', NULL, 8, '18:00:00', 12.99, false),
('Superhero Cosplay Parade', 'cosplay', 3, 60, '19:30:00', 20.50, false);

/* Trivias */

INSERT INTO tbl_trivias (activityId, participantOneId, participantTwoId, winnerId, inchargedId) VALUES
(2, 1, 2, 1, 1),
(2, 3, 4, 3, 1),
(2, 5, 6, 5, 1),
(2, 7, 8, 7, 1),
(2, 1, 3, 1, 1),
(2, 5, 7, 5, 1),
(2, 1, 5, 5, 1);

/* Prizes */

INSERT INTO tbl_prizes (typePrize, description, price, statusPrize, activityId, winnerId) VALUES
('multimedia', 'Anime Blu-ray Collection', 45.99, 'available', 1, NULL),
('technology', 'Virtual Reality Headset', 120.00, 'available', 2, 5),
('figures', 'Limited Edition Action Figure Set', 30.50, 'available', 3, NULL),
('art', 'Hand-drawn Manga Illustration', 75.99, 'available', 4, NULL),
('clothing', 'Anime-themed T-shirt and Hoodie Combo', 22.99, 'available', 5, NULL);

/* Questions Naruto*/

INSERT INTO tbl_questions VALUES
(1, "Who is the creator of Naruto?", "Masashi Kishimoto", "Naruto", "Hard"),
(2, "In what year did the Naruto Shippuden anime premiere?", "2007", "Naruto", "Medium"),
(3, "Which village does not belong to one of the Great Ninja Villages?", "Amegakure", "Naruto", "Medium"),
(4, "What study encouraged the adaptation?", "Studio Pierrot", "Naruto", "Hard"),
(5, "According to the creator of Naruto, if a member of the Uchiha Clan and one of the Hyuga Clan had a child, he would be born with:", "A sharingan and a byakugan", "Naruto", "Medium"),
(6, "who is the founder of Konohagakure", "Hashirama Senju", "Naruto", "Hard"),
(7, "It's the nickname of Naruto's father", "Konoha Yellow Flash", "Naruto", "Easy"),
(8, "It is the most powerful eye technique in the ninja world", "Rinnegan", "Naruto", "Easy"),
(9, "Rock Lee is an expert in", "Taijutsu", "Naruto", "Easy"),
(10, "He was the ninja who created the Rasengan", "Minato Namikaze", "Naruto", "Easy");

/* Questions SpyXFamily */

INSERT INTO tbl_questions VALUES
(11, "What is the name of the intelligence agency Twilight works for?", "Wise", "SpyXFamily", "Easy"),
(12, "What is the name of Twilight's mission?", "Operation Strix", "SpyXFamily", "Easy"),
(13, "What ability does Anya possess?", "Telepathy", "SpyXFamily", "Easy"),
(14, "Yor Briar is a ruthless killer but what is her code name?", "Thorn Princess", "SpyXFamily", "Easy"),
(15, "Where did Loid meet Yor before creating his fake family?", "Sastrería", "SpyXFamily", "Medium"),
(16, "What is the name of the prestigious school Anya must attend?", "Eden College", "SpyXFamily", "Medium"),
(17, "Who hit Mr. Swan after he made Anya cry at the school interview?", "Henry", "SpyXFamily", "Hard"),
(18, "What is the name of the Handler?", "Sylvia Sherwood", "SpyXFamily", "Medium"),
(19, "How many Stella stars does a student need to be considered an imperial scholar?", "8 stars", "SpyXFamily", "Hard"),
(20, "How did Yuri Briar find out about Yor's marriage?", "Dominic told him", "SpyXFamily", "Hard");

/* Questions Jujutsu kaisen*/

INSERT INTO tbl_questions VALUES
(21, "What is the name of Megumi Fushiguro's father?", "Toji Fushiguro", "Jujutsu Kaisen", "Easy"),
(22, "What is the name of the Sukuna domain extension?", "Santuario malévolo", "Jujutsu Kaisen", "Medium"),
(23, "What is Satoru Gojo's nickname?", "The strongest shaman","Jujutsu Kaisen", "Medium"),
(24, "Where did Nobara Kugisaki used to live?", "In the countryside","Jujutsu Kaisen",  "Easy"),
(25, "Where is Yuji Itadori High School located?", "Sugisawa","Jujutsu Kaisen", "Medium"),
(26, "How many Sukuna fingers does Suguru Geto have in his possession?", "It is not known", "Jujutsu Kaisen", "Hard"),
(27, "What is Yoshinobu Gokuganji's occupation?", "Principal of Kyoto school", "Jujutsu Kaisen", "Hard"),
(28, "What is the name of the organization in charge of exterminating the cursed creatures?", "Jujutsu Kaisen","Jujutsu Kaisen",  "Hard"),
(29, "What is the name of the Zen'in clan's special technique?", "Tenmei Kikka","Jujutsu Kaisen",  "Easy"),
(30, "What is the strongest level of a curse? Sukuna for example.", "special grade", "Jujutsu Kaisen",  "Easy");

/* Questions Harry Potter*/

INSERT INTO tbl_questions VALUES
(31, "What do wizards call people who don't have any magical abilities?", "Muggles", "Harry Potter",  "Easy"),
(32, "What type of animal does Harry release from his cage when he is at the zoo?", "a boa constrictor", "Harry Potter",  "Easy"),
(33, "What is the name of the little golden ball that makes you win a Quidditch match?", "Snitch", "Harry Potter",  "Easy"),
(34, "Who DOESN'T belong in Gryffindor?", "Draco Malfoy", "Harry Potter",  "Medium"),
(35, "How did Harry Potter's parents die?", "Voldemort", "Harry Potter",  "Medium"),
(36, "What is the spell that Ron mispronounces and upsets Hermione?", "Wingardium Leviosa", "Harry Potter",  "Medium"),
(37, "What is Dumbledore's first name?	", "Albus", "Harry Potter",  "Hard"),
(38, "What color do you associate with Gryffindor house?", "red", "Harry Potter",  "Hard"),
(39, "¿Cómo se llama la lechuza de Harry?", "Hedwig", "Harry Potter",  "Hard"),
(40, "What station in London does the Hogwarts Express leave from?", "King's Cross", "Harry Potter",  "Easy");

/* Question Comics*/

INSERT INTO tbl_questions VALUES
(41, "In what year was the first comic created?", "1895 ", "Comics",  "Hard"),
(42, "What was the best selling comic in history?", "ONE PIECE", "Comics",  "Hard"),
(43, "Which of the Marvel comics was the most popular?", "Spider-Man", "Comics",  "Easy"),
(44, "Which character is your favorite from the DC comics?", "Superman", "Comics",  "Hard"),
(45, "What is the name of Tony Stark's father?", "Howard Stark", "Comics",  "Easy"),
(46, "Who wrote Marvel Comics?", "Stan Lee", "Comics",  "Easy"),
(47, "What is the name of Thor's hammer?", "Mjolnir ", "Comics",  "Medium"),
(48, "What is the real name of the penguin in DC?", "Oswald Chesterfield Cobblepot", "Comics",  "Medium"),
(49, "How many infinity stones does Thanos' gauntlet have?", "6", "Comics",  "Easy"),
(50, "What gem does Vision have in his head?", "Mind Stone", "Comics",  "Medium");