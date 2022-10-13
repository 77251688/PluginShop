package com.cummins.pluginshop.controller.login;

import com.cummins.pluginshop.entity.Resp;
import com.cummins.pluginshop.service.login.LoginImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class Login {
    @Resource
    private LoginImpl loginService;

    @PostMapping("/login")
    public Resp<?> login(@RequestBody String param) {
        return loginService.login(param);
    }
}
