package org.omg.CosTrading;


/**
 *	Generated from IDL definition of exception "IllegalPropertyName"
 *	@author JacORB IDL compiler 
 */

public final class IllegalPropertyNameHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_exception_tc( org.omg.CosTrading.IllegalPropertyNameHelper.id(),"IllegalPropertyName",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("name", org.omg.CosTrading.PropertyNameHelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final org.omg.CosTrading.IllegalPropertyName s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static org.omg.CosTrading.IllegalPropertyName extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:omg.org/CosTrading/IllegalPropertyName:1.0";
	}
	public static org.omg.CosTrading.IllegalPropertyName read (final org.omg.CORBA.portable.InputStream in)
	{
		org.omg.CosTrading.IllegalPropertyName result = new org.omg.CosTrading.IllegalPropertyName();
		if(!in.read_string().equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id");
		result.name = org.omg.CosTrading.PropertyNameHelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final org.omg.CosTrading.IllegalPropertyName s)
	{
		out.write_string(id());
		org.omg.CosTrading.PropertyNameHelper.write(out,s.name);
	}
}
