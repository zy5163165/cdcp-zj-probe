package multiLayerSubnetwork;


/**
 *	Generated from IDL interface "MultiLayerSubnetworkMgr_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public final class MultiLayerSubnetworkMgr_IHelper
{
	public static void insert (final org.omg.CORBA.Any any, final multiLayerSubnetwork.MultiLayerSubnetworkMgr_I s)
	{
			any.insert_Object(s);
	}
	public static multiLayerSubnetwork.MultiLayerSubnetworkMgr_I extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:mtnm.tmforum.org/multiLayerSubnetwork/MultiLayerSubnetworkMgr_I:1.0", "MultiLayerSubnetworkMgr_I");
	}
	public static String id()
	{
		return "IDL:mtnm.tmforum.org/multiLayerSubnetwork/MultiLayerSubnetworkMgr_I:1.0";
	}
	public static MultiLayerSubnetworkMgr_I read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final multiLayerSubnetwork.MultiLayerSubnetworkMgr_I s)
	{
		_out.write_Object(s);
	}
	public static multiLayerSubnetwork.MultiLayerSubnetworkMgr_I narrow(final java.lang.Object obj)
	{
		if (obj instanceof multiLayerSubnetwork.MultiLayerSubnetworkMgr_I)
		{
			return (multiLayerSubnetwork.MultiLayerSubnetworkMgr_I)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static multiLayerSubnetwork.MultiLayerSubnetworkMgr_I narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (multiLayerSubnetwork.MultiLayerSubnetworkMgr_I)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:mtnm.tmforum.org/multiLayerSubnetwork/MultiLayerSubnetworkMgr_I:1.0"))
			{
				multiLayerSubnetwork._MultiLayerSubnetworkMgr_IStub stub;
				stub = new multiLayerSubnetwork._MultiLayerSubnetworkMgr_IStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static multiLayerSubnetwork.MultiLayerSubnetworkMgr_I unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (multiLayerSubnetwork.MultiLayerSubnetworkMgr_I)obj;
		}
		catch (ClassCastException c)
		{
				multiLayerSubnetwork._MultiLayerSubnetworkMgr_IStub stub;
				stub = new multiLayerSubnetwork._MultiLayerSubnetworkMgr_IStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
