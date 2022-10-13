package com.cummins.pluginshop.controller.download;

import com.cummins.pluginshop.entity.Resp;
import com.cummins.pluginshop.service.download.DownloadImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class Download {
    @Resource
    private DownloadImpl downloadImpl;

    @PostMapping(value = "/download")
    public Resp<?> download() {
        return downloadImpl.d();
    }
}
