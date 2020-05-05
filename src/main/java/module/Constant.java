package module;

/**
 * Define constant.
 *
 * @author Rugal Bernstein
 */
public interface Constant {

  String P = "Properties";

  String SP = "SystemProperties";

  String NEW = "new";

  // service bus
  String SERVICE_BUS_KEY = "SERVICE_BUS_CONNECTION_STRING";

  String SERVICE_BUS_VALUE = "Endpoint=sb://transithub-servicebus-ci.servicebus.windows.net/;"
                             + "SharedAccessKeyName=RootManageSharedAccessKey;"
                             + "SharedAccessKey=wAaffzUDb6efTbgBT2yhKv9njcsE1Dokr/uwMKv4QRs=;";

  // event hub
  String EVENT_HUB_NAME = "eventhub";

  String EVENT_HUB_KEY = "EVENT_HUB_CONNECTION_STRING";

  // test data;
  String TEST = "{\"createdBy\":\"Stephanie.Chen.v9m\","
                + "\"createDate\":\"Dec 10, 2019 2:33:10 PM\","
                + "\"updatedBy\":\"Stephanie.Chen.v9m\","
                + "\"updateDate\":\"Dec 10, 2019 2:33:10 PM\","
                + "\"entity\":{\"id\":\"5defaca6440a310c1c6a3b1a\","
                + "\"code\":\"steph_code_5\","
                + "\"versionId\":196008,"
                + "\"clientId\":2,"
                + "\"clientInstanceId\":null,"
                + "\"tenantId\":2}}";

  // attribute key
  String SOURCE = "source";

  String OPERATION = "operation";
}
