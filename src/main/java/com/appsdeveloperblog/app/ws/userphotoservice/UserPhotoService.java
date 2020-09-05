package com.appsdeveloperblog.app.ws.userphotoservice;

import com.appsdeveloperblog.app.ws.ui.model.request.UserPhotoDetailRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserPhotoRest;

public interface UserPhotoService {
    UserPhotoRest createUserPhoto(UserPhotoDetailRequestModel userPhotoDetails);
}
