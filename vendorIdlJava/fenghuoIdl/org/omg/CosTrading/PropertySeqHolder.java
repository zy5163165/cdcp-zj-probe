package org.omg.CosTrading;

/**
 *	Generated from IDL definition of alias "PropertySeq"
 *	@author JacORB IDL compiler 
 */

public final class PropertySeqHolder
	implements org.omg.CORBA.portable.Streamable
{
	public org.omg.CosTrading.Property[] value;

	public PropertySeqHolder ()
	{
	}
	public PropertySeqHolder (final org.omg.CosTrading.Property[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return PropertySeqHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = PropertySeqHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		PropertySeqHelper.write (out,value);
	}
}
