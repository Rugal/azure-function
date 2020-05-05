package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Entity class.
 *
 * @author Rugal Bernstein
 */
@AllArgsConstructor
@Data
public class Entity {

  private String id;

  private String tenantId;

  private String clientId;

  private String code;

  private String name;
}
