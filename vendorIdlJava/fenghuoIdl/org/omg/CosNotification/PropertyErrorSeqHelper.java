package org.omg.CosNotification;

/**
 *	Generated from IDL definition of alias "PropertyErrorSeq"
 *	@author JacORB IDL compiler 
 */

public final class PropertyErrorSeqHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, org.omg.CosNotification.PropertyError[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static org.omg.CosNotification.PropertyError[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.omg.CosNotification.PropertyErrorSeqHelper.id(), "PropertyErrorSeq",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CosNotification.PropertyErrorHelper.type() ) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:omg.org/CosNotification/PropertyErrorSeq:1.0";
	}
	public static org.omg.CosNotification.PropertyError[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		org.omg.CosNotification.PropertyError[] _result;
		int _l_result16 = _in.read_long();
		_result = new org.omg.CosNotification.PropertyError[_l_result16];
		for(int i=0;i<_result.length;i++)
		{
			_result[i]=org.omg.CosNotification.PropertyErrorHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, org.omg.CosNotification.PropertyError[] _s)
	{
		
		_out.write_long(_s.length);
		for( int i=0; i<_s.length;i++)
		{
			org.omg.CosNotification.PropertyErrorHelper.write(_out,_s[i]);
		}

	}
}
