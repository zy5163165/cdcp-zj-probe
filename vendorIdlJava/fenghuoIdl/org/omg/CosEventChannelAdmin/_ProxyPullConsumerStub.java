package org.omg.CosEventChannelAdmin;


/**
 *	Generated from IDL definition of interface "ProxyPullConsumer"
 *	@author JacORB IDL compiler 
 */

public class _ProxyPullConsumerStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements org.omg.CosEventChannelAdmin.ProxyPullConsumer
{
	private String[] ids = {"IDL:omg.org/CosEventChannelAdmin/ProxyPullConsumer:1.0","IDL:omg.org/CosEventComm/PullConsumer:1.0","IDL:omg.org/CORBA/Object:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = org.omg.CosEventChannelAdmin.ProxyPullConsumerOperations.class;
	public void disconnect_pull_consumer()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "disconnect_pull_consumer", true);
				_is = _invoke(_os);
				return;
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "disconnect_pull_consumer", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			ProxyPullConsumerOperations _localServant = (ProxyPullConsumerOperations)_so.servant;
			try
			{
			_localServant.disconnect_pull_consumer();
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void connect_pull_supplier(org.omg.CosEventComm.PullSupplier pull_supplier) throws org.omg.CosEventChannelAdmin.AlreadyConnected,org.omg.CosEventChannelAdmin.TypeError
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "connect_pull_supplier", true);
				org.omg.CosEventComm.PullSupplierHelper.write(_os,pull_supplier);
				_is = _invoke(_os);
				return;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				if( _id.equals("IDL:omg.org/CosEventChannelAdmin/AlreadyConnected:1.0"))
				{
					throw org.omg.CosEventChannelAdmin.AlreadyConnectedHelper.read(_ax.getInputStream());
				}
				else if( _id.equals("IDL:omg.org/CosEventChannelAdmin/TypeError:1.0"))
				{
					throw org.omg.CosEventChannelAdmin.TypeErrorHelper.read(_ax.getInputStream());
				}
				else 
					throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "connect_pull_supplier", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			ProxyPullConsumerOperations _localServant = (ProxyPullConsumerOperations)_so.servant;
			try
			{
			_localServant.connect_pull_supplier(pull_supplier);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

}
