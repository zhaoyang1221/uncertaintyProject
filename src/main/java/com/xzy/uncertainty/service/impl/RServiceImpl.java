package com.xzy.uncertainty.service.impl;


import com.xzy.uncertainty.service.IRService;
import org.apache.ibatis.io.Resources;
import org.math.R.Rsession;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

import static org.math.R.Rsession.cast;

/**
 * @author Administrator on 2016/11/21 0021.
 */
@Service
public class RServiceImpl implements IRService{
    public List getDimensionSummary() throws REXPMismatchException {
        Rsession s = Rsession.newInstanceTry(System.out, null);
        s.sendFile(new File("E:\\visualization\\IdeaProjects\\uncertaintyProject\\src\\main\\resources\\dataset\\Kobe_Bryant.csv"));
        s.eval("Kobe <- read.csv(\"Kobe_Bryant.csv\")");
        s.eval("myvars <- c(\"G\", \"MP\", \"FG\", \"FGA\", \"X3P\", \"X3PA\", \"FT\", \"FTA\", \"ORB\", \"DRB\", \"AST\", \"STL\", \"BLK\", \"TOV\", \"PF\", \"PTS\")");
        s.eval("Kobe <- Kobe[myvars]");
        String dimensionSummary = s.eval("summary(Kobe)").asString();
        if (!s.isPackageInstalled("Hmisc", "4.0")) {
            s.installPackage("Hmisc", true);
        }
        if (!s.isPackageLoaded("Hmisc")) {
            s.loadPackage("Hmisc");
        }
        List describeByKobe = s.eval("describe(Kobe)").asList();
//        s.eval("sdOfKobe <- apply(Kobe, 2, sd)");
//        s.eval("uncertaintyFunc1 <- function(x){\n" +
//                "  return(sum(x))\n" +
//                "}");
//        Double uncertaintyOfKobe = (Double) (cast(s.eval("uncertaintyFunc1(sdOfKobe)")));

        return describeByKobe;
    }
}
