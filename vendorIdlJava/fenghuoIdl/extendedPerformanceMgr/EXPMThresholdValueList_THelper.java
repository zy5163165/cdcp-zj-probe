package extendedPerformanceMgr;

/**
 *	Generated from IDL definition of alias "EXPMThresholdValueList_T"
 *	@author JacORB IDL compiler 
 */

public final class EXPMThresholdValueList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, extendedPerformanceMgr.EXPMThresholdValue_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static extendedPerformanceMgr.EXPMThresholdValue_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(extendedPerformanceMgr.EXPMThresholdValueList_THelper.id(), "EXPMThresholdValueList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, extendedPerformanceMgr.EXPMThresholdValue_THelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org.fiberhome.extended/extendedPerformanceMgr/EXPMThresholdValueList_T:1.0";
	}
	public static extendedPerformanceMgr.EXPMThresholdValue_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		extendedPerformanceMgr.EXPMThresholdValue_T[] _result;
		int _l_result61 = _in.read_long();
		_result = new extendedPerformanceMgr.EXPMThresholdValue_T[_l_result61];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=extendedPerformanceMgr.EXPMThresholdValue_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, extendedPerformanceMgr.EXPMThresholdValue_T[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			extendedPerformanceMgr.EXPMThresholdValue_THelper.write(_out,_s[i]);
		}

	}
}
