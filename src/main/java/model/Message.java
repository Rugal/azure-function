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
public class Message {

  private String createdBy;

  private String createDate;

  private String updatedBy;

  private String updateDate;

  private Entity entity;
}
