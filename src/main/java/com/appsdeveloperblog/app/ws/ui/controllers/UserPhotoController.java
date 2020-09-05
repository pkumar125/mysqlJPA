package com.appsdeveloperblog.app.ws.ui.controllers;

import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserPhotoDetailRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserPhotoRest;
import com.appsdeveloperblog.app.ws.userphotoservice.UserPhotoService;
import com.appsdeveloperblog.app.ws.userphotoservice.impl.UserPhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("userphoto")

public class UserPhotoController {
    Map<String, UserPhotoRest> usersPhoto;
    @Autowired
    UserPhotoService userPhotoService;
    @GetMapping()
    public String getUserPhotos(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "limit", defaultValue = "50") int limit)
    {
        return "get user photo "+page+ " and Limit = "+limit;
    }

    @GetMapping(path="/{UserIdPh}", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserPhotoRest> getUserPhoto(@PathVariable String UserIdPh)
    {
        if(usersPhoto.containsKey(UserIdPh)){
            return new ResponseEntity<>(usersPhoto.get(UserIdPh), HttpStatus.OK);
        }
       else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping(
            consumes =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }  )
    public ResponseEntity<UserPhotoRest> postUserPhoto(@Valid @RequestBody UserPhotoDetailRequestModel userPhotoDetails ){
        UserPhotoRest returnResult = userPhotoService.createUserPhoto(userPhotoDetails);
        return new ResponseEntity<UserPhotoRest>(returnResult,HttpStatus.OK);
    }
    @PutMapping(path="/{UserIdPh}", consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public UserPhotoRest putUserPhoto(@PathVariable String UserIdPh, @RequestBody UserPhotoDetailRequestModel userPhotoDetails){
        UserPhotoRest returnResult = usersPhoto.get(UserIdPh);
        returnResult.setLastNamePh(userPhotoDetails.getLastNamePh());
        returnResult.setFirstNamePh(userPhotoDetails.getFirstNamePh());

        usersPhoto.put(UserIdPh,returnResult);
        return returnResult;
    }
    @DeleteMapping(path="/{UserIdPh}")
    public ResponseEntity<Void> deleteUserPhoto(@PathVariable String UserIdPh){
        usersPhoto.remove(UserIdPh);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
