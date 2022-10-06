package com.cummins.pluginshop.controller.upload;

import com.cummins.pluginshop.entity.Resp;
import com.cummins.pluginshop.service.upload.UploadImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class Upload {
    @Resource
    private UploadImpl uploadService;

    @PostMapping("/upload")
    public Resp<String> upload(@RequestParam(value = "rrt") MultipartFile file) throws URISyntaxException, IOException {
        return uploadService.saveFile(file);
    }

    @PostMapping("/tt1")
    public void tt(@RequestBody Map<String, String> m) {
        System.out.println(m);
    }

    @GetMapping("/tt1")
    public void gg(@RequestParam String param) {
        System.out.println(param);
    }
}
