package com.study.hibernate.menu;


import com.study.hibernate.user.entity.UserEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Data
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MenuAuthPK implements Serializable {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "user_id", nullable = false
      , insertable = false, updatable = false
  )
  private UserEntity user;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "menu_id", nullable = false
      , insertable = false, updatable = false
  )
  private Menu menu;
}
