package org.omg.CosTrading.ProxyPackage;

/**
 *	Generated from IDL definition of alias "ConstraintRecipe"
 *	@author JacORB IDL compiler 
 */

public final class ConstraintRecipeHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, java.lang.String s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static java.lang.String extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.omg.CosTrading.ProxyPackage.ConstraintRecipeHelper.id(), "ConstraintRecipe",org.omg.CosTrading.IstringHelper.type() );
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:omg.org/CosTrading/Proxy/ConstraintRecipe:1.0";
	}
	public static java.lang.String read (final org.omg.CORBA.portable.InputStream _in)
	{
		java.lang.String _result;
		_result = org.omg.CosTrading.IstringHelper.read(_in);
		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, java.lang.String _s)
	{
		org.omg.CosTrading.IstringHelper.write(_out,_s);
	}
}
