/**
 * Created by Ronnie on 2014/12/9.
 */

/**
 * Created by IntelliJ IDEA.
 * User: Ronnie
 * Date: 12-1-8
 * Time: 下午6:58
 * To change this template use File | Settings | File Templates.
 */
importPackage(Packages.java.text);
importPackage(Packages.java.lang);
importPackage(Packages.java.util);
importPackage(Packages.javax.management);

print("abbc---------------------------------------------------------------------");
function execute() {
    try {
        var nodeAdmin = com.alcatelsbell.cdcp.nodefx.NodeContext.getNodeContext().getAttribute("NodeAdmin");
        var ems = new com.alcatelsbell.nms.valueobject.sys.Ems();
        ems.setType("ZTE");
        ems.setDn("TZ-OTNU31-1-P");
        var adapter = nodeAdmin.getEmsAdapter(ems);
        var service = adapter.getConnectionManager().getConnection(ems.getDn()).getNbiService();

        var ccList = new ArrayList ();
        var sectionList = new ArrayList ();
        var cctps = service.retrieveAllCtps("EMS:TZ-OTNU31-1-P@ManagedElement:70127685(P)@PTP:/direction=sink/rack=0/shelf=7/slot=24/port=78151693");
        var map = new HashMap();
        map.put("cc",ccList);
        map.put("section",sectionList);
        return cctps;
        //    ctps service.retrieveAllCtps("EMS:ZJ-ALU-1-OTN@MultiLayerSubnetwork:OTN@SubnetworkConnection:SNC_1689",ccList,sectionList);






    }catch (e) {
        return e;
    }


}

function getMBean() {
    try {
        var  mBeanServerList = MBeanServerFactory.findMBeanServer(null);
        var   mbeanServer =  mBeanServerList.get(0);

        on2 = new ObjectName("cdcp:name=NodeAdmin");
        var bean = mbeanServer.queryMBeans(on2,null).iterator().next();

        var ems = new com.alcatelsbell.nms.valueobject.sys.Ems();
        ems.setType("ZTE");
        ems.setDn("TZ-OTNU31-1-P");
        return bean.getClass();
        //  var adapter = bean.getEmsAdapter(ems );
        var adapter = bean.obtain(ems,"node://"+ems.getDn()+"/EMS");
        return adapter;

    }catch (e) {
        return e;
    }

}


