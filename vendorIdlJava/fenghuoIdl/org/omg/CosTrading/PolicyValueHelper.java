package org.omg.CosTrading;

/**
 *	Generated from IDL definition of alias "PolicyValue"
 *	@author JacORB IDL compiler 
 */

public final class PolicyValueHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, org.omg.CORBA.Any s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static org.omg.CORBA.Any extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.omg.CosTrading.PolicyValueHelper.id(), "PolicyValue",org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(11)) );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:omg.org/CosTrading/PolicyValue:1.0";
	}
	public static org.omg.CORBA.Any read (final org.omg.CORBA.portable.InputStream _in)
	{
		org.omg.CORBA.Any _result;
		_result=_in.read_any();
		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, org.omg.CORBA.Any _s)
	{
		_out.write_any(_s);
	}
}
