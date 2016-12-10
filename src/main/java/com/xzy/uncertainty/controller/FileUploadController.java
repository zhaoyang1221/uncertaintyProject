package com.xzy.uncertainty.controller;

import com.xzy.uncertainty.pojo.File;
import com.xzy.uncertainty.pojo.FileValidator;
import com.xzy.uncertainty.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Administrator on 2016/12/6 0006.
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
    @Resource
    private IFileService fileUploadService;

    @Autowired
    private FileValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @Value("${local_path}")
    private String local_path;

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(Model model) {
        File fileModel = new File();
        model.addAttribute("file", fileModel);
        return "file";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String fileUpload(HttpServletRequest request, Model model, @Validated File file, BindingResult result) throws IllegalStateException, IOException {
        String returnVal = "main";
        if (result.hasErrors()) {
            returnVal = "file";
        } else {
            MultipartFile multipartFile = file.getFile();

            fileUploadService.fileUpload(request, local_path, multipartFile);
        }
        return returnVal;
    }

}
