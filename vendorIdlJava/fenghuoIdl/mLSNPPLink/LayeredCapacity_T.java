package mLSNPPLink;

/**
 *	Generated from IDL definition of struct "LayeredCapacity_T"
 *	@author JacORB IDL compiler 
 */

public final class LayeredCapacity_T
	implements org.omg.CORBA.portable.IDLEntity
{
	public LayeredCapacity_T(){}
	public short layerRate;
	public java.lang.String capacity;
	public LayeredCapacity_T(short layerRate, java.lang.String capacity)
	{
		this.layerRate = layerRate;
		this.capacity = capacity;
	}
	public String toString()
	{
		StringBuffer textStruct = new StringBuffer();
		textStruct.append("LayeredCapacity_T");
		textStruct.append("(");
		textStruct.append("layerRate=");
		textStruct.append(layerRate);
		textStruct.append(","); 
		textStruct.append("capacity=");
		textStruct.append(capacity);
		textStruct.append(")");
		return textStruct.toString();
	}
}
