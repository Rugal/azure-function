import java.util.Optional;
import java.util.logging.Logger;

import com.azure.messaging.eventhubs.EventData;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.EventHubOutput;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import module.Constant;

/**
 * Azure function for testing. Invoking this function with request body so we can test the
 * {@code validator} function easily.<BR>
 * This method will be removed once development is completed.
 *
 * @author Rugal Bernstein
 */
public class EventIngestTestService {

  /**
   * Send message to target Event Hub in order to test easily.
   *
   * @param request HTTP request
   * @param context request context
   *
   * @return output event data
   */
  @EventHubOutput(name = "event",
                  eventHubName = Constant.EVENT_HUB_NAME,
                  connection = Constant.EVENT_HUB_KEY)
  @FunctionName("ingestor")
  public EventData run(final @HttpTrigger(name = "req",
                                          methods = HttpMethod.POST,
                                          authLevel = AuthorizationLevel.ANONYMOUS)
                          HttpRequestMessage<Optional<String>> request,
                       final ExecutionContext context) {
    final Logger log = context.getLogger();
    log.info("Java HTTP trigger processed a request.");
    final String message = request.getBody().orElse(Constant.TEST);
    log.info(message);
    final EventData eventData = new EventData(message);
    eventData.getProperties().put(Constant.SOURCE, Constant.ENTITY);
    eventData.getProperties().put(Constant.OPERATION, "ADD");
    return eventData;
  }
}
