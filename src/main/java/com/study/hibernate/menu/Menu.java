package com.study.hibernate.menu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("메뉴")
@Table(name = "tb_menu")
public class Menu {
  @Id
  @Comment("PK")
  @Column(name = "menu_id", length = 20, nullable = false)
  private String menuId;
  @Comment("메뉴명")
  @Column(name = "menu_nm", length = 100, nullable = false)
  private String menuNm;
  @Comment("링크")
  @Column(name = "menu_link", length = 200)
  private String menuLink;
  @Comment("순번")
  @ColumnDefault("1")
  @Column(name = "menu_ord")
  private Integer menuOrd;
  @Comment("상위메뉴ID")
  @ColumnDefault("00")
  @Column(name = "up_menu_id", length = 20)
  private String upMenuId;
  @Comment("뎁스")
  @ColumnDefault("1")
  @Column(name = "menu_depth")
  private Integer menuDepth;
  @Comment("사용여부")
  @ColumnDefault("'N'")
  @Column(name = "use_yn", length = 1)
  private String useYn;
  @Comment("등록자")
  @Column(name = "inpt_id", length = 30)
  private String inptId;
  @Comment("등록일")
  @Column(name = "inpt_dt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime inptDt = LocalDateTime.now();
  @Comment("수정자")
  @Column(name = "updt_id", length = 30)
  private String updtId;
  @Comment("수정일")
  @Column(name = "updt_dt", columnDefinition = "DATETIME")
  private LocalDateTime updtDt;
}
