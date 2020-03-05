package extendedEmsMgr;

/**
 *	Generated from IDL definition of interface "EXMegEntityDataIterator_I"
 *	@author JacORB IDL compiler 
 */


public abstract class EXMegEntityDataIterator_IPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, extendedEmsMgr.EXMegEntityDataIterator_IOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "getLength", new java.lang.Integer(0));
		m_opsHash.put ( "next_n", new java.lang.Integer(1));
		m_opsHash.put ( "destroy", new java.lang.Integer(2));
	}
	private String[] ids = {"IDL:mtnm.tmforum.org.fiberhome.extended/extendedEmsMgr/EXMegEntityDataIterator_I:1.0","IDL:omg.org/CORBA/Object:1.0"};
	public extendedEmsMgr.EXMegEntityDataIterator_I _this()
	{
		return extendedEmsMgr.EXMegEntityDataIterator_IHelper.narrow(_this_object());
	}
	public extendedEmsMgr.EXMegEntityDataIterator_I _this(org.omg.CORBA.ORB orb)
	{
		return extendedEmsMgr.EXMegEntityDataIterator_IHelper.narrow(_this_object(orb));
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
			case 0: // getLength
			{
			try
			{
				_out = handler.createReply();
				_out.write_ulong(getLength());
			}
			catch(globaldefs.ProcessingFailureException _ex0)
			{
				_out = handler.createExceptionReply();
				globaldefs.ProcessingFailureExceptionHelper.write(_out, _ex0);
			}
				break;
			}
			case 1: // next_n
			{
			try
			{
				int _arg0=_input.read_ulong();
				extendedEmsMgr.EXMegEntityDataList_THolder _arg1= new extendedEmsMgr.EXMegEntityDataList_THolder();
				_out = handler.createReply();
				_out.write_boolean(next_n(_arg0,_arg1));
				extendedEmsMgr.EXMegEntityDataList_THelper.write(_out,_arg1.value);
			}
			catch(globaldefs.ProcessingFailureException _ex0)
			{
				_out = handler.createExceptionReply();
				globaldefs.ProcessingFailureExceptionHelper.write(_out, _ex0);
			}
				break;
			}
			case 2: // destroy
			{
			try
			{
				_out = handler.createReply();
				destroy();
			}
			catch(globaldefs.ProcessingFailureException _ex0)
			{
				_out = handler.createExceptionReply();
				globaldefs.ProcessingFailureExceptionHelper.write(_out, _ex0);
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
