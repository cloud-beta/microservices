package com.beta.pushservice.controller;

import com.beta.pushservice.dao.TokenDao;
import com.beta.pushservice.entity.TokenEntity;
import com.beta.pushservice.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    TokenDao tokenDao;

    /**
     * Phone 번호에 대응하는 Token값을 돌려주는 API
     * @param phone
     * @return
     */
    @GetMapping("/token/{phone}")
    public @ResponseBody String getToken(@PathVariable("phone") String phone){
        TokenEntity tokenEntity = tokenDao.findByPhone(phone);
        String token = tokenEntity.getToken();

        return token;
    }

    /**
     * Token과 함께 Phone번호를 테이블에 저장하는 API
     * @param tokenModel Client 측에서 보내주는 Token값과 Phone 번호가 담긴 Json값
     * @return
     */
    @PostMapping("/token")
    public @ResponseBody String registerToken(@RequestBody TokenModel tokenModel){
        String phone = tokenModel.getPhone();
        String token = tokenModel.getToken();

        //각 번호 4자리 검증
        if (StringUtils.isEmpty(phone))
            throw new IllegalArgumentException("Phone Number is Empty!");
        if (phone.length() != 11)
            throw new IllegalArgumentException("Phone Number must be eleven length");

        //token 값 검증
        if (StringUtils.isEmpty(tokenModel.getToken()))
            throw new IllegalArgumentException("Token is Empty");

        //Token 데이터베이스에 저장
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setPhone(phone);
        tokenEntity.setToken(token);
        tokenDao.save(tokenEntity);

        return "OK";
    }
}
