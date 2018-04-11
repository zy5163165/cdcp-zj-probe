package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;


@Entity
@Table(name = "C_TASK")

public final class C_TASK extends BObject
{
	private String jobName = "";
	private String objectType = "";
	private String objectName = "";	
	private boolean taskState;//0:success  1:fail
	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return the objectType
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	/**
	 * @return the taskState
	 */
	public boolean isTaskState() {
		return taskState;
	}
	/**
	 * @param taskState the taskState to set
	 */
	public void setTaskState(boolean taskState) {
		this.taskState = taskState;
	}
	
}
