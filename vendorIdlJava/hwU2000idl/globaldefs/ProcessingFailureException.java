package globaldefs;

/**
 *	Generated from IDL definition of exception "ProcessingFailureException"
 *	@author JacORB IDL compiler 
 */

public final class ProcessingFailureException
	extends org.omg.CORBA.UserException
{
	public ProcessingFailureException()
	{
		super(globaldefs.ProcessingFailureExceptionHelper.id());
	}

	public globaldefs.ExceptionType_T exceptionType;
	public java.lang.String errorReason = "";
	public ProcessingFailureException(java.lang.String _reason,globaldefs.ExceptionType_T exceptionType, java.lang.String errorReason)
	{
		super(globaldefs.ProcessingFailureExceptionHelper.id()+ " " + _reason);
		this.exceptionType = exceptionType;
		this.errorReason = errorReason;
	}
	public ProcessingFailureException(globaldefs.ExceptionType_T exceptionType, java.lang.String errorReason)
	{
		super(globaldefs.ProcessingFailureExceptionHelper.id());
		this.exceptionType = exceptionType;
		this.errorReason = errorReason;
	}
}
