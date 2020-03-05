package com.alcatelsbell.cdcp.nodefx;

//import com.alcatelsbell.cdcp.framework.LifeCycle;

import java.io.Serializable;

/**
 * Author: Ronnie.Chen
 * Date: 13-4-11
 * Time: 上午9:36
 * rongrong.chen@alcatel-sbell.com.cn
 */
 public enum LifecycleState implements Serializable {
    NEW(false, null),
    INITIALIZING(false, LifeCycle.BEFORE_INIT_EVENT),
    INITIALIZED(false, LifeCycle.AFTER_INIT_EVENT),
    STARTING_PREP(false, LifeCycle.BEFORE_START_EVENT),
    STARTING(true, LifeCycle.START_EVENT),
    STARTED(true, LifeCycle.AFTER_START_EVENT),
    STOPPING_PREP(true, LifeCycle.BEFORE_STOP_EVENT),
    STOPPING(false, LifeCycle.STOP_EVENT),
    STOPPED(false, LifeCycle.AFTER_STOP_EVENT),
    DESTROYING(false, LifeCycle.BEFORE_DESTROY_EVENT),
    DESTROYED(false, LifeCycle.AFTER_DESTROY_EVENT),
    FAILED(false, null),
    MUST_STOP(true, null),
    MUST_DESTROY(false, null);

    private final boolean available;
    private final String lifecycleEvent;

    private LifecycleState(boolean available, String lifecycleEvent) {
        this.available = available;
        this.lifecycleEvent = lifecycleEvent;
    }

    /**
     * May the public methods other than property getters/setters and lifecycle
     * methods be called for a component in this state? It returns
     * <code>true</code> for any component in any of the following states:
     * <ul>
     * <li>{@link #STARTING}</li>
     * <li>{@link #STARTED}</li>
     * <li>{@link #STOPPING_PREP}</li>
     * <li>{@link #MUST_STOP}</li>
     * </ul>
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     *
     */
    public String getLifecycleEvent() {
        return lifecycleEvent;
    }
}