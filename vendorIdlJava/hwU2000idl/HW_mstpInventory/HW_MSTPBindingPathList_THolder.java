package HW_mstpInventory;

/**
 *	Generated from IDL definition of alias "HW_MSTPBindingPathList_T"
 *	@author JacORB IDL compiler 
 */

public final class HW_MSTPBindingPathList_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public HW_mstpInventory.HW_MSTPBindingPath_T[] value;

	public HW_MSTPBindingPathList_THolder ()
	{
	}
	public HW_MSTPBindingPathList_THolder (final HW_mstpInventory.HW_MSTPBindingPath_T[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return HW_MSTPBindingPathList_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = HW_MSTPBindingPathList_THelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		HW_MSTPBindingPathList_THelper.write (out,value);
	}
}
