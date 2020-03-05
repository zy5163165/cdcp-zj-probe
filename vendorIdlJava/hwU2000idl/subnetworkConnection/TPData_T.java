package subnetworkConnection;

/**
 *	Generated from IDL definition of struct "TPData_T"
 *	@author JacORB IDL compiler 
 */

public final class TPData_T
	implements org.omg.CORBA.portable.IDLEntity
{
	public TPData_T(){}
	public globaldefs.NameAndStringValue_T[] tpName;
	public terminationPoint.TerminationMode_T tpMappingMode;
	public transmissionParameters.LayeredParameters_T[] transmissionParams;
	public globaldefs.NameAndStringValue_T[] ingressTrafficDescriptorName;
	public globaldefs.NameAndStringValue_T[] egressTrafficDescriptorName;
	public TPData_T(globaldefs.NameAndStringValue_T[] tpName, terminationPoint.TerminationMode_T tpMappingMode, transmissionParameters.LayeredParameters_T[] transmissionParams, globaldefs.NameAndStringValue_T[] ingressTrafficDescriptorName, globaldefs.NameAndStringValue_T[] egressTrafficDescriptorName)
	{
		this.tpName = tpName;
		this.tpMappingMode = tpMappingMode;
		this.transmissionParams = transmissionParams;
		this.ingressTrafficDescriptorName = ingressTrafficDescriptorName;
		this.egressTrafficDescriptorName = egressTrafficDescriptorName;
	}
}
