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
	 * 1.��ȡ������Ԫ
	 * 
	 * @return
	 */
	List<ManagedElement> retrieveAllManagedElements();

	/**
	 * 2.��ȡĳ��Ԫ�����в���
	 * 
	 * @return
	 */
	List<Equipment> retrieveAllEquipments(String neName);

	/**
	 * 3.��ȡĳ��Ԫ�����мܿ��
	 * 
	 * @return
	 */
	List<EquipmentHolder> retrieveAllEquipmentHolders(String neName);

	void retrieveAllEquipmentAndHolders(String neName, List<EquipmentHolder> equipmentHolderList, List<Equipment> equipmentList);

	/**
	 * 4.��ȡĳ��Ԫ�����ж˿�
	 * 
	 * @return
	 */
	List<PTP> retrieveAllPtps(String neName);

	/**
	 * 5.��ȡĳ��Ԫ������CTP
	 * 
	 * @return
	 */

	public List<CTP> retrieveAllCtps(String ptpDn);

	/**
	 * 6.��ȡĳ��Ԫ������IP����
	 * 
	 * @return
	 */
	List<IPCrossconnection> retrieveAllCrossconnections(String neName);

	/**
	 * 7.��ȡems�������������Ӷ�
	 * 
	 * @return
	 */
	List<Section> retrieveAllSections();

	/**
	 * 8.��ȡems���������
	 * 
	 * @return
	 */
	List<TrafficTrunk> retrieveAllTrafficTrunk();

	/**
	 * 9.��ȡems������α��
	 * 
	 * @return
	 */
	List<FlowDomainFragment> retrieveAllFdrs();

	/**
	 * 10.��ȡ��ϸ·��
	 */
	List<IPCrossconnection> retrieveRoute(String trafficTrunkName);

	List<FlowDomain> retrieveAllFlowDomain();

	/**
	 * 11.��ȡFTP��PTP��ϵ
	 * 
	 */
	List<R_FTP_PTP> retrieveAllPTPsByFtp(String ftpName);

	/**
	 * 12.��ȡ������
	 * *
	 */
	List<ProtectionGroup> retrieveAllProtectionGroupByMe(String meDn);

	List<TrailNtwProtection> retrieveAllTrailNtwProtections();

	List<SubnetworkConnection> retrieveAllSNCs();

	void retrieveRouteAndTopologicalLinks(String sncName, List<CrossConnect> ccList, List<Section> sectionList);

	List<CrossConnect> retrieveAllCrossConnects(String neName);
}
