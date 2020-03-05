package subnetworkConnection;

/**
 *	Generated from IDL definition of struct "SubnetworkConnection_T"
 *	@author JacORB IDL compiler 
 */

public final class SubnetworkConnection_T
	implements org.omg.CORBA.portable.IDLEntity
{
	public SubnetworkConnection_T(){}
	public globaldefs.NameAndStringValue_T[] name;
	public java.lang.String userLabel = "";
	public java.lang.String nativeEMSName = "";
	public java.lang.String owner = "";
	public subnetworkConnection.SNCState_T sncState;
	public globaldefs.ConnectionDirection_T direction;
	public short rate;
	public subnetworkConnection.StaticProtectionLevel_T staticProtectionLevel;
	public subnetworkConnection.SNCType_T sncType;
	public subnetworkConnection.TPData_T[] aEnd;
	public subnetworkConnection.TPData_T[] zEnd;
	public subnetworkConnection.Reroute_T rerouteAllowed;
	public subnetworkConnection.NetworkRouted_T networkRouted;
	public globaldefs.NameAndStringValue_T[] additionalInfo;
	public SubnetworkConnection_T(globaldefs.NameAndStringValue_T[] name, java.lang.String userLabel, java.lang.String nativeEMSName, java.lang.String owner, subnetworkConnection.SNCState_T sncState, globaldefs.ConnectionDirection_T direction, short rate, subnetworkConnection.StaticProtectionLevel_T staticProtectionLevel, subnetworkConnection.SNCType_T sncType, subnetworkConnection.TPData_T[] aEnd, subnetworkConnection.TPData_T[] zEnd, subnetworkConnection.Reroute_T rerouteAllowed, subnetworkConnection.NetworkRouted_T networkRouted, globaldefs.NameAndStringValue_T[] additionalInfo)
	{
		this.name = name;
		this.userLabel = userLabel;
		this.nativeEMSName = nativeEMSName;
		this.owner = owner;
		this.sncState = sncState;
		this.direction = direction;
		this.rate = rate;
		this.staticProtectionLevel = staticProtectionLevel;
		this.sncType = sncType;
		this.aEnd = aEnd;
		this.zEnd = zEnd;
		this.rerouteAllowed = rerouteAllowed;
		this.networkRouted = networkRouted;
		this.additionalInfo = additionalInfo;
	}
	public String toString()
	{
		StringBuffer textStruct = new StringBuffer();
		textStruct.append("SubnetworkConnection_T");
		textStruct.append("(");
		textStruct.append("name=");
		textStruct.append("[");
		for(int mem0 =0; mem0 <name.length; mem0++){
			textStruct.append(name[mem0]);
			if(mem0 < name.length-1)
				textStruct.append(",");
		}
		textStruct.append("]");
		textStruct.append(","); 
		textStruct.append("userLabel=");
		textStruct.append(userLabel);
		textStruct.append(","); 
		textStruct.append("nativeEMSName=");
		textStruct.append(nativeEMSName);
		textStruct.append(","); 
		textStruct.append("owner=");
		textStruct.append(owner);
		textStruct.append(","); 
		textStruct.append("sncState=");
		textStruct.append(sncState);
		textStruct.append(","); 
		textStruct.append("direction=");
		textStruct.append(direction);
		textStruct.append(","); 
		textStruct.append("rate=");
		textStruct.append(rate);
		textStruct.append(","); 
		textStruct.append("staticProtectionLevel=");
		textStruct.append(staticProtectionLevel);
		textStruct.append(","); 
		textStruct.append("sncType=");
		textStruct.append(sncType);
		textStruct.append(","); 
		textStruct.append("aEnd=");
		textStruct.append("[");
		for(int mem9 =0; mem9 <aEnd.length; mem9++){
			textStruct.append(aEnd[mem9]);
			if(mem9 < aEnd.length-1)
				textStruct.append(",");
		}
		textStruct.append("]");
		textStruct.append(","); 
		textStruct.append("zEnd=");
		textStruct.append("[");
		for(int mem10 =0; mem10 <zEnd.length; mem10++){
			textStruct.append(zEnd[mem10]);
			if(mem10 < zEnd.length-1)
				textStruct.append(",");
		}
		textStruct.append("]");
		textStruct.append(","); 
		textStruct.append("rerouteAllowed=");
		textStruct.append(rerouteAllowed);
		textStruct.append(","); 
		textStruct.append("networkRouted=");
		textStruct.append(networkRouted);
		textStruct.append(","); 
		textStruct.append("additionalInfo=");
		textStruct.append("[");
		for(int mem13 =0; mem13 <additionalInfo.length; mem13++){
			textStruct.append(additionalInfo[mem13]);
			if(mem13 < additionalInfo.length-1)
				textStruct.append(",");
		}
		textStruct.append("]");
		textStruct.append(")");
		return textStruct.toString();
	}
}
