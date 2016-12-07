package com.xzy.uncertainty.service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Administrator on 2016/12/6 0006.
 */
public interface IFileService {
    String fileUpload(HttpServletRequest request, String local_path) throws IllegalStateException, IOException;
}
