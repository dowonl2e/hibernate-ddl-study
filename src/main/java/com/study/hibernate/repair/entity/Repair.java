package com.study.hibernate.repair.entity;

import com.study.hibernate.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("수리")
@Table(name = "tb_repair")
public class Repair {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "repair_no", nullable = false)
  private Long repairNo;
  @Comment("수리제품명")
  @Column(name = "repair_nm", nullable = false, length = 90)
  private String repairNm;
  @Comment("요청일")
  @Column(name = "repair_req_dt", columnDefinition = "DATETIME")
  private LocalDateTime repairReqDt;
  @Comment("완료예상일")
  @Column(name = "repair_due_dt", columnDefinition = "DATETIME")
  private LocalDateTime repairDueDt;
  @Comment("완료일")
  @Column(name = "repair_res_dt", columnDefinition = "DATETIME")
  private LocalDateTime repairResDt;
  @Comment("수리내용")
  @Column(name = "repair_desc", length = 3000)
  private String repairDesc;
  @Comment("고객번호FK")
  @Column(name = "customer_no")
  private Long customerNo;
  @Comment("고객명")
  @Column(name = "customer_nm")
  private String customerNm;
  @Comment("고객연락처")
  @Column(name = "customer_cel")
  private String customerCel;
  @Comment("삭제여부")
  @ColumnDefault("'N'")
  @Column(name = "del_yn", nullable = false, length = 4)
  private String delYn = "N";
  @Comment("등록자")
  @Column(name = "inpt_id", nullable = false, length = 30)
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
   * 수리, 고객 FK
   * Repair : Customer = N : 1
   * - 고객번호(customer_no) FK
   */
  @ManyToOne
  @JoinColumn(
      name = "customer_no", referencedColumnName = "customer_no"
      , insertable = false, updatable = false
  )
  private Customer customer;
}
