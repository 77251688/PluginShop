package com.cummins.pluginshop.service.download;

import com.cummins.pluginshop.entity.Resp;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class DownloadImpl implements Download {
    @Override
    public Resp<byte[]> d() {
        try {
            File f = new File(this.getClass().getResource("/").getPath() + "\\hello" + "\\hello.c");
            FileInputStream fileInputStream = new FileInputStream(f);
            byte[] b = new byte[fileInputStream.available()];
            fileInputStream.read(b, 0, fileInputStream.available());
            return Resp.success("1", b);
        } catch (IOException e) {
            e.printStackTrace();
            Resp.failed("500", "0", "null");
        }
        return null;
    }
}
