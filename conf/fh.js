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
        ems.setType("FH");
        ems.setDn("SHX-OTNM2000-1-OTN");
        var adapter = nodeAdmin.getEmsAdapter(ems);
        var service = adapter.getConnectionManager().getConnection(ems.getDn()).getNbiService();



        var ccs = new java.util.ArrayList();
        return service.retrieveAllEquipmentHolders("EMS:SHX-OTNM2000-1-OTN@ManagedElement:134217737;66051");
       // ccs = service.retrieveRoute("EMS:SHX-OTNM2000-1-OTN@MultiLayerSubnetwork:1@SubnetworkConnection:504367802_520096571",ccs,true);
       //// ccs = service.retrieveAllExtCrossConnects("EMS:NB-OTNM2000-1-OTN@ManagedElement:134217729;65799");
       // return ccs.size()+"";



    }catch (e) {
       return e.toString();
    }


}


