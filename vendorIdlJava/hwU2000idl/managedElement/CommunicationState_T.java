package managedElement;
/**
 *	Generated from IDL definition of enum "CommunicationState_T"
 *	@author JacORB IDL compiler 
 */

public final class CommunicationState_T
	implements org.omg.CORBA.portable.IDLEntity
{
	private int value = -1;
	public static final int _CS_AVAILABLE = 0;
	public static final CommunicationState_T CS_AVAILABLE = new CommunicationState_T(_CS_AVAILABLE);
	public static final int _CS_UNAVAILABLE = 1;
	public static final CommunicationState_T CS_UNAVAILABLE = new CommunicationState_T(_CS_UNAVAILABLE);
	public int value()
	{
		return value;
	}
	public static CommunicationState_T from_int(int value)
	{
		switch (value) {
			case _CS_AVAILABLE: return CS_AVAILABLE;
			case _CS_UNAVAILABLE: return CS_UNAVAILABLE;
			default: throw new org.omg.CORBA.BAD_PARAM();
		}
	}
	protected CommunicationState_T(int i)
	{
		value = i;
	}
	java.lang.Object readResolve()
	throws java.io.ObjectStreamException
	{
		return from_int(value());
	}
}
