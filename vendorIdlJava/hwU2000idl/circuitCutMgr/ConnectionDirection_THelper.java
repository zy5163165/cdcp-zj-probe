package circuitCutMgr;
/**
 *	Generated from IDL definition of enum "ConnectionDirection_T"
 *	@author JacORB IDL compiler 
 */

public final class ConnectionDirection_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_enum_tc(circuitCutMgr.ConnectionDirection_THelper.id(),"ConnectionDirection_T",new String[]{"CD_UNI","CD_BI"});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final circuitCutMgr.ConnectionDirection_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static circuitCutMgr.ConnectionDirection_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/circuitCutMgr/ConnectionDirection_T:1.0";
	}
	public static ConnectionDirection_T read (final org.omg.CORBA.portable.InputStream in)
	{
		return ConnectionDirection_T.from_int(in.read_long());
	}

	public static void write (final org.omg.CORBA.portable.OutputStream out, final ConnectionDirection_T s)
	{
		out.write_long(s.value());
	}
}
