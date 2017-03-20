CREATE TABLE `parent` (
  `pName` varchar(25) NOT NULL,
  `fName` varchar(25) NOT NULL,
  `lName` varchar(25) NOT NULL,
  `pWord` varchar(25) NOT NULL,
  `joinDate` date NOT NULL,
  `isDeletee` binary(1) NOT NULL DEFAULT '0',
  `deleteDate` date DEFAULT NULL,
  `pID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pID`),
  UNIQUE KEY `parent_pID_IDX` (`pID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

website
mccodecraftDB


CREATE TABLE `student` (
  `studentName` varchar(25) NOT NULL,
  `studentFName` varchar(25) NOT NULL,
  `studentLName` varchar(25) NOT NULL,
  `studentPWord` varchar(25) NOT NULL,
  `studentjoinDate` date NOT NULL,
  `studentIsDeleted` binary(1) NOT NULL DEFAULT '0',
  `studentDeleteDate` date DEFAULT NULL,
  `pID` int(11) NOT NULL,
  `sID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pID`,`sID`),
  UNIQUE KEY `student_sID_IDX` (`sID`),
  CONSTRAINT `student_parent_FK` FOREIGN KEY (`pID`) REFERENCES `parent` (`pID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `course` (
    `courseID` int(11) NOT NULL AUTO_INCREMENT,
    `courseName` varchar(25) NOT NULL,
    `courseDesc` varchar(2500) NOT NULL,
    PRIMARY KEY (`courseID`),
    UNIQUE KEY `course_courseID_IDX` (`courseID`)

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
CREATE TABLE `video` (
    `videoID` int(11) NOT NULL AUTO_INCREMENT,
    `courseID` int(11) NOT NULL,
    `videoName` varchar(25) NOT NULL,
    `videoDesc` varchar(2500) NOT NULL,
    `youtubeLink` varchar(40) NOT NULL,
    PRIMARY KEY (`videoID`),
    CONSTRAINT `video_course_FK` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

