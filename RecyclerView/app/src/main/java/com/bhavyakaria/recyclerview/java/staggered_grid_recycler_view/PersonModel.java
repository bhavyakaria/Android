package com.bhavyakaria.recyclerview.java.staggered_grid_recycler_view;

public class PersonModel {
    String userName;
    String userEmail;
    String imageUrl;

    public PersonModel(String userName, String userEmail, String imageUrl) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
