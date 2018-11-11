package com.github.daggerok.entities.common;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.TemporalType.TIMESTAMP;
import static lombok.AccessLevel.PRIVATE;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

  @Id
  @GeneratedValue
  @Setter(PRIVATE)
  UUID id;

  @Temporal(TIMESTAMP)
  @Column(name = "created_at")
  Date createdAt;

  @Temporal(TIMESTAMP)
  @Column(name = "updated_at")
  Date updatedAt;

  @PrePersist
  public void onCreate() {
    final Date now = new Date();
    setCreatedAt(now);
    setUpdatedAt(now);
  }

  @PostUpdate
  public void onUpdate() {
    setUpdatedAt(new Date());
  }
}
