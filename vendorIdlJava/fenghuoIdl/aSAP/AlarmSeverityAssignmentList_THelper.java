package aSAP;

/**
 *	Generated from IDL definition of alias "AlarmSeverityAssignmentList_T"
 *	@author JacORB IDL compiler 
 */

public final class AlarmSeverityAssignmentList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, aSAP.AlarmSeverityAssignment_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static aSAP.AlarmSeverityAssignment_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(aSAP.AlarmSeverityAssignmentList_THelper.id(), "AlarmSeverityAssignmentList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, aSAP.AlarmSeverityAssignment_THelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/aSAP/AlarmSeverityAssignmentList_T:1.0";
	}
	public static aSAP.AlarmSeverityAssignment_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		aSAP.AlarmSeverityAssignment_T[] _result;
		int _l_result0 = _in.read_long();
		_result = new aSAP.AlarmSeverityAssignment_T[_l_result0];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=aSAP.AlarmSeverityAssignment_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, aSAP.AlarmSeverityAssignment_T[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			aSAP.AlarmSeverityAssignment_THelper.write(_out,_s[i]);
		}

	}
}
