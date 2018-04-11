package org.asb.mule.probe.framework.nbi.task;

/**
 * Author: Ronnie.Chen
 * Date: 13-6-18
 * Time: 上午9:47
 * rongrong.chen@alcatel-sbell.com.cn
 */
public interface TaskResultHandler {
    public void handleResult(DataTask task,Object result) throws Exception;
}
