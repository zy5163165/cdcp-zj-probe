package callSNC;

/**
 *	Generated from IDL definition of struct "Diversity_T"
 *	@author JacORB IDL compiler 
 */

public final class Diversity_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public callSNC.Diversity_T value;

	public Diversity_THolder ()
	{
	}
	public Diversity_THolder (final callSNC.Diversity_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return callSNC.Diversity_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream _in)
	{
		value = callSNC.Diversity_THelper.read (_in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		callSNC.Diversity_THelper.write (_out,value);
	}
	public String toString()
	{
		if(null != value)
			return value.toString();
		return "Holder contains no value";
	}
}
