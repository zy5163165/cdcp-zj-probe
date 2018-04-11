package aSAP;
/**
 *	Generated from IDL definition of enum "AssignedSeverity_T"
 *	@author JacORB IDL compiler 
 */

public final class AssignedSeverity_T
	implements org.omg.CORBA.portable.IDLEntity
{
	private int value = -1;
	public static final int _AS_INDETERMINATE = 0;
	public static final AssignedSeverity_T AS_INDETERMINATE = new AssignedSeverity_T(_AS_INDETERMINATE);
	public static final int _AS_CRITICAL = 1;
	public static final AssignedSeverity_T AS_CRITICAL = new AssignedSeverity_T(_AS_CRITICAL);
	public static final int _AS_MAJOR = 2;
	public static final AssignedSeverity_T AS_MAJOR = new AssignedSeverity_T(_AS_MAJOR);
	public static final int _AS_MINOR = 3;
	public static final AssignedSeverity_T AS_MINOR = new AssignedSeverity_T(_AS_MINOR);
	public static final int _AS_WARNING = 4;
	public static final AssignedSeverity_T AS_WARNING = new AssignedSeverity_T(_AS_WARNING);
	public static final int _AS_NONALARMED = 5;
	public static final AssignedSeverity_T AS_NONALARMED = new AssignedSeverity_T(_AS_NONALARMED);
	public static final int _AS_FREE_CHOICE = 6;
	public static final AssignedSeverity_T AS_FREE_CHOICE = new AssignedSeverity_T(_AS_FREE_CHOICE);
	public int value()
	{
		return value;
	}
	public static AssignedSeverity_T from_int(int value)
	{
		switch (value) {
			case _AS_INDETERMINATE: return AS_INDETERMINATE;
			case _AS_CRITICAL: return AS_CRITICAL;
			case _AS_MAJOR: return AS_MAJOR;
			case _AS_MINOR: return AS_MINOR;
			case _AS_WARNING: return AS_WARNING;
			case _AS_NONALARMED: return AS_NONALARMED;
			case _AS_FREE_CHOICE: return AS_FREE_CHOICE;
			default: throw new org.omg.CORBA.BAD_PARAM();
		}
	}
	protected AssignedSeverity_T(int i)
	{
		value = i;
	}
	java.lang.Object readResolve()
	throws java.io.ObjectStreamException
	{
		return from_int( value() );
	}
	public String toString()
	{
		StringBuffer textEnum = new StringBuffer();
		textEnum.append("AssignedSeverity_T");
		textEnum.append(".");
		switch(value())
		{
		case _AS_INDETERMINATE:
			textEnum.append("AS_INDETERMINATE");
			break;
		case _AS_CRITICAL:
			textEnum.append("AS_CRITICAL");
			break;
		case _AS_MAJOR:
			textEnum.append("AS_MAJOR");
			break;
		case _AS_MINOR:
			textEnum.append("AS_MINOR");
			break;
		case _AS_WARNING:
			textEnum.append("AS_WARNING");
			break;
		case _AS_NONALARMED:
			textEnum.append("AS_NONALARMED");
			break;
		case _AS_FREE_CHOICE:
			textEnum.append("AS_FREE_CHOICE");
			break;
		}
		return textEnum.toString();
	}
}
