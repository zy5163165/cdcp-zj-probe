package performance;

/**
 *	Generated from IDL interface "PMDataIterator_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public final class PMDataIterator_IHolder	implements org.omg.CORBA.portable.Streamable{
	 public PMDataIterator_I value;
	public PMDataIterator_IHolder()
	{
	}
	public PMDataIterator_IHolder (final PMDataIterator_I initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return PMDataIterator_IHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = PMDataIterator_IHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		PMDataIterator_IHelper.write (_out,value);
	}
}
