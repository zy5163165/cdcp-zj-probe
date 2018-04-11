package mLSNPP;


/**
 *	Generated from IDL definition of struct "SNPTNAData_T"
 *	@author JacORB IDL compiler 
 */

public final class SNPTNAData_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc( mLSNPP.SNPTNAData_THelper.id(),"SNPTNAData_T",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("sNPPId", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("layerRate", transmissionParameters.LayerRate_THelper.type(), null),new org.omg.CORBA.StructMember("rAId", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("sNPTNAPairList", mLSNPP.SNPTNAPairList_THelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final mLSNPP.SNPTNAData_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static mLSNPP.SNPTNAData_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/mLSNPP/SNPTNAData_T:1.0";
	}
	public static mLSNPP.SNPTNAData_T read (final org.omg.CORBA.portable.InputStream in)
	{
		mLSNPP.SNPTNAData_T result = new mLSNPP.SNPTNAData_T();
		result.sNPPId=in.read_string();
		result.layerRate=in.read_short();
		result.rAId=in.read_string();
		result.sNPTNAPairList = mLSNPP.SNPTNAPairList_THelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final mLSNPP.SNPTNAData_T s)
	{
		out.write_string(s.sNPPId);
		out.write_short(s.layerRate);
		out.write_string(s.rAId);
		mLSNPP.SNPTNAPairList_THelper.write(out,s.sNPTNAPairList);
	}
}
