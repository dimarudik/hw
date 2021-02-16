package com.example.hw2.controller;

import com.example.hw2.exception.EmptyFilenameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

@Controller
public class FileController {

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        String name = file.getOriginalFilename();
        if (name.isEmpty()) {
            throw new EmptyFilenameException("missing file name...");
        }

        byte[] bytes = file.getBytes();
        //String rootPath = System.getProperty("catalina.home");
        String rootPath = "/tmp";
        //File dir = new File(rootPath + File.separator + "external_uploads");
        File dir = new File(rootPath);
/*
        if (!dir.exists()){
            dir.mkdir();
        }
*/

        File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        Logger.getLogger(FileController.class.getName()).info(serverFile.getAbsolutePath());

        return "redirect:/book";
    }

}
