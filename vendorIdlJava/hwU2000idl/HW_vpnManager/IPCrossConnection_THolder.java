package HW_vpnManager;

/**
 *	Generated from IDL definition of struct "IPCrossConnection_T"
 *	@author JacORB IDL compiler 
 */

public final class IPCrossConnection_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public HW_vpnManager.IPCrossConnection_T value;

	public IPCrossConnection_THolder ()
	{
	}
	public IPCrossConnection_THolder(final HW_vpnManager.IPCrossConnection_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return HW_vpnManager.IPCrossConnection_THelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = HW_vpnManager.IPCrossConnection_THelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		HW_vpnManager.IPCrossConnection_THelper.write(_out, value);
	}
}
