package encapsulationLayerLink;
/**
 *	Generated from IDL definition of enum "BandwidthProvisioningMode_T"
 *	@author JacORB IDL compiler 
 */

public final class BandwidthProvisioningMode_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_enum_tc(encapsulationLayerLink.BandwidthProvisioningMode_THelper.id(),"BandwidthProvisioningMode_T",new String[]{"BP_NONE","BP_AUTOMATIC","BP_MANUAL","BP_BY_CALL"});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final encapsulationLayerLink.BandwidthProvisioningMode_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static encapsulationLayerLink.BandwidthProvisioningMode_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/encapsulationLayerLink/BandwidthProvisioningMode_T:1.0";
	}
	public static BandwidthProvisioningMode_T read (final org.omg.CORBA.portable.InputStream in)
	{
		return BandwidthProvisioningMode_T.from_int(in.read_long());
	}

	public static void write (final org.omg.CORBA.portable.OutputStream out, final BandwidthProvisioningMode_T s)
	{
		out.write_long(s.value());
	}
}
