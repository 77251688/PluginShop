package com.cummins.pluginshop.service.upload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URISyntaxException;

@Service
@Slf4j
public class UploadImpl implements Upload {
    @Override
    public void saveFile(MultipartFile file) throws URISyntaxException {
        String filename = file.getOriginalFilename();
        System.out.println(this.getClass().getResource("/").toURI());
        log.warn(filename);
    }
}
