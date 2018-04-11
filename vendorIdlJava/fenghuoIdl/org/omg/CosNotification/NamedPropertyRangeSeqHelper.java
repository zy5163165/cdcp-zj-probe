package org.omg.CosNotification;

/**
 *	Generated from IDL definition of alias "NamedPropertyRangeSeq"
 *	@author JacORB IDL compiler 
 */

public final class NamedPropertyRangeSeqHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, org.omg.CosNotification.NamedPropertyRange[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static org.omg.CosNotification.NamedPropertyRange[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.omg.CosNotification.NamedPropertyRangeSeqHelper.id(), "NamedPropertyRangeSeq",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CosNotification.NamedPropertyRangeHelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:omg.org/CosNotification/NamedPropertyRangeSeq:1.0";
	}
	public static org.omg.CosNotification.NamedPropertyRange[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		org.omg.CosNotification.NamedPropertyRange[] _result;
		int _l_result15 = _in.read_long();
		_result = new org.omg.CosNotification.NamedPropertyRange[_l_result15];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=org.omg.CosNotification.NamedPropertyRangeHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, org.omg.CosNotification.NamedPropertyRange[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			org.omg.CosNotification.NamedPropertyRangeHelper.write(_out,_s[i]);
		}

	}
}
