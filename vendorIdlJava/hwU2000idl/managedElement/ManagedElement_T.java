package managedElement;

/**
 *	Generated from IDL definition of struct "ManagedElement_T"
 *	@author JacORB IDL compiler 
 */

public final class ManagedElement_T
	implements org.omg.CORBA.portable.IDLEntity
{
	public ManagedElement_T(){}
	public globaldefs.NameAndStringValue_T[] name;
	public java.lang.String userLabel = "";
	public java.lang.String nativeEMSName = "";
	public java.lang.String owner = "";
	public java.lang.String location = "";
	public java.lang.String version = "";
	public java.lang.String productName = "";
	public managedElement.CommunicationState_T communicationState;
	public boolean emsInSyncState;
	public short[] supportedRates;
	public globaldefs.NameAndStringValue_T[] additionalInfo;
	public ManagedElement_T(globaldefs.NameAndStringValue_T[] name, java.lang.String userLabel, java.lang.String nativeEMSName, java.lang.String owner, java.lang.String location, java.lang.String version, java.lang.String productName, managedElement.CommunicationState_T communicationState, boolean emsInSyncState, short[] supportedRates, globaldefs.NameAndStringValue_T[] additionalInfo)
	{
		this.name = name;
		this.userLabel = userLabel;
		this.nativeEMSName = nativeEMSName;
		this.owner = owner;
		this.location = location;
		this.version = version;
		this.productName = productName;
		this.communicationState = communicationState;
		this.emsInSyncState = emsInSyncState;
		this.supportedRates = supportedRates;
		this.additionalInfo = additionalInfo;
	}
}
