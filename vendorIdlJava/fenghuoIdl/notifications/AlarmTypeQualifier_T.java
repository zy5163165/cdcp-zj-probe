package notifications;
/**
 *	Generated from IDL definition of enum "AlarmTypeQualifier_T"
 *	@author JacORB IDL compiler 
 */

public final class AlarmTypeQualifier_T
	implements org.omg.CORBA.portable.IDLEntity
{
	private int value = -1;
	public static final int _ALARM = 0;
	public static final AlarmTypeQualifier_T ALARM = new AlarmTypeQualifier_T(_ALARM);
	public static final int _TCA = 1;
	public static final AlarmTypeQualifier_T TCA = new AlarmTypeQualifier_T(_TCA);
	public int value()
	{
		return value;
	}
	public static AlarmTypeQualifier_T from_int(int value)
	{
		switch (value) {
			case _ALARM: return ALARM;
			case _TCA: return TCA;
			default: throw new org.omg.CORBA.BAD_PARAM();
		}
	}
	protected AlarmTypeQualifier_T(int i)
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
		textEnum.append("AlarmTypeQualifier_T");
		textEnum.append(".");
		switch(value())
		{
		case _ALARM:
			textEnum.append("ALARM");
			break;
		case _TCA:
			textEnum.append("TCA");
			break;
		}
		return textEnum.toString();
	}
}
