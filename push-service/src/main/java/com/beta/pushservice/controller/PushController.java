package com.beta.pushservice.controller;

import com.beta.pushservice.dao.TokenDao;
import com.beta.pushservice.entity.TokenEntity;
import com.beta.pushservice.model.PhoneListModel;
import com.beta.pushservice.util.PushUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PushController {

    @Autowired
    TokenDao tokenDao;

    @PostMapping("/push/survey")
    public @ResponseBody String pushSurvey(@RequestBody PhoneListModel phoneListModel){
        // 요청자가 보낸 Phone Num 들이 담긴 List
        ArrayList<String> phoneList = phoneListModel.getPhoneList();

        for(String phone : phoneList){
            TokenEntity tokenEntity = tokenDao.findByPhone(phone);
            PushUtil.requestPush(tokenEntity.getToken());
        }

        return "OK";
    }
}
