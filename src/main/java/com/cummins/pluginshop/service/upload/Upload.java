package com.cummins.pluginshop.service.upload;

import com.cummins.pluginshop.entity.Resp;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Upload {
    <T> Resp<T> saveFile(MultipartFile file) throws URISyntaxException, IOException;
}
