package com.cummins.pluginshop.service.login;

import com.cummins.pluginshop.JWT.JWT;
import com.cummins.pluginshop.entity.LoginParam;
import com.cummins.pluginshop.entity.Resp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginImpl implements Login {
    @Override
    public Resp<?> login(String param) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LoginParam loginParam = objectMapper.readValue(param, LoginParam.class);
            String username = loginParam.getUsername();
            String password = loginParam.getPassword();
            Map<String, Object> m = new HashMap<>();
            m.put("username", username);
            m.put("password", password);
            String token = JWT.createToken(m);
            return Resp.success("1", token);
        } catch (IOException e) {
            e.printStackTrace();
            return Resp.failed("400", "参数不合法", null);
        }
    }
}
