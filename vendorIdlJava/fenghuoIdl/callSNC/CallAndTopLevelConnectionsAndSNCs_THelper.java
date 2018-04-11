package callSNC;


/**
 *	Generated from IDL definition of struct "CallAndTopLevelConnectionsAndSNCs_T"
 *	@author JacORB IDL compiler 
 */

public final class CallAndTopLevelConnectionsAndSNCs_THelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if( _type == null )
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc( callSNC.CallAndTopLevelConnectionsAndSNCs_THelper.id(),"CallAndTopLevelConnectionsAndSNCs_T",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("theCall", callSNC.Call_THelper.type(), null),new org.omg.CORBA.StructMember("topLevelConnectionsAndSNCsList", callSNC.ConnectionsAndSupportingSNCsList_THelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final callSNC.CallAndTopLevelConnectionsAndSNCs_T s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static callSNC.CallAndTopLevelConnectionsAndSNCs_T extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:mtnm.tmforum.org/callSNC/CallAndTopLevelConnectionsAndSNCs_T:1.0";
	}
	public static callSNC.CallAndTopLevelConnectionsAndSNCs_T read (final org.omg.CORBA.portable.InputStream in)
	{
		callSNC.CallAndTopLevelConnectionsAndSNCs_T result = new callSNC.CallAndTopLevelConnectionsAndSNCs_T();
		result.theCall=callSNC.Call_THelper.read(in);
		result.topLevelConnectionsAndSNCsList = callSNC.ConnectionsAndSupportingSNCsList_THelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final callSNC.CallAndTopLevelConnectionsAndSNCs_T s)
	{
		callSNC.Call_THelper.write(out,s.theCall);
		callSNC.ConnectionsAndSupportingSNCsList_THelper.write(out,s.topLevelConnectionsAndSNCsList);
	}
}
