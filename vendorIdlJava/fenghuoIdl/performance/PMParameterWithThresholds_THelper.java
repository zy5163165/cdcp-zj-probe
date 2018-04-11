package performance;


/**
 *	Generated from IDL definition of struct "PMParameterWithThresholds_T"
 *	@author JacORB IDL compiler 
 */

public final class PMParameterWithThresholds_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc( performance.PMParameterWithThresholds_THelper.id(),"PMParameterWithThresholds_T",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("pmParameterName", performance.PMParameterName_THelper.type(), null),new org.omg.CORBA.StructMember("pmThresholdList", performance.PMThresholdList_THelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final performance.PMParameterWithThresholds_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static performance.PMParameterWithThresholds_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/performance/PMParameterWithThresholds_T:1.0";
	}
	public static performance.PMParameterWithThresholds_T read (final org.omg.CORBA.portable.InputStream in)
	{
		performance.PMParameterWithThresholds_T result = new performance.PMParameterWithThresholds_T();
		result.pmParameterName = performance.PMParameterName_THelper.read(in);
		result.pmThresholdList = performance.PMThresholdList_THelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final performance.PMParameterWithThresholds_T s)
	{
		performance.PMParameterName_THelper.write(out,s.pmParameterName);
		performance.PMThresholdList_THelper.write(out,s.pmThresholdList);
	}
}
