package terminationPoint;

/**
 *	Generated from IDL interface "TerminationPointIterator_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public final class TerminationPointIterator_IHolder	implements org.omg.CORBA.portable.Streamable{
	 public TerminationPointIterator_I value;
	public TerminationPointIterator_IHolder()
	{
	}
	public TerminationPointIterator_IHolder (final TerminationPointIterator_I initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return TerminationPointIterator_IHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = TerminationPointIterator_IHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		TerminationPointIterator_IHelper.write (_out,value);
	}
}
