package org.omg.CosNaming;
/**
 *	Generated from IDL definition of enum "BindingType"
 *	@author JacORB IDL compiler 
 */

public final class BindingTypeHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_enum_tc(org.omg.CosNaming.BindingTypeHelper.id(),"BindingType",new String[]{"nobject","ncontext"});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNaming.BindingType s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static org.omg.CosNaming.BindingType extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:omg.org/CosNaming/BindingType:1.0";
	}
	public static BindingType read (final org.omg.CORBA.portable.InputStream in)
	{
		return BindingType.from_int( in.read_long());
	}

	public static void write (final org.omg.CORBA.portable.OutputStream out, final BindingType s)
	{
		out.write_long(s.value());
	}
}
