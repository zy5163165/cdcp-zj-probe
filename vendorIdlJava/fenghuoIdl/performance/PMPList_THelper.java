package performance;

/**
 *	Generated from IDL definition of alias "PMPList_T"
 *	@author JacORB IDL compiler 
 */

public final class PMPList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, performance.PMP_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static performance.PMP_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(performance.PMPList_THelper.id(), "PMPList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, performance.PMP_THelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/performance/PMPList_T:1.0";
	}
	public static performance.PMP_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		performance.PMP_T[] _result;
		int _l_result129 = _in.read_long();
		_result = new performance.PMP_T[_l_result129];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=performance.PMP_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, performance.PMP_T[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			performance.PMP_THelper.write(_out,_s[i]);
		}

	}
}
