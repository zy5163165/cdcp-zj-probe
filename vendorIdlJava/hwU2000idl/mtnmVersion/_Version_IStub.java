package mtnmVersion;


/**
 *	Generated from IDL interface "Version_I"
 *	@author JacORB IDL compiler V 2.2, 7-May-2004
 */

public class _Version_IStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements mtnmVersion.Version_I
{
	private String[] ids = {"IDL:mtnm.tmforum.org/mtnmVersion/Version_I:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = mtnmVersion.Version_IOperations.class;
	public java.lang.String getVersion()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "getVersion", true);
				_is = _invoke(_os);
				java.lang.String _result = _is.read_string();
				return _result;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "getVersion", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			Version_IOperations _localServant = (Version_IOperations)_so.servant;
			java.lang.String _result;			try
			{
			_result = _localServant.getVersion();
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

}
