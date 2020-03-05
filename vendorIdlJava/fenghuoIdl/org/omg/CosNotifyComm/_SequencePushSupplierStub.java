package org.omg.CosNotifyComm;


/**
 *	Generated from IDL definition of interface "SequencePushSupplier"
 *	@author JacORB IDL compiler 
 */

public class _SequencePushSupplierStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements org.omg.CosNotifyComm.SequencePushSupplier
{
	private String[] ids = {"IDL:omg.org/CosNotifyComm/SequencePushSupplier:1.0","IDL:omg.org/CosNotifyComm/NotifySubscribe:1.0","IDL:omg.org/CORBA/Object:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = org.omg.CosNotifyComm.SequencePushSupplierOperations.class;
	public void subscription_change(org.omg.CosNotification.EventType[] added, org.omg.CosNotification.EventType[] removed) throws org.omg.CosNotifyComm.InvalidEventType
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "subscription_change", true);
				org.omg.CosNotification.EventTypeSeqHelper.write(_os,added);
				org.omg.CosNotification.EventTypeSeqHelper.write(_os,removed);
				_is = _invoke(_os);
				return;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				if( _id.equals("IDL:omg.org/CosNotifyComm/InvalidEventType:1.0"))
				{
					throw org.omg.CosNotifyComm.InvalidEventTypeHelper.read(_ax.getInputStream());
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "subscription_change", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			SequencePushSupplierOperations _localServant = (SequencePushSupplierOperations)_so.servant;
			try
			{
			_localServant.subscription_change(added,removed);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void disconnect_sequence_push_supplier()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "disconnect_sequence_push_supplier", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "disconnect_sequence_push_supplier", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			SequencePushSupplierOperations _localServant = (SequencePushSupplierOperations)_so.servant;
			try
			{
			_localServant.disconnect_sequence_push_supplier();
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
