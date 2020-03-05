package org.omg.CosTrading;

/**
 *	Generated from IDL definition of alias "LinkNameSeq"
 *	@author JacORB IDL compiler 
 */

public final class LinkNameSeqHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, java.lang.String[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static java.lang.String[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.omg.CosTrading.LinkNameSeqHelper.id(), "LinkNameSeq",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CosTrading.LinkNameHelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:omg.org/CosTrading/LinkNameSeq:1.0";
	}
	public static java.lang.String[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		java.lang.String[] _result;
		int _l_result32 = _in.read_long();
		_result = new java.lang.String[_l_result32];
		for(int i=0;i<_result.length;i++)
		{
			_result[i] = org.omg.CosTrading.LinkNameHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, java.lang.String[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			org.omg.CosTrading.LinkNameHelper.write(_out,_s[i]);
		}

	}
}
