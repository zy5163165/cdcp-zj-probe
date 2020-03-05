/**
 * 
 */
package org.asb.mule.probe.framework.nbi.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.entity.C_TASK;
import org.asb.mule.probe.framework.service.Constant;
import org.asb.mule.probe.framework.service.NbiService;
import org.asb.mule.probe.framework.service.SqliteConn;
import org.asb.mule.probe.framework.service.SqliteService;
import org.asb.mule.probe.framework.util.FileLogger;
import org.asb.mule.probe.framework.util.ProbeLog;

import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.db.components.service.JPASupport;
import com.alcatelsbell.nms.db.components.service.JPAUtil;

import com.alcatelsbell.nms.valueobject.BObject;

/**
 * @author lingp
 * 
 */
public abstract class CommonDataTask implements DataTask {

	// protected Logger nbilog = ProbeLog.getInstance().getNbiLog();
	protected FileLogger nbilog = null;
	protected NbiService service;
	protected C_TASK task;
	protected boolean option = false;
    private SqliteConn sqliteConn = null;

    public SqliteConn getSqliteConn() {
        return sqliteConn;
    }

    public void setSqliteConn(SqliteConn sqliteConn) {
        this.sqliteConn = sqliteConn;
    }

    public void CreateTask(NbiService service, String jobName, String dn, FileLogger nbilog) {

		this.service = service;
		this.task = new C_TASK();
		task.setJobName(jobName);
		task.setObjectName(dn);
		task.setObjectType(Constant.TaskType_Card);
		task.setTaskState(false);
		this.nbilog = nbilog;
	}

	public void CreateTask(NbiService service, String jobName, String dn, FileLogger nbilog, boolean option) {

		this.service = service;
		this.task = new C_TASK();
		task.setJobName(jobName);
		task.setObjectName(dn);
		task.setObjectType(Constant.TaskType_Card);
		task.setTaskState(false);
		this.nbilog = nbilog;
		this.option = option;
	}

	protected List<BObject> queryData(String sql) {
		List dbNeList = null;
		JPASupport sqliteJPASupport = SqliteService.getInstance().getJpaSupport();
        if (sqliteConn != null)
            sqliteJPASupport = sqliteConn.getJpaSupport();
		try {
			sqliteJPASupport.begin();

			dbNeList = JPAUtil.getInstance().findObjects(sqliteJPASupport, sql);
            sqliteJPASupport.end();
            sqliteJPASupport.release();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			return dbNeList;
		}
	}

	public void saveTask(C_TASK task) {
		task.setDn(SysUtil.nextDN());

		JPASupport sqliteJPASupport = SqliteService.getInstance().getJpaSupport();
        if (sqliteConn != null)
            sqliteJPASupport = sqliteConn.getJpaSupport();
		try {
			sqliteJPASupport.begin();
			JPAUtil.getInstance().createObject(sqliteJPASupport, -1, task);
            sqliteJPASupport.end();
            sqliteJPASupport.release();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

    public void insertToSqliteDB(BObject bo) {
        if (sqliteConn != null)
            sqliteConn.insertBObject(bo);
        else
            SqliteService.getInstance().insertBObject(bo);
    }

	public void setService(NbiService service) {
		this.service = service;
	}

	public NbiService getService() {
		return service;
	}

	/**
	 * @return the task
	 */
	public C_TASK getTask() {
		return task;
	}

}
