package com.study.hibernate.cash.entity;

import com.study.hibernate.vender.entity.Vender;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("금_현금")
@Table(name = "tb_cash")
public class Cash {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "cash_no", nullable = false)
  private Long cashNo;
  @Comment("등록일_수동")
  @Column(name = "reg_dt", columnDefinition = "DATETIME")
  private LocalDateTime regDt;
  @Comment("매장구분")
  @Column(name = "store_cd", length = 10)
  private String storeCd;
  @Comment("금현금구분")
  @Column(name = "cash_type_cd", length = 10)
  private String cashTypeCd;
  @Comment("계정구분")
  @Column(name = "cash_type_cd2", length = 10)
  private String cashTypeCd2;
  @Comment("통장구분")
  @Column(name = "bankbook_cd", length = 10)
  private String bankbookCd;
  @Comment("거래처번호FK")
  @Column(name = "vender_no")
  private Long venderNo;
  @Comment("거래처명")
  @Column(name = "vender_nm", length = 120)
  private String venderNm;
  @Comment("내역")
  @Column(name = "history_desc", length = 1000)
  private String historyDesc;
  @Comment("재질")
  @Column(name = "material_cd", length = 10)
  private String materialCd;
  @Comment("중량(g)")
  @Column(name = "weight_gram")
  private Double weightGram;
  @Comment("수량")
  @ColumnDefault("1")
  @Column(name = "quantity", nullable = false)
  private Integer quantity;
  @Comment("단가")
  @Column(name = "unit_price")
  private Integer unitPrice;
  @Comment("삭제여부")
  @ColumnDefault("'N'")
  @Column(name = "del_yn", length = 1, nullable = false)
  private String delYn = "N";
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

  @ManyToOne
  @JoinColumn(
      name = "vender_no", referencedColumnName = "vender_no"
      , insertable = false, updatable = false
  )
  private Vender vender;

}
