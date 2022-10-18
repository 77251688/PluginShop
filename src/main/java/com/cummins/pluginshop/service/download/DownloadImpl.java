package com.cummins.pluginshop.service.download;

import com.cummins.pluginshop.entity.Resp;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class DownloadImpl implements Download {
    @Override
    public Resp<?> d() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String b;
            File f = new File(Objects.requireNonNull(this.getClass().getResource("/")).getPath() + "\\hello" + "\\hello.c");
            FileInputStream fileInputStream = new FileInputStream(f);
            int a;
            StringBuilder bBuilder = new StringBuilder();
            while ((a = fileInputStream.read()) != -1) {
                stringBuilder.append(a);
                System.out.print((char) a);
                bBuilder.append((char) a);
            }
            b = bBuilder.toString();
            System.out.println(stringBuilder);
            System.out.println(b);
            return Resp.success("1", b);
        } catch (IOException e) {
            e.printStackTrace();
            return Resp.failed("500", "0", "null");
        }
    }
}
