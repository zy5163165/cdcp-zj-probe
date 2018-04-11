package HW_mstpInventory;

/**
 *	Generated from IDL definition of alias "HW_FlowList_T"
 *	@author JacORB IDL compiler 
 */

public final class HW_FlowList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, HW_mstpInventory.HW_Flow_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static HW_mstpInventory.HW_Flow_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(HW_mstpInventory.HW_FlowList_THelper.id(), "HW_FlowList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, HW_mstpInventory.HW_Flow_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.huawei.com/HW_mstpInventory/HW_FlowList_T:1.0";
	}
	public static HW_mstpInventory.HW_Flow_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		HW_mstpInventory.HW_Flow_T[] _result;
		int _l_result53 = _in.read_long();
		_result = new HW_mstpInventory.HW_Flow_T[_l_result53];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=HW_mstpInventory.HW_Flow_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, HW_mstpInventory.HW_Flow_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			HW_mstpInventory.HW_Flow_THelper.write(_out,_s[i]);
		}

	}
}
