package HW_mstpProtection;

/**
 *	Generated from IDL interface "HW_AtmProtectGroupIterator_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public final class HW_AtmProtectGroupIterator_IHolder	implements org.omg.CORBA.portable.Streamable{
	 public HW_AtmProtectGroupIterator_I value;
	public HW_AtmProtectGroupIterator_IHolder()
	{
	}
	public HW_AtmProtectGroupIterator_IHolder (final HW_AtmProtectGroupIterator_I initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return HW_AtmProtectGroupIterator_IHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = HW_AtmProtectGroupIterator_IHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		HW_AtmProtectGroupIterator_IHelper.write (_out,value);
	}
}
