package org.omg.CosEventChannelAdmin;


/**
 *	Generated from IDL definition of interface "ProxyPushSupplier"
 *	@author JacORB IDL compiler 
 */

public class _ProxyPushSupplierStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements org.omg.CosEventChannelAdmin.ProxyPushSupplier
{
	private String[] ids = {"IDL:omg.org/CosEventChannelAdmin/ProxyPushSupplier:1.0","IDL:omg.org/CosEventComm/PushSupplier:1.0","IDL:omg.org/CORBA/Object:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = org.omg.CosEventChannelAdmin.ProxyPushSupplierOperations.class;
	public void connect_push_consumer(org.omg.CosEventComm.PushConsumer push_consumer) throws org.omg.CosEventChannelAdmin.AlreadyConnected,org.omg.CosEventChannelAdmin.TypeError
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "connect_push_consumer", true);
				org.omg.CosEventComm.PushConsumerHelper.write(_os,push_consumer);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "connect_push_consumer", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			ProxyPushSupplierOperations _localServant = (ProxyPushSupplierOperations)_so.servant;
			try
			{
			_localServant.connect_push_consumer(push_consumer);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void disconnect_push_supplier()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "disconnect_push_supplier", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "disconnect_push_supplier", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			ProxyPushSupplierOperations _localServant = (ProxyPushSupplierOperations)_so.servant;
			try
			{
			_localServant.disconnect_push_supplier();
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
