package org.omg.CosNotifyFilter;

/**
 *	Generated from IDL definition of struct "ConstraintInfo"
 *	@author JacORB IDL compiler 
 */

public final class ConstraintInfo
	implements org.omg.CORBA.portable.IDLEntity
{
	public ConstraintInfo(){}
	public org.omg.CosNotifyFilter.ConstraintExp constraint_expression;
	public int constraint_id;
	public ConstraintInfo(org.omg.CosNotifyFilter.ConstraintExp constraint_expression, int constraint_id)
	{
		this.constraint_expression = constraint_expression;
		this.constraint_id = constraint_id;
	}
	public String toString()
	{
		StringBuffer textStruct = new StringBuffer();
		textStruct.append("ConstraintInfo");
		textStruct.append("(");
		textStruct.append("constraint_expression=");
		textStruct.append(constraint_expression);
		textStruct.append(","); 
		textStruct.append("constraint_id=");
		textStruct.append(constraint_id);
		textStruct.append(")");
		return textStruct.toString();
	}
}
