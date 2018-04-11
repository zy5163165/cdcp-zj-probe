package com.alcatelsbell.cdcp.nodefx;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-10
 * Time: 下午3:44
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class CDCPConstants {
    public static final String MESSAGE_TYPE_NODE_STARTUP = "MESSAGE_TYPE_STARTUP";
    public static final String MESSAGE_TYPE_NODE_ALIVE = "MESSAGE_TYPE_ALIVE";
    public static final String MESSAGE_TYPE_TASK_INFO = "MESSAGE_TYPE_TASK_INFO";
    public static final String MESSAGE_TYPE_SBI_EVENT = "MESSAGE_TYPE_SBI_EVENT";
    public static final String TOPIC_NODE = "topic_node";
    public static final String TOPIC_EMS_SBI = "topic_ems_sbi";
    public static final String TOPIC_EMS_SBI_EVENT = "topic_ems_sbi_event";
    public static final String TOPIC_LOG = "topic_log";
    public static final String TOPIC_EMS_ALARM = "topic_ems_alarm";
    public static final String TOPIC_SERVER_BROADCAST = "topic_svr_broadcast";

    public static final String MESSAGE_ATTRIBUTE_TASK_SERIAL = "TaskSerial";
    public static final String MESSAGE_ATTRIBUTE_TASK_EDS = "TaskEDS";
    public static final String MESSAGE_ATTRIBUTE_LOG_TXT = "LogTxt";
    public static final String MESSAGE_ATTRIBUTE_PERCENTAGE = "Percentage";
    public static final String MESSAGE_ATTRIBUTE_EMSDN = "EmsDn";
    public static final String MESSAGE_ATTRIBUTE_EMS_EVENT_TYPE = "EmsEventType";
    public static final String MESSAGE_ATTRIBUTE_EMS_EVENT_OBJECT = "EmsEventObject";
    public static final String MESSAGE_ATTRIBUTE_RECEIVE_UN_FINISH_TASKS = "ReceiveUnFinishTasks";
  //  public static final String MESSAGE_ATTRIBUTE_PERCENTAGE = "Percentage";

    public static final String EVENT_TYPE_ALARM = "EventType_Alarm";
    public static final String EVENT_TYPE_OBJECT = "EventType_Object";


    public static final String SYSTEM_PROPERTY_FTP_HOST = "ftpHost";
    public static final String SYSTEM_PROPERTY_FTP_USER = "ftpUser";
    public static final String SYSTEM_PROPERTY_FTP_PASSWORD = "ftpPassword";
    public static final String SYSTEM_PROPERTY_FTP_REMOTEPATH = "ftpRemotePath";
    public static final String  SYSTEM_PROPERTY_ACTIVE_MQ_URL = "activeMQUrl";
    public static final String  SYSTEM_PROPERTY_EMS_ADAPTERS = "emsAdapter";
    public static final String  SYSTEM_PROPERTY_CONCURRENT_EMS_SIZE = "concurrentEmsSize";

    public static final String NODE_JMS_DOMAIN = "cdcp";

    public static final String EMS_TYPE_HWU2000_PTN = "HWU2000";
    public static final String EMS_TYPE_FENGHUOOTNM2000_PTN = "FH";
    public static final String EMS_TYPE_ALU_PTN = "ALU";

    public static final String EMSJOB_DATA_KEY_DEVICE_DN = "DEVICEDN";
    public static final String EMSJOB_DATA_KEY_SYNC_TYPE = "SYNC_TYPE";
    public static final String EMSJOB_DATA_VALUE_SYNC_TYPE_AUTO = "AUTO";
    public static final String EMSJOB_DATA_VALUE_SYNC_TYPE_MAN = "MAN";

    public static final String EXCEPTION_MSG_EMS_BUSY = "EMSBusy";
    public static final String EXCEPTION_MSG_EmsDisconnected = "EmsDisconnected";
    public static final String EXCEPTION_MSG_EmsConnectionRefused = "EmsConnectionRefused";
    public static final String EXCEPTION_MSG_NENotExisted = "NENotExisted";
    public static final String EXCEPTION_MSG_NEException   = "NEException";

    public static final String URI_SCHEMA = "cdcp";
    public static final String URI_PATH_ACTIVE_ALARM_LIST = "active-alarm-list";
    public static final String URI_PATH_DEVICE_LIST = "device-list";


    public static final int PMDATA_ENTITY_TYPE_DEVICE = 0;
    public static final int PMDATA_ENTITY_TYPE_SHELF = 3;
    public static final int PMDATA_ENTITY_TYPE_SLOT = 4;
    public static final int PMDATA_ENTITY_TYPE_CARD = 5;
    public static final int PMDATA_ENTITY_TYPE_PTP = 1;
    public static final int PMDATA_ENTITY_TYPE_TARGET = 2;
}
