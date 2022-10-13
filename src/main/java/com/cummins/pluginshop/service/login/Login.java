package com.cummins.pluginshop.service.login;

import com.cummins.pluginshop.entity.Resp;

public interface Login {
    Resp<?> login(String param);
}
