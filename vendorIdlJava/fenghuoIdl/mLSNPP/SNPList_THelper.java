package mLSNPP;

/**
 *	Generated from IDL definition of alias "SNPList_T"
 *	@author JacORB IDL compiler 
 */

public final class SNPList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, mLSNPP.SNP_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static mLSNPP.SNP_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(mLSNPP.SNPList_THelper.id(), "SNPList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, mLSNPP.SNP_THelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/mLSNPP/SNPList_T:1.0";
	}
	public static mLSNPP.SNP_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		mLSNPP.SNP_T[] _result;
		int _l_result94 = _in.read_long();
		_result = new mLSNPP.SNP_T[_l_result94];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=mLSNPP.SNP_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, mLSNPP.SNP_T[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			mLSNPP.SNP_THelper.write(_out,_s[i]);
		}

	}
}
