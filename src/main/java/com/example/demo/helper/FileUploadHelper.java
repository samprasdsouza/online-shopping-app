package com.example.demo.helper;


import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.InputMismatchException;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "/Users/Sam/Desktop/demo/src/main/resources/static/image";

    public boolean uploadFile(MultipartFile f){
        boolean nf = false;

        try{


//           InputStream is = f.getInputStream();
//           byte data[] = new byte[is.available()];
//           is.read(data);
//           //write
//            FileOutputStream fos =new FileOutputStream(UPLOAD_DIR+"/"+f.getOriginalFilename());

            //Files.copy(f.getInputStream(),UPLOAD_DIR+"/"+"newImage", StandardCopyOption.REPLACE_EXISTING);
            Files.copy( f.getInputStream(), Paths.get(UPLOAD_DIR+"/"+f.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            nf =true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return nf;
    }
}
