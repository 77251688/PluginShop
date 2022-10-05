package com.cummins.pluginshop.service.upload;

import org.springframework.web.multipart.MultipartFile;

import java.net.URISyntaxException;

public interface Upload {
    void saveFile(MultipartFile file) throws URISyntaxException;
}
