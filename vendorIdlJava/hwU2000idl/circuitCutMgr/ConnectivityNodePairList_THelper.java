package circuitCutMgr;

/**
 *	Generated from IDL definition of alias "ConnectivityNodePairList_T"
 *	@author JacORB IDL compiler 
 */

public final class ConnectivityNodePairList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, circuitCutMgr.ConnectivityNodePair_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static circuitCutMgr.ConnectivityNodePair_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(circuitCutMgr.ConnectivityNodePairList_THelper.id(), "ConnectivityNodePairList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, circuitCutMgr.ConnectivityNodePair_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/circuitCutMgr/ConnectivityNodePairList_T:1.0";
	}
	public static circuitCutMgr.ConnectivityNodePair_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		circuitCutMgr.ConnectivityNodePair_T[] _result;
		int _l_result12 = _in.read_long();
		_result = new circuitCutMgr.ConnectivityNodePair_T[_l_result12];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=circuitCutMgr.ConnectivityNodePair_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, circuitCutMgr.ConnectivityNodePair_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			circuitCutMgr.ConnectivityNodePair_THelper.write(_out,_s[i]);
		}

	}
}
