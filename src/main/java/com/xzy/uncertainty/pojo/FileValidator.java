package com.xzy.uncertainty.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author zhaoyang on 2016/12/9 0009.
 */
public class FileValidator implements Validator {


    public boolean supports(Class<?> paramClass) {
        return File.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        Properties prop = new Properties();
        List<String> fileTypes = null;
        try {
            prop.load(FileValidator.class.getClassLoader().getResourceAsStream("fileConfig.properties"));
            fileTypes = Arrays.asList(prop.getProperty("fileTypes").split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = (File) obj;
        if (file.getFile().getSize() == 0) {
            errors.rejectValue("file", "valid.file");
        }
        if (fileTypes != null && !fileTypes.contains(file.getFile().getContentType())) {
            errors.rejectValue("file", "valid.fileTypes");
        }
    }

}
