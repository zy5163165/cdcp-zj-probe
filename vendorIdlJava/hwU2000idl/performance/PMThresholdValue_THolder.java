package performance;

/**
 *	Generated from IDL definition of struct "PMThresholdValue_T"
 *	@author JacORB IDL compiler 
 */

public final class PMThresholdValue_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public performance.PMThresholdValue_T value;

	public PMThresholdValue_THolder ()
	{
	}
	public PMThresholdValue_THolder(final performance.PMThresholdValue_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return performance.PMThresholdValue_THelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = performance.PMThresholdValue_THelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		performance.PMThresholdValue_THelper.write(_out, value);
	}
}
