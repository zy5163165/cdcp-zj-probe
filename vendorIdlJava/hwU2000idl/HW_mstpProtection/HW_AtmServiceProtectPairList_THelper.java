package HW_mstpProtection;

/**
 *	Generated from IDL definition of alias "HW_AtmServiceProtectPairList_T"
 *	@author JacORB IDL compiler 
 */

public final class HW_AtmServiceProtectPairList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, HW_mstpProtection.HW_AtmServiceProtectPair_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static HW_mstpProtection.HW_AtmServiceProtectPair_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(HW_mstpProtection.HW_AtmServiceProtectPairList_THelper.id(), "HW_AtmServiceProtectPairList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, HW_mstpProtection.HW_AtmServiceProtectPair_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.huawei.com/HW_mstpProtection/HW_AtmServiceProtectPairList_T:1.0";
	}
	public static HW_mstpProtection.HW_AtmServiceProtectPair_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		HW_mstpProtection.HW_AtmServiceProtectPair_T[] _result;
		int _l_result60 = _in.read_long();
		_result = new HW_mstpProtection.HW_AtmServiceProtectPair_T[_l_result60];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=HW_mstpProtection.HW_AtmServiceProtectPair_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, HW_mstpProtection.HW_AtmServiceProtectPair_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			HW_mstpProtection.HW_AtmServiceProtectPair_THelper.write(_out,_s[i]);
		}

	}
}
