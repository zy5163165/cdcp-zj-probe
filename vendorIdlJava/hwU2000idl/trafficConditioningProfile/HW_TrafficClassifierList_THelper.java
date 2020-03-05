package trafficConditioningProfile;

/**
 *	Generated from IDL definition of alias "HW_TrafficClassifierList_T"
 *	@author JacORB IDL compiler 
 */

public final class HW_TrafficClassifierList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, trafficConditioningProfile.HW_TrafficClassifier_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static trafficConditioningProfile.HW_TrafficClassifier_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(trafficConditioningProfile.HW_TrafficClassifierList_THelper.id(), "HW_TrafficClassifierList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, trafficConditioningProfile.HW_TrafficClassifier_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/trafficConditioningProfile/HW_TrafficClassifierList_T:1.0";
	}
	public static trafficConditioningProfile.HW_TrafficClassifier_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		trafficConditioningProfile.HW_TrafficClassifier_T[] _result;
		int _l_result139 = _in.read_long();
		_result = new trafficConditioningProfile.HW_TrafficClassifier_T[_l_result139];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=trafficConditioningProfile.HW_TrafficClassifier_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, trafficConditioningProfile.HW_TrafficClassifier_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			trafficConditioningProfile.HW_TrafficClassifier_THelper.write(_out,_s[i]);
		}

	}
}
