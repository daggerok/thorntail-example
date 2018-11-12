package com.github.daggerok.entities;

import com.github.daggerok.entities.common.BaseEntity;
import com.github.daggerok.entities.root.Car;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.github.daggerok.entities.AggregateRoot.*;
import static javax.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = " select me from AggregateRoot me order by me.createdAt desc "),
    @NamedQuery(name = FIND_BY_ID, query = " select me from AggregateRoot me where me.id = :id "),
    @NamedQuery(name = COUNT, query = " select count(me) from AggregateRoot me ")
})
@Table(name = "root_aggregates")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor(staticName = "of")
public class AggregateRoot extends BaseEntity {

  public static final String FIND_ALL = "AggregateRoot.findAll";
  public static final String FIND_BY_ID = "AggregateRoot.findOne";
  public static final String COUNT = "AggregateRoot.count";

  @NonNull String data;

  @OneToMany(cascade = ALL)
  //@OneToMany(fetch = EAGER, cascade = ALL)
  List<Car> car = new ArrayList<>();
}
