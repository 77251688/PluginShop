package com.cummins.pluginshop.controller.upload;

import com.cummins.pluginshop.entity.Resp;
import com.cummins.pluginshop.service.upload.UploadImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@Slf4j
public class Upload {
    @Resource
    private UploadImpl uploadService;

    @PostMapping("/upload")
    public Resp<?> upload(@RequestParam(value = "rrt") MultipartFile file) {
        return uploadService.saveFile(file);
    }
}
