package org.omg.CosEventChannelAdmin;


/**
 *	Generated from IDL definition of exception "TypeError"
 *	@author JacORB IDL compiler 
 */

public final class TypeErrorHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_exception_tc( org.omg.CosEventChannelAdmin.TypeErrorHelper.id(),"TypeError",new org.omg.CORBA.StructMember[0]);
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final org.omg.CosEventChannelAdmin.TypeError s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static org.omg.CosEventChannelAdmin.TypeError extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:omg.org/CosEventChannelAdmin/TypeError:1.0";
	}
	public static org.omg.CosEventChannelAdmin.TypeError read (final org.omg.CORBA.portable.InputStream in)
	{
		org.omg.CosEventChannelAdmin.TypeError result = new org.omg.CosEventChannelAdmin.TypeError();
		if(!in.read_string().equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id");
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final org.omg.CosEventChannelAdmin.TypeError s)
	{
		out.write_string(id());
	}
}
