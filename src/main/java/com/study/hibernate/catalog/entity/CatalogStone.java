package com.study.hibernate.catalog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("카다로그_스톤")
@Table(name = "tb_catalog_stone")
public class CatalogStone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "stone_no", nullable = false)
  private Long stoneNo;
  @Comment("카다로그번호FK")
  @Column(name = "catalog_no", nullable = false)
  private Long catalogNo;
  @Comment("스톤구분")
  @Column(name = "stone_type_cd", length = 10)
  private String stoneTypeCd;
  @Comment("스톤명")
  @Column(name = "stone_nm", length = 200)
  private String stoneNm;
  @Comment("알수")
  @ColumnDefault("0")
  @Column(name = "bead_cnt", nullable = false)
  private Integer beadCnt;
  @Comment("구매단가")
  @ColumnDefault("'0'")
  @Column(name = "purchase_price", length = 20, nullable = false)
  private String purchasePrice;
  @Comment("스톤설명")
  @Column(name = "stone_desc", length = 2000)
  private String stoneDesc;
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

  /**
   * 카다로그스톤, 카다로그 FK
   * CatalogStone : Catalog = N : 1
   * - 카다로그번호(catalog_no) FK
   */
  @ManyToOne
  @JoinColumn(
      name = "catalog_no", referencedColumnName = "catalog_no"
      , insertable = false, updatable = false
  )
  private Catalog catalog;
}
