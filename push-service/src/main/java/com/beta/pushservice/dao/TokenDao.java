package com.beta.pushservice.dao;

import com.beta.pushservice.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<TokenEntity, String> {

    TokenEntity findByPhone(String phone);

}
