package model;

import static java.nio.charset.StandardCharsets.UTF_8;

import lombok.Data;

/**
 * Data container.
 *
 * @author Rugal Bernstein
 */
@Data
public class EventDataContainer {

  private byte[] body;

  /**
   * Returns event data as UTF-8 decoded string.
   *
   * @return UTF-8 decoded string representation of the event data.
   */
  public String getBodyAsString() {
    return new String(this.body, UTF_8);
  }
}
