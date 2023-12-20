package com.study.hibernate.vender.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("거래처결제")
@Table(name = "tb_vender_pay")
public class VenderPay {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "pay_no", nullable = false)
  private Long payNo;
  @Comment("거래처번호FK")
  @Column(name = "vender_no", nullable = false)
  private Long venderNo;
  @Comment("등록일_수동")
  @Column(name = "reg_dt", columnDefinition = "DATETIME")
  private LocalDateTime regDt;
  @Comment("매장코드")
  @Column(name = "store_cd", length = 10)
  private String storeCd;
  @Comment("예정순금결제중량")
  @Column(name = "expt_gold_gram")
  private Double exptGoldGram;
  @Comment("예정공임결제금액")
  @Column(name = "expt_pay_price")
  private Integer exptPayPrice;
  @Comment("진행순금결제중량")
  @ColumnDefault("0")
  @Column(name = "prg_gold_gram", nullable = false)
  private Double prgGoldGram;
  @Comment("진행공인결제중량")
  @ColumnDefault("0")
  @Column(name = "prg_pay_price", nullable = false)
  private Integer prgPayPrice;
  @Comment("비고")
  @Column(name = "pay_etc", length = 2000)
  private String payEtc;
  @Comment("삭제여부")
  @ColumnDefault("'N'")
  @Column(name = "del_yn", length = 1, nullable = false)
  private String delYn;
  @Comment("PK")
  @Column(name = "inpt_id", length = 30, nullable = false)
  private String inptId;
  @Comment("PK")
  @Column(name = "inpt_dt", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime inptDt = LocalDateTime.now();
  @Comment("수정자")
  @Column(name = "updt_id", length = 30)
  private String updtId;
  @Comment("수정일")
  @Column(name = "updt_dt", columnDefinition = "DATETIME")
  private LocalDateTime updtDt;

  /**
   * 거래처결제, 거래처 FK
   * VenderPay : Vender : N : 1
   * - 거래처번호(vender_no) FK
   */
  @ManyToOne
  @JoinColumn(
      name = "vender_no", referencedColumnName = "vender_no"
      , insertable = false, updatable = false
  )
  private Vender vender;
}
