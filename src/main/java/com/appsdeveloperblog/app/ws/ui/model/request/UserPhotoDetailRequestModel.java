package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserPhotoDetailRequestModel {
    @NotNull(message = "First Name can't be Null")
    private String firstNamePh;
    @NotNull(message = "Last Name Can't be null")
    private String lastNamePh;
    @Email
    private String emailPh;
    @Size(max = 10,min = 5)
    private String userIdPh;

    public String getFirstNamePh() {
        return firstNamePh;
    }

    public void setFirstNamePh(String firstNamePh) {
        this.firstNamePh = firstNamePh;
    }

    public String getLastNamePh() {
        return lastNamePh;
    }

    public void setLastNamePh(String lastNamePh) {
        this.lastNamePh = lastNamePh;
    }

    public String getEmailPh() {
        return emailPh;
    }

    public void setEmailPh(String emailPh) {
        this.emailPh = emailPh;
    }

    public String getUserIdPh() {
        return userIdPh;
    }

    public void setUserIdPh(String userIdPh) {
        this.userIdPh = userIdPh;
    }


}
