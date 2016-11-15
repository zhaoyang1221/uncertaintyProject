package cn.edu.uncertainty;

import org.math.R.Rsession;
import org.rosuda.REngine.REXPMismatchException;


/**
 * @author Administrator on 2016/10/24 0024.
 */
public class RsessionBegin {
    public static void main(String args[]) throws REXPMismatchException {
        Rsession s = Rsession.newInstanceTry(System.out, null);
        // 执行R脚本
        String rand = s.eval("R.version.string").asString();
        System.out.println(rand);
        s.end();
    }
}
