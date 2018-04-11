package notifications;
/**
 *	Generated from IDL definition of enum "PerceivedSeverity_T"
 *	@author JacORB IDL compiler 
 */

public final class PerceivedSeverity_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_enum_tc(notifications.PerceivedSeverity_THelper.id(),"PerceivedSeverity_T",new String[]{"PS_INDETERMINATE","PS_CRITICAL","PS_MAJOR","PS_MINOR","PS_WARNING","PS_CLEARED"});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final notifications.PerceivedSeverity_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static notifications.PerceivedSeverity_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/notifications/PerceivedSeverity_T:1.0";
	}
	public static PerceivedSeverity_T read (final org.omg.CORBA.portable.InputStream in)
	{
		return PerceivedSeverity_T.from_int(in.read_long());
	}

	public static void write (final org.omg.CORBA.portable.OutputStream out, final PerceivedSeverity_T s)
	{
		out.write_long(s.value());
	}
}
