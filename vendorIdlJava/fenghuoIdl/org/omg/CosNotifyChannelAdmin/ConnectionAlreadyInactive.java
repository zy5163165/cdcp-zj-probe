package org.omg.CosNotifyChannelAdmin;

/**
 *	Generated from IDL definition of exception "ConnectionAlreadyInactive"
 *	@author JacORB IDL compiler 
 */

public final class ConnectionAlreadyInactive
	extends org.omg.CORBA.UserException
{
	public ConnectionAlreadyInactive()
	{
		super(org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactiveHelper.id());
	}

	public ConnectionAlreadyInactive(String value)
	{
		super(value);
	}
	public String toString()
	{
		StringBuffer textStruct = new StringBuffer();
		textStruct.append("ConnectionAlreadyInactive");
		textStruct.append("(");
		textStruct.append(super.toString());
		textStruct.append(")");
		return textStruct.toString();
	}
}
