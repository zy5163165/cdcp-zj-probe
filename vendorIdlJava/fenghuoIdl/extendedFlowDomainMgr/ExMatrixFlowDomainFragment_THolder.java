package extendedFlowDomainMgr;

/**
 *	Generated from IDL definition of struct "ExMatrixFlowDomainFragment_T"
 *	@author JacORB IDL compiler 
 */

public final class ExMatrixFlowDomainFragment_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public extendedFlowDomainMgr.ExMatrixFlowDomainFragment_T value;

	public ExMatrixFlowDomainFragment_THolder ()
	{
	}
	public ExMatrixFlowDomainFragment_THolder (final extendedFlowDomainMgr.ExMatrixFlowDomainFragment_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return extendedFlowDomainMgr.ExMatrixFlowDomainFragment_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream _in)
	{
		value = extendedFlowDomainMgr.ExMatrixFlowDomainFragment_THelper.read (_in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		extendedFlowDomainMgr.ExMatrixFlowDomainFragment_THelper.write (_out,value);
	}
	public String toString()
	{
		if(null != value)
			return value.toString();
		return "Holder contains no value";
	}
}
