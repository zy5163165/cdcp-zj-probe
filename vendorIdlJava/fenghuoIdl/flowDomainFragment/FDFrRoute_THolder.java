package flowDomainFragment;

/**
 *	Generated from IDL definition of alias "FDFrRoute_T"
 *	@author JacORB IDL compiler 
 */

public final class FDFrRoute_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public flowDomainFragment.MatrixFlowDomainFragment_T[] value;

	public FDFrRoute_THolder ()
	{
	}
	public FDFrRoute_THolder (final flowDomainFragment.MatrixFlowDomainFragment_T[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return FDFrRoute_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = FDFrRoute_THelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		FDFrRoute_THelper.write (out,value);
	}
}
