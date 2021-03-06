package trailNtwProtection;

/**
 *	Generated from IDL definition of interface "TrailNtwProtMgr_I"
 *	@author JacORB IDL compiler 
 */


public interface TrailNtwProtMgr_IOperations
	extends common.Common_IOperations
{
	/* constants */
	/* operations  */
	void getAllTrailNtwProtections(globaldefs.NameAndStringValue_T[] resourceName, int how_many, trailNtwProtection.TrailNtwProtectionList_THolder tnpList, trailNtwProtection.TrailNtwProtectionIterator_IHolder tnpIt) throws globaldefs.ProcessingFailureException;
	void getTrailNtwProtection(globaldefs.NameAndStringValue_T[] tnpName, trailNtwProtection.TrailNtwProtection_THolder trailNtwProtection) throws globaldefs.ProcessingFailureException;
	void createTrailNtwProtection(trailNtwProtection.TrailNtwProtCreateData_T tnpCreateData, trailNtwProtection.TrailNtwProtection_THolder theTNP, org.omg.CORBA.StringHolder errorReason) throws globaldefs.ProcessingFailureException;
	void modifyTrailNtwProtection(globaldefs.NameAndStringValue_T[] tnpName, trailNtwProtection.TrailNtwProtModifyData_T tnpModifyData, trailNtwProtection.TrailNtwProtection_THolder modifiedTNP, org.omg.CORBA.StringHolder errorReason) throws globaldefs.ProcessingFailureException;
	void deleteTrailNtwProtection(globaldefs.NameAndStringValue_T[] tnpName, boolean keepPGs, globaldefs.NameAndStringValue_T[] swapTPname, globaldefs.NVSList_THolder additionalInfo, protection.ProtectionGroupList_THolder deletedPGList, trailNtwProtection.TrailNtwProtection_THolder deletedTNP, org.omg.CORBA.StringHolder errorReason) throws globaldefs.ProcessingFailureException;
}
