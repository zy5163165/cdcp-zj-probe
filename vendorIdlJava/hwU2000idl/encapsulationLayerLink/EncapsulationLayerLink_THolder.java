package encapsulationLayerLink;

/**
 *	Generated from IDL definition of struct "EncapsulationLayerLink_T"
 *	@author JacORB IDL compiler 
 */

public final class EncapsulationLayerLink_THolder
	implements org.omg.CORBA.portable.Streamable
{
	public encapsulationLayerLink.EncapsulationLayerLink_T value;

	public EncapsulationLayerLink_THolder ()
	{
	}
	public EncapsulationLayerLink_THolder(final encapsulationLayerLink.EncapsulationLayerLink_T initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return encapsulationLayerLink.EncapsulationLayerLink_THelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = encapsulationLayerLink.EncapsulationLayerLink_THelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		encapsulationLayerLink.EncapsulationLayerLink_THelper.write(_out, value);
	}
}
