package HW_mstpInventory;

/**
 *	Generated from IDL definition of alias "HW_STCurrentPortList_T"
 *	@author JacORB IDL compiler 
 */

public final class HW_STCurrentPortList_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public HW_mstpInventory.HW_STCurrentPort_T[] value;

	public HW_STCurrentPortList_THolder ()
	{
	}
	public HW_STCurrentPortList_THolder (final HW_mstpInventory.HW_STCurrentPort_T[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return HW_STCurrentPortList_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = HW_STCurrentPortList_THelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		HW_STCurrentPortList_THelper.write (out,value);
	}
}
