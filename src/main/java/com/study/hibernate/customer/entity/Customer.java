package com.study.hibernate.customer.entity;

import com.study.hibernate.order.entity.Order;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Comment("고객")
@Table(name = "customer_tb")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "customer_no", nullable = false)
  private Long customerNo;
  @Comment("매장코드")
  @Column(name = "store_cd", length = 30)
  private String storeCd;
  @Comment("계약코드")
  @Column(name = "contract_cd", length = 30)
  private String contractCd;
  @Comment("우편번호")
  @Column(name = "zipcode", length = 30)
  private String zipcode;
  @Comment("주소1")
  @Column(name = "address1", length = 400)
  private String address1;
  @Comment("주소2")
  @Column(name = "address2", length = 400)
  private String address2;
  @Comment("비고")
  @Column(name = "etc", length = 2000)
  private String etc;
  @Comment("이름")
  @Column(name = "contractor_nm", length = 80)
  private String contractorNm;
  @Comment("성별")
  @Column(name = "contractor_gen", length = 30)
  private String contractorGen;
  @Comment("연락처")
  @Column(name = "contractor_cel", length = 90)
  private String contractorCel;
  @Comment("생일")
  @Column(name = "contractor_birth", length = 60)
  private String contractorBirth;
  @Comment("음력여부")
  @Column(name = "contractor_lunar", length = 10)
  private String contractorLunar;
  @Comment("이메일")
  @Column(name = "contractor_email", length = 30)
  private String contractorEmail;
  @Comment("삭제여부")
  @ColumnDefault("'N'")
  @Column(name = "del_yn", nullable = false, length = 4)
  private String delYn = "N";
  @Comment("등록일_수동")
  @Column(name = "reg_dt")
  private LocalDateTime regDt;
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
   * Customer : Order = 1:N
   * - 고객번호(customer_no) FK
   */
  @OneToMany(mappedBy = "customer")
  private List<Order> orders = new ArrayList<>();

}
