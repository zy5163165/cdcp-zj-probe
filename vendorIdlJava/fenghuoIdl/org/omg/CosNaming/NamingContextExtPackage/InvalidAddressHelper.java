package org.omg.CosNaming.NamingContextExtPackage;


/**
 *	Generated from IDL definition of exception "InvalidAddress"
 *	@author JacORB IDL compiler 
 */

public final class InvalidAddressHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_exception_tc( org.omg.CosNaming.NamingContextExtPackage.InvalidAddressHelper.id(),"InvalidAddress",new org.omg.CORBA.StructMember[0]);
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNaming.NamingContextExtPackage.InvalidAddress s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static org.omg.CosNaming.NamingContextExtPackage.InvalidAddress extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:omg.org/CosNaming/NamingContextExt/InvalidAddress:1.0";
	}
	public static org.omg.CosNaming.NamingContextExtPackage.InvalidAddress read (final org.omg.CORBA.portable.InputStream in)
	{
		org.omg.CosNaming.NamingContextExtPackage.InvalidAddress result = new org.omg.CosNaming.NamingContextExtPackage.InvalidAddress();
		if(!in.read_string().equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id");
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final org.omg.CosNaming.NamingContextExtPackage.InvalidAddress s)
	{
		out.write_string(id());
	}
}
