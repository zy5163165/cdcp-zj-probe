package org.omg.CosNotifyFilter;

/**
 *	Generated from IDL definition of interface "Filter"
 *	@author JacORB IDL compiler 
 */

public final class FilterHelper
{
	public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyFilter.Filter s)
	{
		any.insert_Object (s);
	}
	public static org.omg.CosNotifyFilter.Filter extract (final org.omg.CORBA.Any any)
	{
		return narrow (any.extract_Object ());
	}
	public static org.omg.CORBA.TypeCode type ()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc( "IDL:omg.org/CosNotifyFilter/Filter:1.0", "Filter");
	}
	public static String id()
	{
		return "IDL:omg.org/CosNotifyFilter/Filter:1.0";
	}
	public static Filter read (final org.omg.CORBA.portable.InputStream in)
	{
		return narrow (in.read_Object ());
	}
	public static void write (final org.omg.CORBA.portable.OutputStream _out, final org.omg.CosNotifyFilter.Filter s)
	{
		_out.write_Object(s);
	}
	public static org.omg.CosNotifyFilter.Filter narrow (final org.omg.CORBA.Object obj)
	{
		if( obj == null )
			return null;
		try
		{
			return (org.omg.CosNotifyFilter.Filter)obj;
		}
		catch( ClassCastException c )
		{
			if( obj._is_a("IDL:omg.org/CosNotifyFilter/Filter:1.0"))
			{
				org.omg.CosNotifyFilter._FilterStub stub;
				stub = new org.omg.CosNotifyFilter._FilterStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
}
