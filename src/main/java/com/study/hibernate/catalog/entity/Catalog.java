package com.study.hibernate.catalog.entity;

import com.study.hibernate.vender.entity.Vender;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(
    name = "catalog_tb",
    indexes = @Index(name = "catalog_tb_idx1", columnList = "model_id")
)
public class Catalog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "catalog_no", nullable = false, columnDefinition = "BIGINT COMMENT '카다로그PK'")
  private Long catalogNo;
  @Column(name = "vender_no", columnDefinition = "BIGINT COMMENT '제조사FK'")
  private Long venderNo;
  @Column(name = "model_id", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '모델번호'")
  private String modelId;
  @Column(name = "model_nm", columnDefinition = "VARCHAR(200) COMMENT '모델명'")
  private String modelNm;
  @Column(name = "stdd_material_cd", columnDefinition = "VARCHAR(20) COMMENT '표준재질'")
  private String stddMaterialCd;
  @Column(name = "stdd_weight", columnDefinition = "VARCHAR(40) COMMENT '표준중량'")
  private String stddWeight;
  @Column(name = "stdd_color_cd", columnDefinition = "VARCHAR(20) COMMENT '표준색상'")
  private String stddColorCd;
  @Column(name = "stdd_size", columnDefinition = "VARCHAR(80) COMMENT '표준사이즈'")
  private String stddSize;
  @Column(name = "odr_notice", columnDefinition = "VARCHAR(2000) COMMENT '유의사항'")
  private String odrNotice;
  @CreationTimestamp
  @Column(name = "reg_dt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '등록일_수동'")
  private String regDt;
  @Column(name = "basic_idst", columnDefinition = "INT COMMENT '기본공임'")
  private Integer basicIdst;
  @Column(name = "main_price", columnDefinition = "INT COMMENT '메인가격'")
  private Integer mainPrice;
  @Column(name = "sub_price", columnDefinition = "INT COMMENT '보조가격'")
  private Integer subPrice;
  @Column(name = "total_price", columnDefinition = "INT COMMENT '전체구매단가'")
  private Integer totalPrice;

  @ColumnDefault("'N'")
  @Column(name = "del_yn", nullable = false, columnDefinition = "VARCHAR(4) COMMENT '삭제여부'")
  private String delYn = "N";
  @Column(name = "inpt_id", nullable = false, columnDefinition = "VARCHAR(30) COMMENT '등록자'")
  private String inptId;
  @CreationTimestamp
  @Column(name = "inpt_dt", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '등록일'")
  private LocalDateTime inptDt = LocalDateTime.now();
  @Column(name = "updt_id", columnDefinition = "VARCHAR(30) COMMENT '수정자'")
  private String updtId;
  @UpdateTimestamp
  @Column(name = "updt_dt", columnDefinition = "DATETIME COMMENT '수정일'")
  private LocalDateTime updtDt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "vender_no", referencedColumnName = "vender_no"
      , insertable = false, updatable = false
  )
  private Vender vender;

}
