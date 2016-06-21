CREATE TABLE PersonalLender(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  link VARCHAR(255),
  imageLogoUrl VARCHAR(255),
  bullets VARCHAR(1000),
  rightSideText VARCHAR(1000),
  aboutText VARCHAR(1000),

  PRIMARY KEY (id)

);

INSERT INTO PersonalLender( name, link, imageLogoUrl, bullets, rightSideText, aboutText)
VALUES ('AVANT_CREDIT', 'http://avant.com', 'http://whatever.com', 'asdfasdfads', 'asdfdsafadsaf', 'asdfasdfafadsfasdf');