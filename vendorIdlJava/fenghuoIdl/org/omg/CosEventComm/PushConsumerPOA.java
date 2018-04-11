package org.omg.CosEventComm;

/**
 *	Generated from IDL definition of interface "PushConsumer"
 *	@author JacORB IDL compiler 
 */


public abstract class PushConsumerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, org.omg.CosEventComm.PushConsumerOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "disconnect_push_consumer", new java.lang.Integer(0));
		m_opsHash.put ( "push", new java.lang.Integer(1));
	}
	private String[] ids = {"IDL:omg.org/CosEventComm/PushConsumer:1.0","IDL:omg.org/CORBA/Object:1.0"};
	public org.omg.CosEventComm.PushConsumer _this()
	{
		return org.omg.CosEventComm.PushConsumerHelper.narrow(_this_object());
	}
	public org.omg.CosEventComm.PushConsumer _this(org.omg.CORBA.ORB orb)
	{
		return org.omg.CosEventComm.PushConsumerHelper.narrow(_this_object(orb));
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // disconnect_push_consumer
			{
				_out = handler.createReply();
				disconnect_push_consumer();
				break;
			}
			case 1: // push
			{
			try
			{
				org.omg.CORBA.Any _arg0=_input.read_any();
				_out = handler.createReply();
				push(_arg0);
			}
			catch(org.omg.CosEventComm.Disconnected _ex0)
			{
				_out = handler.createExceptionReply();
				org.omg.CosEventComm.DisconnectedHelper.write(_out, _ex0);
			}
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
