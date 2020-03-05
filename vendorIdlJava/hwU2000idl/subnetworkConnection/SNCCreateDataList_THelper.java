package subnetworkConnection;

/**
 *	Generated from IDL definition of alias "SNCCreateDataList_T"
 *	@author JacORB IDL compiler 
 */

public final class SNCCreateDataList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, subnetworkConnection.SNCCreateData_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static subnetworkConnection.SNCCreateData_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(subnetworkConnection.SNCCreateDataList_THelper.id(), "SNCCreateDataList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, subnetworkConnection.SNCCreateData_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/subnetworkConnection/SNCCreateDataList_T:1.0";
	}
	public static subnetworkConnection.SNCCreateData_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		subnetworkConnection.SNCCreateData_T[] _result;
		int _l_result133 = _in.read_long();
		_result = new subnetworkConnection.SNCCreateData_T[_l_result133];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=subnetworkConnection.SNCCreateData_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, subnetworkConnection.SNCCreateData_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			subnetworkConnection.SNCCreateData_THelper.write(_out,_s[i]);
		}

	}
}
