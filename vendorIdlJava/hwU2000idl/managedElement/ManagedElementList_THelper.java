package managedElement;

/**
 *	Generated from IDL definition of alias "ManagedElementList_T"
 *	@author JacORB IDL compiler 
 */

public final class ManagedElementList_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, managedElement.ManagedElement_T[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static managedElement.ManagedElement_T[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(managedElement.ManagedElementList_THelper.id(), "ManagedElementList_T",org.omg.CORBA.ORB.init().create_sequence_tc(0, managedElement.ManagedElement_THelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/managedElement/ManagedElementList_T:1.0";
	}
	public static managedElement.ManagedElement_T[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		managedElement.ManagedElement_T[] _result;
		int _l_result88 = _in.read_long();
		_result = new managedElement.ManagedElement_T[_l_result88];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=managedElement.ManagedElement_THelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, managedElement.ManagedElement_T[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			managedElement.ManagedElement_THelper.write(_out,_s[i]);
		}

	}
}
