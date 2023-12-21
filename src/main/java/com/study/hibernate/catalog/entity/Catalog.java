package com.study.hibernate.catalog.entity;

import com.study.hibernate.stock.entity.Stock;
import com.study.hibernate.vender.entity.Vender;
import jakarta.persistence.*;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 카다로그(Catalog) Entity
 * 테이블명 : catalog_tb
 * 외래키(Foreign Key)
 *  1. vender_tb(catalog_tb : vender_tb = n:1)
 *  2. Column : vender_no(pk)
 * 인덱스
 *  1. model_id
 */
@Entity
@Getter
@Comment("카다로그")
@Table(name = "tb_catalog")
public class Catalog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "catalog_no", nullable = false, columnDefinition = "BIGINT COMMENT '카다로그PK'")
  private Long catalogNo;
  @Comment("제조사FK")
  @Column(name = "vender_no")
  private Long venderNo;
  @Comment("모델번호")
  @Column(name = "model_id", nullable = false, length = 100)
  private String modelId;
  @Comment("모델명")
  @Column(name = "model_nm", length = 200)
  private String modelNm;
  @Comment("표준재질")
  @Column(name = "stdd_material_cd", length = 20)
  private String stddMaterialCd;
  @Comment("표준중량")
  @Column(name = "stdd_weight", length = 40)
  private String stddWeight;
  @Comment("표준색상")
  @Column(name = "stdd_color_cd", length = 20)
  private String stddColorCd;
  @Comment("표준사이즈")
  @Column(name = "stdd_size", length = 80)
  private String stddSize;
  @Comment("유의사항")
  @Column(name = "odr_notice", length = 2000)
  private String odrNotice;
  @Comment("등록일_수동")
  @Column(name = "reg_dt", columnDefinition = "DATETIME")
  private LocalDateTime regDt;
  @Comment("기본공임")
  @Column(name = "basic_idst")
  private Integer basicIdst;
  @Comment("메인가격")
  @Column(name = "main_price")
  private Integer mainPrice;
  @Comment("보조가격")
  @Column(name = "sub_price")
  private Integer subPrice;
  @Comment("전체구매단가")
  @Column(name = "total_price")
  private Integer totalPrice;
  @Comment("삭제여부")
  @ColumnDefault("'N'")
  @Column(name = "del_yn", nullable = false, length = 4)
  private String delYn = "N";
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

  /**
   * 카다로그스톤 FK
   * Catalog : CatalogStone = 1 : N
   * - 카다로그번호(catalog_no) FK
   */
  @OneToMany(mappedBy = "catalog")
  private List<CatalogStone> catalogStones = new ArrayList<>();

  /**
   * 카다로그, 고객 FK
   * Catalog : Vender = N:1
   * - 거래처번호(vender_no) FK
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "vender_no", referencedColumnName = "vender_no"
      , insertable = false, updatable = false
  )
  private Vender vender;

  /**
   * 재고 FK
   * Catalog : Stock = 1:N
   * - 카다로그번호(catalog_no) FK
   */
  @OneToMany(mappedBy = "catalog")
  private List<Stock> stocks = new ArrayList<>();
}
