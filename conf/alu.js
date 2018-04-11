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
        ems.setType("ALU");
        ems.setDn("ZJ-ALU-1-OTN");
        var adapter = nodeAdmin.getEmsAdapter(ems);
        var service = adapter.getConnectionManager().getConnection(ems.getDn()).getNbiService();

        var ccList = new ArrayList ();
        var sectionList = new ArrayList ();
        service.retrieveRouteAndTopologicalLinks("EMS:ZJ-ALU-1-OTN@MultiLayerSubnetwork:OTN@SubnetworkConnection:SNC_1689", ccList, sectionList);
        var map = new HashMap();
        map.put("cc",ccList);
        map.put("section",sectionList);
        return map;
    //    return service.retrieveAllCtps("EMS:ZJ-ALU-1-OTN@MultiLayerSubnetwork:OTN@SubnetworkConnection:SNC_1689",ccList,sectionList);






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
        ems.setType("ALU");
        ems.setDn("ZJ-ALU-1-OTN");
        return bean.getClass();
        //  var adapter = bean.getEmsAdapter(ems );
        var adapter = bean.obtain(ems,"node://"+ems.getDn()+"/EMS");
        return adapter;

    }catch (e) {
        return e;
    }

}


