package org.asb.mule.probe.framework.util.corba;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.util.FileLogger;
import org.asb.mule.probe.framework.util.ProbeLog;
import org.omg.CORBA.Policy;
import org.omg.PortableServer.IdAssignmentPolicyValue;
import org.omg.PortableServer.IdUniquenessPolicyValue;
import org.omg.PortableServer.ImplicitActivationPolicyValue;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAManager;
import org.omg.PortableServer.RequestProcessingPolicyValue;
import org.omg.PortableServer.ServantRetentionPolicyValue;
import org.omg.PortableServer.ThreadPolicyValue;
import org.omg.PortableServer.POAPackage.AdapterNonExistent;

public class CorbaMgr implements Runnable {
	// private Logger sbilog = ProbeLog.getInstance().getSbiLog();
	private FileLogger sbilog = null;
	private static CorbaMgr instance = null;
	private org.omg.CORBA.ORB orb = null;
	private org.omg.PortableServer.POA rootPOA = null;
	private org.omg.PortableServer.POAManager manager = null;
	private boolean init = false;

	public CorbaMgr() {
	}

	public static CorbaMgr instance() {
		if (instance == null) {
			instance = new CorbaMgr();
		}

		return instance;
	}

	public boolean isInitialise() {
		return init;
	}

	public void initORB(String dns, String ip, FileLogger sbilog) {
		if (init)
			return;
		this.sbilog = sbilog;
		try {

			Properties props = System.getProperties();
			// if(adapter.jacorb != null && adapter.jacorb.trim().length() > 0){
			// FileReader reader = new FileReader(adapter.jacorb);
			// props.load(reader);
			// reader.close();
			// }

			props.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
			props.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
			// props.put("ORBInitRef.NameService", ip);
			// 确定本地ORB是以ip还是主机名发布(jacorb.dns.enable,jacorb.ior_proxy_host,jacorb.ior_proxy_port)
			props.put("jacorb.dns.enable", dns);// on-主机名，off-ip
			props.put("jacorb.ior_proxy_host", ip);

			// 指定本机接收服务器告警通知的IP与端口
			// props.put("OAIAddr", localIP);
			// props.put("OAPort", localPort);
			// props.put("org.omg.CORBA.ORBInitialHost", "CVT070424");
			// props.put("org.omg.CORBA.ORBInitialPort", "4714");

			orb = org.omg.CORBA.ORB.init(new String[0], props);
			rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			manager = rootPOA.the_POAManager();
			init = true;
		} catch (org.omg.CORBA.SystemException se) {
			orb = null;
			sbilog.error("CorbaMgr::initORB()>>	org.omg.CORBA.SystemException:" + se.toString());
			se.printStackTrace();
			init = false;
		} catch (Exception e) {
			sbilog.error("CorbaMgr::initORB()>>	Exception :" + e.toString());
			init = false;
		}
	}

	public void run() {
		try {
			manager.activate();
			orb.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		orb.destroy();
		init = false;
	}

	public org.omg.CORBA.ORB ORB() {
		return orb;
	}

	public org.omg.PortableServer.POA POA() {
		return rootPOA;
	}

	public POA createNmsSessionPOA(String name) {

		POAManager manager = rootPOA.the_POAManager();
		Policy[] policies = new org.omg.CORBA.Policy[7];

		policies[0] = rootPOA.create_thread_policy(ThreadPolicyValue.ORB_CTRL_MODEL);
		policies[1] = rootPOA.create_lifespan_policy(LifespanPolicyValue.TRANSIENT);
		policies[2] = rootPOA.create_id_uniqueness_policy(IdUniquenessPolicyValue.UNIQUE_ID);
		policies[3] = rootPOA.create_id_assignment_policy(IdAssignmentPolicyValue.SYSTEM_ID);
		policies[4] = rootPOA.create_implicit_activation_policy(ImplicitActivationPolicyValue.IMPLICIT_ACTIVATION);
		policies[5] = rootPOA.create_servant_retention_policy(ServantRetentionPolicyValue.RETAIN);
		policies[6] = rootPOA.create_request_processing_policy(RequestProcessingPolicyValue.USE_ACTIVE_OBJECT_MAP_ONLY);

		POA poa = null;

		try {
			poa = rootPOA.create_POA(name + "NmsSession", manager, policies);
		} catch (Exception ex) {
			sbilog.info("createNmsSessionPOA>>	Exception: Create Ems(" + name + ") NmsSession POA failed! " + ex);

			if (ex.getMessage().equals("IDL:omg.org/PortableServer/POA/AdapterAlreadyExists:1.0")) {
				try {
					poa = rootPOA.find_POA(name + "NmsSession", true);
				} catch (AdapterNonExistent e) {
					sbilog.error("createNmsSessionPOA>>	Ems(" + name + ") NmsSession POA is AlreadyExists.But cannot find it!");
					e.printStackTrace();
					poa = null;
				} catch (Throwable th) {
					sbilog.error("createNmsSessionPOA>>	Create Ems(" + name + ") NmsSession POA failed! " + ex);
					ex.printStackTrace();
					poa = null;

				}
			} else {
				poa = null;
			}
		}

		if (poa != null) {
			sbilog.info("createNmsSessionPOA>>	Create Ems(" + name + ") NmsSession POA is OK! ");
			sbilog.info("createNmsSessionPOA>>	The poa is " + poa.the_name());
			return poa;
		}

		// 创建备用poa
		try {
			poa = rootPOA.create_POA(name + "NmsSession" + "-bak", manager, policies);
			sbilog.info("createNmsSessionPOA>>	The poa is " + poa.the_name());
		} catch (Throwable ex) {
			sbilog.error("createNmsSessionPOA>>	Create Ems(" + name + ") NmsSession POA(in bak mode) failed! " + ex);
			ex.printStackTrace();

			if (ex.getMessage().equals("IDL:omg.org/PortableServer/POA/AdapterAlreadyExists:1.0")) {
				try {
					poa = rootPOA.find_POA(name + "NmsSession" + "-bak", true);
					sbilog.info("createNmsSessionPOA>>	The poa is " + poa.the_name());
				} catch (AdapterNonExistent e) {
					sbilog.error("createNmsSessionPOA>>	Ems(" + name + ") NmsSession POA" + "-bak" + "is AlreadyExists.But cannot find it!");
					e.printStackTrace();
					poa = null;
				}
			}

		}
		sbilog.info("createNmsSessionPOA>>	end...");
		return poa;
	}
}
