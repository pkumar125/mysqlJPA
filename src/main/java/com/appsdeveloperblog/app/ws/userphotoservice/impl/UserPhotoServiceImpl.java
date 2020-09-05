package com.appsdeveloperblog.app.ws.userphotoservice.impl;

import com.appsdeveloperblog.app.ws.shared.MyUtils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserPhotoDetailRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserPhotoRest;
import com.appsdeveloperblog.app.ws.userphotoservice.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserPhotoServiceImpl implements UserPhotoService {
    Map<String, UserPhotoRest> usersPhoto;
    MyUtils myUtils;
    public UserPhotoServiceImpl(){}

    @Autowired
    public UserPhotoServiceImpl(MyUtils myUtils){
        this.myUtils = myUtils;
    }

    @Override
    public UserPhotoRest createUserPhoto(UserPhotoDetailRequestModel userPhotoDetails) {
        UserPhotoRest returnResult = new UserPhotoRest();
        returnResult.setLastNamePh(userPhotoDetails.getLastNamePh());
        returnResult.setEmailPh(userPhotoDetails.getEmailPh());
        returnResult.setFirstNamePh(userPhotoDetails.getFirstNamePh());
        String UserIdPh = myUtils.generrateMyUserID();
        returnResult.setUserIdPh(UserIdPh);
        if(usersPhoto == null){
            usersPhoto = new HashMap<>();
        }
        usersPhoto.put(UserIdPh,returnResult);
        return returnResult;

    }
}
