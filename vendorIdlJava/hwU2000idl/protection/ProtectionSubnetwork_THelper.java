package protection;


/**
 *	Generated from IDL definition of struct "ProtectionSubnetwork_T"
 *	@author JacORB IDL compiler 
 */

public final class ProtectionSubnetwork_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc(protection.ProtectionSubnetwork_THelper.id(),"ProtectionSubnetwork_T",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("name", globaldefs.NamingAttributes_THelper.type(), null),new org.omg.CORBA.StructMember("userLabel", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("nativeEMSName", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("owner", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("layerRate", transmissionParameters.LayerRate_THelper.type(), null),new org.omg.CORBA.StructMember("psnType", protection.ProtectionSubnetworkType_THelper.type(), null),new org.omg.CORBA.StructMember("neIDList", protection.NEIDSeq_THelper.type(), null),new org.omg.CORBA.StructMember("psnLinks", protection.ProtectionSubnetworkCircle_THelper.type(), null),new org.omg.CORBA.StructMember("additionalInfo", globaldefs.NVSList_THelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final protection.ProtectionSubnetwork_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static protection.ProtectionSubnetwork_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/protection/ProtectionSubnetwork_T:1.0";
	}
	public static protection.ProtectionSubnetwork_T read (final org.omg.CORBA.portable.InputStream in)
	{
		protection.ProtectionSubnetwork_T result = new protection.ProtectionSubnetwork_T();
		result.name = globaldefs.NVSList_THelper.read(in);
		result.userLabel=in.read_string();
		result.nativeEMSName=in.read_string();
		result.owner=in.read_string();
		result.layerRate=in.read_short();
		result.psnType=protection.ProtectionSubnetworkType_THelper.read(in);
		result.neIDList = protection.NEIDSeq_THelper.read(in);
		result.psnLinks = protection.ProtectionSubnetworkCircle_THelper.read(in);
		result.additionalInfo = globaldefs.NVSList_THelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final protection.ProtectionSubnetwork_T s)
	{
		globaldefs.NVSList_THelper.write(out,s.name);
		out.write_string(s.userLabel);
		out.write_string(s.nativeEMSName);
		out.write_string(s.owner);
		out.write_short(s.layerRate);
		protection.ProtectionSubnetworkType_THelper.write(out,s.psnType);
		protection.NEIDSeq_THelper.write(out,s.neIDList);
		protection.ProtectionSubnetworkCircle_THelper.write(out,s.psnLinks);
		globaldefs.NVSList_THelper.write(out,s.additionalInfo);
	}
}
