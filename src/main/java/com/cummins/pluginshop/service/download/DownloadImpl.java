package com.cummins.pluginshop.service.download;

import com.cummins.pluginshop.entity.Resp;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class DownloadImpl implements Download {
    @Override
    public Resp<?> d() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String b = "";
            File f = new File(this.getClass().getResource("/").getPath() + "\\hello" + "\\hello.c");
            FileInputStream fileInputStream = new FileInputStream(f);
            int a = 0;
            while ((a = fileInputStream.read()) != -1) {
                stringBuilder.append(a);
                System.out.print((char) a);
                b += (char) a;
            }
            System.out.println(stringBuilder.toString());
            System.out.println(b);
            return Resp.success("1", b);
        } catch (IOException e) {
            e.printStackTrace();
            return Resp.failed("500", "0", "null");
        }
    }
}
