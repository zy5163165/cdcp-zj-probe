package org.asb.mule.probe.framework.service;

public interface SbiService {

	public boolean connect();

	public boolean reconnect();

	public boolean disconnect();

	public boolean init();

	public boolean initFake();

	boolean isConnectState();

}
