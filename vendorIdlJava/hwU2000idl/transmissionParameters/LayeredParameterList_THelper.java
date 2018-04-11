package transmissionParameters;

/**
 *	Generated from IDL definition of alias "LayeredParameterList_T"
 *	@author JacORB IDL compiler 
 */

public final class LayeredParameterList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, transmissionParameters.LayeredParameters_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static transmissionParameters.LayeredParameters_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(transmissionParameters.LayeredParameterList_THelper.id(), "LayeredParameterList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, transmissionParameters.LayeredParameters_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/transmissionParameters/LayeredParameterList_T:1.0";
	}
	public static transmissionParameters.LayeredParameters_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		transmissionParameters.LayeredParameters_T[] _result;
		int _l_result148 = _in.read_long();
		_result = new transmissionParameters.LayeredParameters_T[_l_result148];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=transmissionParameters.LayeredParameters_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, transmissionParameters.LayeredParameters_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			transmissionParameters.LayeredParameters_THelper.write(_out,_s[i]);
		}

	}
}
