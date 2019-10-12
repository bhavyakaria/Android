package com.bhavyakaria.fetchusercontacts.models;

import android.net.Uri;

import java.util.HashSet;
import java.util.Set;

public class ContactModel {

    private String displayName;
    private Set<String> phoneNumbers = new HashSet<>();
    private Set<String> emails = new HashSet<>();
    private long id;
    private boolean starred;
    private Uri photo;

    public ContactModel(long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmail(String email) {
        this.emails.add(email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode () {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactModel contact = (ContactModel) o;
        return id == contact.id;
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "displayName='" + displayName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emails=" + emails +
                ", id=" + id +
                ", starred=" + starred +
                ", photo=" + photo +
                '}';
    }
}
