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
        var devicedn = "EMS:ZSH-U2000-1-P@ManagedElement:4063265";
        var nodeAdmin = com.alcatelsbell.cdcp.nodefx.NodeContext.getNodeContext().getAttribute("NodeAdmin");
        var ems = new com.alcatelsbell.nms.valueobject.sys.Ems();
        ems.setType("HWU2000");
        ems.setDn("ZSH-U2000-1-P");
        var adapter = nodeAdmin.getEmsAdapter(ems);
        var service = adapter.getConnectionManager().getConnection(ems.getDn()).getNbiService();

        var corbaService = service.getCorbaService();
        //corbaService.setCorbaUrl("");
        return corbaService.getCorbaUrl();


       // var holderList = new ArrayList ();
       // var cardList = new ArrayList ();
       // service.retrieveAllEquipmentAndHolders(devicedn, holderList, cardList);
       //
       // var map = new HashMap();
       // map.put("holder",holderList);
       // map.put("card",cardList);
       //return map;





    }catch (e) {

        return e.toString();
    }


}

function getMBean() {
    try {
        var  mBeanServerList = MBeanServerFactory.findMBeanServer(null);
        var   mbeanServer =  mBeanServerList.get(0);

        on2 = new ObjectName("cdcp:name=NodeAdmin");
        var bean = mbeanServer.queryMBeans(on2,null).iterator().next();

        var ems = new com.alcatelsbell.nms.valueobject.sys.Ems();
        ems.setType("HWU2000");
        ems.setDn("ZSH-U2000-1-P");
        return bean.getClass();
        //  var adapter = bean.getEmsAdapter(ems );
        var adapter = bean.obtain(ems,"node://ZSH-U2000-1-P/EMS");
        return adapter;

    }catch (e) {
        return e;
    }

}


