package callSNC;

/**
 *	Generated from IDL definition of alias "DiversityInfoList_T"
 *	@author JacORB IDL compiler 
 */

public final class DiversityInfoList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, callSNC.DiversityInfo_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static callSNC.DiversityInfo_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(callSNC.DiversityInfoList_THelper.id(), "DiversityInfoList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, callSNC.DiversityInfo_THelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/callSNC/DiversityInfoList_T:1.0";
	}
	public static callSNC.DiversityInfo_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		callSNC.DiversityInfo_T[] _result;
		int _l_result4 = _in.read_long();
		_result = new callSNC.DiversityInfo_T[_l_result4];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=callSNC.DiversityInfo_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, callSNC.DiversityInfo_T[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			callSNC.DiversityInfo_THelper.write(_out,_s[i]);
		}

	}
}
