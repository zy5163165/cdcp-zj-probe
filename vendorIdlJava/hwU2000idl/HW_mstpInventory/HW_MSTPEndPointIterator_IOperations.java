package HW_mstpInventory;

/**
 *	Generated from IDL interface "HW_MSTPEndPointIterator_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */


public interface HW_MSTPEndPointIterator_IOperations
{
	/* constants */
	/* operations  */
	boolean next_n(int how_many, HW_mstpInventory.HW_MSTPEndPointList_THolder endPointList) throws globaldefs.ProcessingFailureException;
	int getLength() throws globaldefs.ProcessingFailureException;
	void destroy() throws globaldefs.ProcessingFailureException;
}
