package flowDomain;

/**
 *	Generated from IDL definition of struct "EthernetOAMPoint_T"
 *	@author JacORB IDL compiler 
 */

public final class EthernetOAMPoint_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public flowDomain.EthernetOAMPoint_T value;

	public EthernetOAMPoint_THolder ()
	{
	}
	public EthernetOAMPoint_THolder(final flowDomain.EthernetOAMPoint_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return flowDomain.EthernetOAMPoint_THelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = flowDomain.EthernetOAMPoint_THelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		flowDomain.EthernetOAMPoint_THelper.write(_out, value);
	}
}
