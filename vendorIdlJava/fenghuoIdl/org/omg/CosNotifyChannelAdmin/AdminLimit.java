package org.omg.CosNotifyChannelAdmin;

/**
 *	Generated from IDL definition of struct "AdminLimit"
 *	@author JacORB IDL compiler 
 */

public final class AdminLimit
	implements org.omg.CORBA.portable.IDLEntity
{
	public AdminLimit(){}
	public java.lang.String name;
	public org.omg.CORBA.Any value;
	public AdminLimit(java.lang.String name, org.omg.CORBA.Any value)
	{
		this.name = name;
		this.value = value;
	}
	public String toString()
	{
		StringBuffer textStruct = new StringBuffer();
		textStruct.append("AdminLimit");
		textStruct.append("(");
		textStruct.append("name=");
		textStruct.append(name);
		textStruct.append(","); 
		textStruct.append("value=");
		textStruct.append(value);
		textStruct.append(")");
		return textStruct.toString();
	}
}
