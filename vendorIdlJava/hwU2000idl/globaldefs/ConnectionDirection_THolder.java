package globaldefs;
/**
 *	Generated from IDL definition of enum "ConnectionDirection_T"
 *	@author JacORB IDL compiler 
 */

public final class ConnectionDirection_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public ConnectionDirection_T value;

	public ConnectionDirection_THolder ()
	{
	}
	public ConnectionDirection_THolder (final ConnectionDirection_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return ConnectionDirection_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = ConnectionDirection_THelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		ConnectionDirection_THelper.write (out,value);
	}
}
