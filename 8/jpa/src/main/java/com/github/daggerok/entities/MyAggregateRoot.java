package com.github.daggerok.entities;

import com.github.daggerok.entities.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.github.daggerok.entities.MyAggregateRoot.*;
import static javax.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PACKAGE;

@Data
@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ALL, query = " select me from MyAggregateRoot me order by me.createdAt desc "),
    @NamedQuery(name = FIND_BY_ID, query = " select me from MyAggregateRoot me where me.id = :id "),
    @NamedQuery(name = COUNT, query = " select count(me) from MyAggregateRoot me ")
})
@Table(name = "my_aggregate_root")
@NoArgsConstructor(access = PACKAGE)
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor(staticName = "of")
public class MyAggregateRoot extends BaseEntity {

  public static final String FIND_ALL = "MyAggregateRoot.findAll";
  public static final String FIND_BY_ID = "MyAggregateRoot.findOne";
  public static final String COUNT = "MyAggregateRoot.count";

  @NonNull String data;

  @OneToMany(fetch = EAGER)
  List<Car> car = new ArrayList<>();
}
