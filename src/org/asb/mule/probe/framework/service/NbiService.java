package org.asb.mule.probe.framework.service;

import java.util.List;

import javax.jws.WebService;

import org.asb.mule.probe.framework.entity.CTP;
import org.asb.mule.probe.framework.entity.CrossConnect;
import org.asb.mule.probe.framework.entity.Equipment;
import org.asb.mule.probe.framework.entity.EquipmentHolder;
import org.asb.mule.probe.framework.entity.FlowDomain;
import org.asb.mule.probe.framework.entity.FlowDomainFragment;
import org.asb.mule.probe.framework.entity.IPCrossconnection;
import org.asb.mule.probe.framework.entity.ManagedElement;
import org.asb.mule.probe.framework.entity.PTP;
import org.asb.mule.probe.framework.entity.ProtectionGroup;
import org.asb.mule.probe.framework.entity.R_FTP_PTP;
import org.asb.mule.probe.framework.entity.Section;
import org.asb.mule.probe.framework.entity.SubnetworkConnection;
import org.asb.mule.probe.framework.entity.TrafficTrunk;
import org.asb.mule.probe.framework.entity.TrailNtwProtection;

@WebService
public interface NbiService {

	String getServiceName();

	String getEmsName();

	boolean connect();

	boolean ping();

	boolean disconnect();

	boolean getConnectState();

	String getLastestDayMigrationJobName();
	
	ManagedElement retrieveManagedElement(String neName);

	/**
	 * 1.获取所有网元
	 * 
	 * @return
	 */
	List<ManagedElement> retrieveAllManagedElements();

	/**
	 * 2.获取某网元下所有插盘
	 * 
	 * @return
	 */
	List<Equipment> retrieveAllEquipments(String neName);

	/**
	 * 3.获取某网元下所有架框槽
	 * 
	 * @return
	 */
	List<EquipmentHolder> retrieveAllEquipmentHolders(String neName);

	void retrieveAllEquipmentAndHolders(String neName, List<EquipmentHolder> equipmentHolderList, List<Equipment> equipmentList);

	/**
	 * 4.获取某网元下所有端口
	 * 
	 * @return
	 */
	List<PTP> retrieveAllPtps(String neName);

	/**
	 * 5.获取某网元下所有CTP
	 * 
	 * @return
	 */

	public List<CTP> retrieveAllCtps(String ptpDn);

	/**
	 * 6.获取某网元下所有IP交叉
	 * 
	 * @return
	 */
	List<IPCrossconnection> retrieveAllCrossconnections(String neName);

	/**
	 * 7.获取ems下所有物理连接段
	 * 
	 * @return
	 */
	List<Section> retrieveAllSections();

	/**
	 * 8.获取ems下所有隧道
	 * 
	 * @return
	 */
	List<TrafficTrunk> retrieveAllTrafficTrunk();

	/**
	 * 9.获取ems下所有伪线
	 * 
	 * @return
	 */
	List<FlowDomainFragment> retrieveAllFdrs();

	/**
	 * 10.获取详细路由
	 */
	List<IPCrossconnection> retrieveRoute(String trafficTrunkName);

	List<FlowDomain> retrieveAllFlowDomain();

	/**
	 * 11.获取FTP和PTP关系
	 * 
	 */
	List<R_FTP_PTP> retrieveAllPTPsByFtp(String ftpName);

	/**
	 * 12.获取保护组
	 * *
	 */
	List<ProtectionGroup> retrieveAllProtectionGroupByMe(String meDn);

	List<TrailNtwProtection> retrieveAllTrailNtwProtections();

	List<SubnetworkConnection> retrieveAllSNCs();

	void retrieveRouteAndTopologicalLinks(String sncName, List<CrossConnect> ccList, List<Section> sectionList);

	List<CrossConnect> retrieveAllCrossConnects(String neName);
}
