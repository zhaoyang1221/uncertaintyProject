package com.xzy.uncertainty.service;

import org.rosuda.REngine.REXPMismatchException;

import java.util.List;

/**
 * @author Administrator on 2016/11/21 0021.
 */

public interface IRService {
    List getDimensionSummary() throws REXPMismatchException;
}
