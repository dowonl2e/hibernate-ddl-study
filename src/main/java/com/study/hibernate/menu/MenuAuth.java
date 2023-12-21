package com.study.hibernate.menu;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("메뉴권한")
@Table(name = "tb_menu_auth")
public class MenuAuth {
  @EmbeddedId
  private MenuAuthPK menuAuthPK;

  @Comment("접근권한")
  @ColumnDefault("'N'")
  @Column(name = "access_auth", nullable = false, length = 1)
  private String accessAuth;
  @Comment("쓰기권한")
  @ColumnDefault("'N'")
  @Column(name = "write_auth", nullable = false, length = 1)
  private String writeAuth;
  @Comment("조회권한")
  @ColumnDefault("'N'")
  @Column(name = "view_auth", nullable = false, length = 1)
  private String viewAuth;
  @Comment("수정권한")
  @ColumnDefault("'N'")
  @Column(name = "modify_auth", nullable = false, length = 1)
  private String modifyAuth;
  @Comment("삭제권한")
  @ColumnDefault("'N'")
  @Column(name = "remove_auth", nullable = false, length = 1)
  private String removeAuth;
  @Comment("등록자")
  @Column(name = "inpt_id", nullable = false, length = 30)
  private String inptId;
  @Comment("등록일")
  @Column(name = "inpt_dt", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime inptDt = LocalDateTime.now();
  @Comment("수정자")
  @Column(name = "updt_id", length = 30)
  private String updtId;
  @Comment("수정일")
  @Column(name = "updt_dt", columnDefinition = "DATETIME")
  private LocalDateTime updtDt;
}
