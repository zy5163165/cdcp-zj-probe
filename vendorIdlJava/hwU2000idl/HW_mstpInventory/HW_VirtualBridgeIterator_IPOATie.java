package HW_mstpInventory;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL interface "HW_VirtualBridgeIterator_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public class HW_VirtualBridgeIterator_IPOATie
	extends HW_VirtualBridgeIterator_IPOA
{
	private HW_VirtualBridgeIterator_IOperations _delegate;

	private POA _poa;
	public HW_VirtualBridgeIterator_IPOATie(HW_VirtualBridgeIterator_IOperations delegate)
	{
		_delegate = delegate;
	}
	public HW_VirtualBridgeIterator_IPOATie(HW_VirtualBridgeIterator_IOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public HW_mstpInventory.HW_VirtualBridgeIterator_I _this()
	{
		return HW_mstpInventory.HW_VirtualBridgeIterator_IHelper.narrow(_this_object());
	}
	public HW_mstpInventory.HW_VirtualBridgeIterator_I _this(org.omg.CORBA.ORB orb)
	{
		return HW_mstpInventory.HW_VirtualBridgeIterator_IHelper.narrow(_this_object(orb));
	}
	public HW_VirtualBridgeIterator_IOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(HW_VirtualBridgeIterator_IOperations delegate)
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

	public boolean next_n(int how_many, HW_mstpInventory.HW_VirtualBridgeList_THolder vbList) throws globaldefs.ProcessingFailureException
	{
		return _delegate.next_n(how_many,vbList);
	}

	public void destroy() throws globaldefs.ProcessingFailureException
	{
_delegate.destroy();
	}

}
