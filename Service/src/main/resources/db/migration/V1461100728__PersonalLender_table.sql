CREATE TABLE PersonalLender(
  id BIGINT,
  name VARCHAR(255),
  link VARCHAR(255),
  imageLogoUrl VARCHAR(255),
  bullets VARCHAR(1000),
  rightSideText VARCHAR(1000),
  aboutText VARCHAR(1000)
);

INSERT INTO PersonalLender(id, name, link, imageLogoUrl, bullets, rightSideText, aboutText)
VALUES (1,'AVANT_CREDIT', 'http://avant.com', 'http://whatever.com', 'asdfasdfads', 'asdfdsafadsaf', 'asdfasdfafadsfasdf');