package extendedManagedElementManager;

/**
 *	Generated from IDL definition of struct "BoardInternalSignalFlow_T"
 *	@author JacORB IDL compiler 
 */

public final class BoardInternalSignalFlow_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public extendedManagedElementManager.BoardInternalSignalFlow_T value;

	public BoardInternalSignalFlow_THolder ()
	{
	}
	public BoardInternalSignalFlow_THolder (final extendedManagedElementManager.BoardInternalSignalFlow_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return extendedManagedElementManager.BoardInternalSignalFlow_THelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream _in)
	{
		value = extendedManagedElementManager.BoardInternalSignalFlow_THelper.read (_in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		extendedManagedElementManager.BoardInternalSignalFlow_THelper.write (_out,value);
	}
	public String toString()
	{
		if(null != value)
			return value.toString();
		return "Holder contains no value";
	}
}
