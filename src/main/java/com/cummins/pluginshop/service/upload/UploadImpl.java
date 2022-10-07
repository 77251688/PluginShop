package com.cummins.pluginshop.service.upload;

import com.cummins.pluginshop.entity.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class UploadImpl implements Upload {
    @Override
    public Resp<?> saveFile(MultipartFile file) {
        String filename = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
        String fileOriginalName = file.getOriginalFilename();
        File file1 = new File(this.getClass().getResource("/").getPath() + filename);
        if (!file1.exists()) {
            file1.mkdir();
        }
        try {
            file.transferTo(new File(file1 + "\\" + fileOriginalName));
            return Resp.success("上传成功", "path" + file1 + "\\" + filename);
        } catch (IOException e) {
            e.printStackTrace();
            return Resp.failed("500", "", 500);
        }
    }
}
