package subnetworkConnection;
/**
 *	Generated from IDL definition of enum "Reroute_T"
 *	@author JacORB IDL compiler 
 */

public final class Reroute_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public Reroute_T value;

	public Reroute_THolder ()
	{
	}
	public Reroute_THolder (final Reroute_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return Reroute_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = Reroute_THelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		Reroute_THelper.write (out,value);
	}
}
