package com.example.hw2.controller;

import com.example.hw2.exception.EmptyFilenameException;
import com.example.hw2.model.FileObject;
import com.example.hw2.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

//TODO добавьте комментарии к каждому методу
@Controller
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        FileObject fileObject = new FileObject();
        String name = file.getOriginalFilename();
        if (name.isEmpty()) {
            throw new EmptyFilenameException("missing file name...");
        }

        byte[] bytes = file.getBytes();
        String rootPath = "/tmp";
        File dir = new File(rootPath);

        File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        //fileObject.setName(serverFile.getAbsolutePath());
        fileObject.setName(name);
        fileRepository.store(fileObject);

        return "redirect:/book";
    }

    @ExceptionHandler(EmptyFilenameException.class)
    public String handleEmptyFilenameException(Model model, EmptyFilenameException emptyFilenameException){
        model.addAttribute("errorMessage", emptyFilenameException.getMessage());
        return "/error";
    }

}
