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
    public Map<String, ArrayList<String>> getDimensionSummary() throws REXPMismatchException {
        System.out.println(System.getProperty("user.dir"));
        Rsession s = Rsession.newInstanceTry(System.out, null);
        s.eval("getwd()");
//        s.sendFile(new File("E:\\visualization\\IdeaProjects\\uncertaintyProject\\src\\main\\R\\Kobe_Bryant.csv"));
//        s.sendFile(new File("D:\\zhaoyang\\Documents\\Workspace\\IdeaProjects\\uncertaintyProject\\src\\main\\R\\Kobe_Bryant.csv"));
        s.eval("Kobe <- read.csv(\"cars.csv\")");
        s.eval("myvars <- c(\"G\", \"MP\", \"FG\", \"FGA\", \"X3P\", \"X3PA\", \"FT\", \"FTA\", \"ORB\", \"DRB\", \"AST\", \"STL\", \"BLK\", \"TOV\", \"PF\", \"PTS\")");
        s.eval("Kobe <- Kobe[myvars]");
        String[] summary = s.eval("summary(Kobe)").asStrings();
        String[] namesOfDim = s.eval("names(Kobe)").asStrings();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < namesOfDim.length; i++) {
            ArrayList<String> sub = new ArrayList<String>();
            sub.addAll(Arrays.asList(summary).subList(6 * i, 5 + 6 * i + 1));
            map.put(namesOfDim[i], sub);
        }
        s.end();

//        Rsession s = Rsession.newInstanceTry(System.out, null);
//        s.eval("Kobe <- read.csv(\"cars.csv\")");
        return map;
    }

    public void getRawFile() throws REXPMismatchException{
        Rsession s = Rsession.newInstanceTry(System.out, null);

    }
}
