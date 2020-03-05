package org.omg.CosNotifyChannelAdmin;


/**
 *	Generated from IDL definition of exception "AdminLimitExceeded"
 *	@author JacORB IDL compiler 
 */

public final class AdminLimitExceededHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_exception_tc( org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.id(),"AdminLimitExceeded",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("admin_property_err", org.omg.CosNotifyChannelAdmin.AdminLimitHelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.AdminLimitExceeded s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static org.omg.CosNotifyChannelAdmin.AdminLimitExceeded extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:omg.org/CosNotifyChannelAdmin/AdminLimitExceeded:1.0";
	}
	public static org.omg.CosNotifyChannelAdmin.AdminLimitExceeded read (final org.omg.CORBA.portable.InputStream in)
	{
		org.omg.CosNotifyChannelAdmin.AdminLimitExceeded result = new org.omg.CosNotifyChannelAdmin.AdminLimitExceeded();
		if(!in.read_string().equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id");
		result.admin_property_err=org.omg.CosNotifyChannelAdmin.AdminLimitHelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final org.omg.CosNotifyChannelAdmin.AdminLimitExceeded s)
	{
		out.write_string(id());
		org.omg.CosNotifyChannelAdmin.AdminLimitHelper.write(out,s.admin_property_err);
	}
}
