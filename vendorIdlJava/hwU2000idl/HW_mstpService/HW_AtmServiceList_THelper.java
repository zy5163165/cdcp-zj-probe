package HW_mstpService;

/**
 *	Generated from IDL definition of alias "HW_AtmServiceList_T"
 *	@author JacORB IDL compiler 
 */

public final class HW_AtmServiceList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, HW_mstpService.HW_AtmService_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static HW_mstpService.HW_AtmService_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(HW_mstpService.HW_AtmServiceList_THelper.id(), "HW_AtmServiceList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, HW_mstpService.HW_AtmService_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.huawei.com/HW_mstpService/HW_AtmServiceList_T:1.0";
	}
	public static HW_mstpService.HW_AtmService_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		HW_mstpService.HW_AtmService_T[] _result;
		int _l_result69 = _in.read_long();
		_result = new HW_mstpService.HW_AtmService_T[_l_result69];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=HW_mstpService.HW_AtmService_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, HW_mstpService.HW_AtmService_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			HW_mstpService.HW_AtmService_THelper.write(_out,_s[i]);
		}

	}
}
