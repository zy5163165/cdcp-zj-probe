package callSNC;

/**
 *	Generated from IDL definition of alias "ConnectionsAndSupportingSNCsList_T"
 *	@author JacORB IDL compiler 
 */

public final class ConnectionsAndSupportingSNCsList_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public callSNC.ConnectionAndSupportingSNCs_T[] value;

	public ConnectionsAndSupportingSNCsList_THolder ()
	{
	}
	public ConnectionsAndSupportingSNCsList_THolder (final callSNC.ConnectionAndSupportingSNCs_T[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return ConnectionsAndSupportingSNCsList_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = ConnectionsAndSupportingSNCsList_THelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		ConnectionsAndSupportingSNCsList_THelper.write (out,value);
	}
}
