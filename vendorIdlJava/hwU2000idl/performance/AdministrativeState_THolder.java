package performance;
/**
 *	Generated from IDL definition of enum "AdministrativeState_T"
 *	@author JacORB IDL compiler 
 */

public final class AdministrativeState_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public AdministrativeState_T value;

	public AdministrativeState_THolder ()
	{
	}
	public AdministrativeState_THolder (final AdministrativeState_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return AdministrativeState_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = AdministrativeState_THelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		AdministrativeState_THelper.write (out,value);
	}
}
