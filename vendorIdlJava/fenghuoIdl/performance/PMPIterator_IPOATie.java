package performance;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL definition of interface "PMPIterator_I"
 *	@author JacORB IDL compiler 
 */

public class PMPIterator_IPOATie
	extends PMPIterator_IPOA
{
	private PMPIterator_IOperations _delegate;

	private POA _poa;
	public PMPIterator_IPOATie(PMPIterator_IOperations delegate)
	{
		_delegate = delegate;
	}
	public PMPIterator_IPOATie(PMPIterator_IOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public performance.PMPIterator_I _this()
	{
		return performance.PMPIterator_IHelper.narrow(_this_object());
	}
	public performance.PMPIterator_I _this(org.omg.CORBA.ORB orb)
	{
		return performance.PMPIterator_IHelper.narrow(_this_object(orb));
	}
	public PMPIterator_IOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(PMPIterator_IOperations delegate)
	{
		_delegate = delegate;
	}
	public int getLength() throws globaldefs.ProcessingFailureException
	{
		return _delegate.getLength();
	}

	public boolean next_n(int how_many, performance.PMPList_THolder pmpList) throws globaldefs.ProcessingFailureException
	{
		return _delegate.next_n(how_many,pmpList);
	}

	public void destroy() throws globaldefs.ProcessingFailureException
	{
_delegate.destroy();
	}

}
