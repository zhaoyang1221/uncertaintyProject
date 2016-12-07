package com.xzy.uncertainty.service.impl;


import com.xzy.uncertainty.service.IRService;
import org.math.R.Rsession;
import org.rosuda.REngine.REXPMismatchException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator on 2016/11/21 0021.
 */
@Service
public class RServiceImpl implements IRService {
    public Map<String, ArrayList<String>> getDimensionSummary(String local_path, String fileName) throws REXPMismatchException {
//      System.out.println(System.getProperty("user.dir"));
        String completePath = local_path + "/"+ fileName;
        Rsession s = Rsession.newInstanceTry(System.out, null);
        s.eval("getwd()");
        s.sendFile(new File(completePath));
        s.set("fileName", fileName);
        s.eval("data <- read.csv(fileName)");
//        s.eval("myvars <- c(\"G\", \"MP\", \"FG\", \"FGA\", \"X3P\", \"X3PA\", \"FT\", \"FTA\", \"ORB\", \"DRB\", \"AST\", \"STL\", \"BLK\", \"TOV\", \"PF\", \"PTS\")");
//        s.eval("Kobe <- Kobe[myvars]");
        String[] summary = s.eval("summary(data)").asStrings();
        String[] namesOfDim = s.eval("names(data)").asStrings();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < namesOfDim.length; i++) {
            ArrayList<String> sub = new ArrayList<String>();
            sub.addAll(Arrays.asList(summary).subList(6 * i, 5 + 6 * i + 1));
            map.put(namesOfDim[i], sub);
        }
        s.end();

        return map;
    }

    public void getRawFile() throws REXPMismatchException{
        Rsession s = Rsession.newInstanceTry(System.out, null);

    }
}
