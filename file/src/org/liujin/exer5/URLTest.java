package org.liujin.exer5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author LiuJin
 * @date 2022-08-11 18:23
 */
public class URLTest {
    public static void main(String[] args) {
        InputStream fis = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1UT411L71N?spm_id_from=333.851.b_7265636f6d6d656e64.1&vd_source=e643353ead55d95773b793a8ed4fc2c1");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            fis = urlConnection.getInputStream();
            fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\linglaiyao.mp4");
            byte[] bytes = new byte[1024];
            int len;
            while ((len=fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
