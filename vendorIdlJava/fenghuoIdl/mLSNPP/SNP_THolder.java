package mLSNPP;

/**
 *	Generated from IDL definition of struct "SNP_T"
 *	@author JacORB IDL compiler 
 */

public final class SNP_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public mLSNPP.SNP_T value;

	public SNP_THolder ()
	{
	}
	public SNP_THolder (final mLSNPP.SNP_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return mLSNPP.SNP_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream _in)
	{
		value = mLSNPP.SNP_THelper.read (_in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		mLSNPP.SNP_THelper.write (_out,value);
	}
	public String toString()
	{
		if(null != value)
			return value.toString();
		return "Holder contains no value";
	}
}
