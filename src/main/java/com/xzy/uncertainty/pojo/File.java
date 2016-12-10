package com.xzy.uncertainty.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhaoyang on 2016/12/9 0009.
 */
public class File {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
