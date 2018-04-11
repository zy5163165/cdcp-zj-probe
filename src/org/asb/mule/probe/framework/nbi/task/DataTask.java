/**
 * 
 */
package org.asb.mule.probe.framework.nbi.task;

import java.util.Vector;

import org.asb.mule.probe.framework.entity.C_TASK;

import com.alcatelsbell.nms.valueobject.BObject;

/**
 * @author lingp
 *
 */
public interface DataTask {
    
	/**
	 * entry function
	 * @param task
	 */
	Vector<BObject> excute();
	
	
	
	void insertDate(Vector<BObject> dataList);
	
	void updateDate(Vector<BObject> dataList);
	
	void deleteDate(Vector<BObject> dataList);
	
	/**
	 * migrate task to record sqlite table C_TASK
	 * @param task
	 */
	void saveTask(C_TASK task);
}
