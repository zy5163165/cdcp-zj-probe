package HW_mstpProtection;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL interface "HW_RPRNodeIterator_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public class HW_RPRNodeIterator_IPOATie
	extends HW_RPRNodeIterator_IPOA
{
	private HW_RPRNodeIterator_IOperations _delegate;

	private POA _poa;
	public HW_RPRNodeIterator_IPOATie(HW_RPRNodeIterator_IOperations delegate)
	{
		_delegate = delegate;
	}
	public HW_RPRNodeIterator_IPOATie(HW_RPRNodeIterator_IOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public HW_mstpProtection.HW_RPRNodeIterator_I _this()
	{
		return HW_mstpProtection.HW_RPRNodeIterator_IHelper.narrow(_this_object());
	}
	public HW_mstpProtection.HW_RPRNodeIterator_I _this(org.omg.CORBA.ORB orb)
	{
		return HW_mstpProtection.HW_RPRNodeIterator_IHelper.narrow(_this_object(orb));
	}
	public HW_RPRNodeIterator_IOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(HW_RPRNodeIterator_IOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		else
		{
			return super._default_POA();
		}
	}
	public int getLength() throws globaldefs.ProcessingFailureException
	{
		return _delegate.getLength();
	}

	public boolean next_n(int how_many, HW_mstpProtection.HW_RPRNodeList_THolder rprNodeList) throws globaldefs.ProcessingFailureException
	{
		return _delegate.next_n(how_many,rprNodeList);
	}

	public void destroy() throws globaldefs.ProcessingFailureException
	{
_delegate.destroy();
	}

}
