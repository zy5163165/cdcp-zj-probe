package subnetworkConnection;


/**
 *	Generated from IDL definition of struct "WaveLengthStatus_T"
 *	@author JacORB IDL compiler 
 */

public final class WaveLengthStatus_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc(subnetworkConnection.WaveLengthStatus_THelper.id(),"WaveLengthStatus_T",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("frequency", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("used", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2)), null),new org.omg.CORBA.StructMember("unused", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2)), null),new org.omg.CORBA.StructMember("addtionalInfo", globaldefs.NamingAttributes_THelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final subnetworkConnection.WaveLengthStatus_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static subnetworkConnection.WaveLengthStatus_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/subnetworkConnection/WaveLengthStatus_T:1.0";
	}
	public static subnetworkConnection.WaveLengthStatus_T read (final org.omg.CORBA.portable.InputStream in)
	{
		subnetworkConnection.WaveLengthStatus_T result = new subnetworkConnection.WaveLengthStatus_T();
		result.frequency=in.read_string();
		result.used=in.read_short();
		result.unused=in.read_short();
		result.addtionalInfo = globaldefs.NVSList_THelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final subnetworkConnection.WaveLengthStatus_T s)
	{
		out.write_string(s.frequency);
		out.write_short(s.used);
		out.write_short(s.unused);
		globaldefs.NVSList_THelper.write(out,s.addtionalInfo);
	}
}
