package managedElementManager;

/**
 *	Generated from IDL interface "ManagedElementMgr_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public final class ManagedElementMgr_IHolder	implements org.omg.CORBA.portable.Streamable{
	 public ManagedElementMgr_I value;
	public ManagedElementMgr_IHolder()
	{
	}
	public ManagedElementMgr_IHolder (final ManagedElementMgr_I initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return ManagedElementMgr_IHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = ManagedElementMgr_IHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		ManagedElementMgr_IHelper.write (_out,value);
	}
}
