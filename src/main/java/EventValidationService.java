import java.util.Map;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.Cardinality;
import com.microsoft.azure.functions.annotation.EventHubTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import model.EventDataContainer;
import model.Message;
import module.BundleComponent;
import module.Constant;
import module.DaggerBundleComponent;

/**
 * Azure Function that actually doing the validation for incoming message from EventHub.
 *
 * @author Rugal Bernstein
 */
public class EventValidationService {

  private final BundleComponent component;

  public EventValidationService() {
    this.component = DaggerBundleComponent.builder().build();
  }

  private TopicClient getClient(final String topic)
          throws InterruptedException, ServiceBusException {
    return new TopicClient(new ConnectionStringBuilder(
            this.component.serviceBusConnectionString(),
            topic)
    );
  }

  /**
   * Get message from EventHub, validate it before ingesting it to ServiceBus.
   *
   * @param input            EventHub data
   * @param properties       user property
   * @param systemProperties system property
   * @param context          request context
   *
   * @throws InterruptedException thread interrupted
   * @throws ServiceBusException  Unable to connect to ServiceBus
   */
  @FunctionName("validator")
  public void run(final @EventHubTrigger(name = "event",
                                         eventHubName = Constant.EVENT_HUB_NAME,
                                         cardinality = Cardinality.ONE,
                                         connection = Constant.EVENT_HUB_KEY)
                    EventDataContainer input,
                  final @BindingName(Constant.P) Map<String, String> properties,
                  final @BindingName(Constant.SP) Map<String, Object> systemProperties,
                  final ExecutionContext context) throws InterruptedException, ServiceBusException {
    final Logger log = context.getLogger();
    //TODO: get message
    log.info(String.format("Source: [%s]", properties.get(Constant.SOURCE)));
    log.info(String.format("Body: [%s]", input.getBodyAsString()));
    //TODO: get corresponding json schema by 'source' from Azure storage
    //TODO: validate the message body by the json schema
    final Gson gson = this.component.gson();
    final Message message = gson.fromJson(input.getBodyAsString(), Message.class);
    log.info(String.format("id: [%s]", message.getEntity().getId()));
    //TODO: send event to service bus
    final TopicClient client = this.getClient(properties.get(Constant.SOURCE));
    System.out.println(client.toString());
  }
}
