package callSNC;

/**
 *	Generated from IDL definition of interface "CallAndTopLevelConnectionsAndSNCsIterator_I"
 *	@author JacORB IDL compiler 
 */

public final class CallAndTopLevelConnectionsAndSNCsIterator_IHolder	implements org.omg.CORBA.portable.Streamable{
	 public CallAndTopLevelConnectionsAndSNCsIterator_I value;
	public CallAndTopLevelConnectionsAndSNCsIterator_IHolder ()
	{
	}
	public CallAndTopLevelConnectionsAndSNCsIterator_IHolder (final CallAndTopLevelConnectionsAndSNCsIterator_I initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return CallAndTopLevelConnectionsAndSNCsIterator_IHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = CallAndTopLevelConnectionsAndSNCsIterator_IHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		CallAndTopLevelConnectionsAndSNCsIterator_IHelper.write (_out,value);
	}
}
