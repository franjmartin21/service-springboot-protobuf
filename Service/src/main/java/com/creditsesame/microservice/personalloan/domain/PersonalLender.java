package com.creditsesame.microservice.personalloan.domain;

/**
    Simple domain class, as we do in csweb the common audit fields id, createDate, updateDate could be inherit from
    another class, but did it without this for now to keep it simple
 */
public class PersonalLender {
    private int id;

    private String name;

    private String link;

    private String imageLogoUrl;

    private String bullets;

    private String rightSideText;

    private String aboutText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageLogoUrl() {
        return imageLogoUrl;
    }

    public void setImageLogoUrl(String imageLogoUrl) {
        this.imageLogoUrl = imageLogoUrl;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getRightSideText() {
        return rightSideText;
    }

    public void setRightSideText(String rightSideText) {
        this.rightSideText = rightSideText;
    }

    public String getAboutText() {
        return aboutText;
    }

    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }
}
