package com.xzy.uncertainty.service;

import org.rosuda.REngine.REXPMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator on 2016/11/21 0021.
 */

public interface IRService {
    Map getDimensionSummary(String local_path, String fileName) throws REXPMismatchException;

}
