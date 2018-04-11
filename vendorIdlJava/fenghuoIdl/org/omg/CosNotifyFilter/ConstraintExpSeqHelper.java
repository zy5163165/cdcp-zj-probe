package org.omg.CosNotifyFilter;

/**
 *	Generated from IDL definition of alias "ConstraintExpSeq"
 *	@author JacORB IDL compiler 
 */

public final class ConstraintExpSeqHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, org.omg.CosNotifyFilter.ConstraintExp[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static org.omg.CosNotifyFilter.ConstraintExp[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.omg.CosNotifyFilter.ConstraintExpSeqHelper.id(), "ConstraintExpSeq",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CosNotifyFilter.ConstraintExpHelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:omg.org/CosNotifyFilter/ConstraintExpSeq:1.0";
	}
	public static org.omg.CosNotifyFilter.ConstraintExp[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		org.omg.CosNotifyFilter.ConstraintExp[] _result;
		int _l_result22 = _in.read_long();
		_result = new org.omg.CosNotifyFilter.ConstraintExp[_l_result22];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=org.omg.CosNotifyFilter.ConstraintExpHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, org.omg.CosNotifyFilter.ConstraintExp[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			org.omg.CosNotifyFilter.ConstraintExpHelper.write(_out,_s[i]);
		}

	}
}
