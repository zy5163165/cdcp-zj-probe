package org.omg.CosNotifyChannelAdmin;

/**
 *	Generated from IDL definition of interface "StructuredProxyPushConsumer"
 *	@author JacORB IDL compiler 
 */

public final class StructuredProxyPushConsumerHelper
{
	public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer s)
	{
		any.insert_Object (s);
	}
	public static org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer extract (final org.omg.CORBA.Any any)
	{
		return narrow (any.extract_Object ());
	}
	public static org.omg.CORBA.TypeCode type ()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc( "IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushConsumer:1.0", "StructuredProxyPushConsumer");
	}
	public static String id()
	{
		return "IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushConsumer:1.0";
	}
	public static StructuredProxyPushConsumer read (final org.omg.CORBA.portable.InputStream in)
	{
		return narrow (in.read_Object ());
	}
	public static void write (final org.omg.CORBA.portable.OutputStream _out, final org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer s)
	{
		_out.write_Object(s);
	}
	public static org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer narrow (final org.omg.CORBA.Object obj)
	{
		if( obj == null )
			return null;
		try
		{
			return (org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer)obj;
		}
		catch( ClassCastException c )
		{
			if( obj._is_a("IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushConsumer:1.0"))
			{
				org.omg.CosNotifyChannelAdmin._StructuredProxyPushConsumerStub stub;
				stub = new org.omg.CosNotifyChannelAdmin._StructuredProxyPushConsumerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
}
