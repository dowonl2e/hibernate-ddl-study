package com.study.hibernate.vender.entity;

import com.study.hibernate.catalog.entity.Catalog;
import com.study.hibernate.order.entity.Order;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 거래처(Vender) Entity
 * 테이블명 : vender_tb
 * 외래키
 *  1. 없음
 * 인덱스
 *  1. 없음
 */
@Entity
@Getter
@Comment("거래처")
@Table(name = "vender_tb")
public class Vender {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "vender_no", nullable = false)
  private Long venderNo;
  @Comment("제조사명")
  @Column(name = "vender_nm", nullable = false, length = 120)
  private String venderNm;
  @Comment("사업자명")
  @Column(name = "business_nm", length = 120)
  private String businessNm;
  @Comment("대표자_연락처")
  @Column(name = "agent_cel", length = 50)
  private String agentCel;
  @Comment("부가세적용코드")
  @Column(name = "vat_cd", length = 20)
  private String vatCd;
  @Comment("매입해리")
  @Column(name = "melt_cd", length = 20)
  private String meltCd;
  @Comment("팩스번호")
  @Column(name = "vender_fax", length = 50)
  private String venderFax;
  @Comment("연락처1")
  @Column(name = "vender_cel1", length = 50)
  private String venderCel1;
  @Comment("연락처2")
  @Column(name = "vender_cel2", length = 50)
  private String venderCel2;
  @Comment("담당자명")
  @Column(name = "manager_nm", length = 120)
  private String managerNm;
  @Comment("담당자_연락처")
  @Column(name = "manager_cel", length = 50)
  private String managerCel;
  @Comment("담당자_이메일")
  @Column(name = "manager_email", length = 120)
  private String managerEmail;
  @Comment("비고")
  @Column(name = "etc", length = 2000)
  private String etc;
  @Comment("통상처")
  @Column(name = "commerce", length = 300)
  private String commerce;
  @Comment("삭제여부")
  @ColumnDefault("'N'")
  @Column(name = "del_yn", nullable = false, length = 4)
  private String delYn;
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
   * Vender : Catalog = 1:N
   * - 거래처번호(vender_no) FK
   */
  @OneToMany(mappedBy = "vender")
  private List<Catalog> catalogs = new ArrayList<>();

  /**
   * Vender : Order = 1:N
   * - 거래처번호(vender_no) FK
   */
  @OneToMany(mappedBy = "vender")
  private List<Order> orders = new ArrayList<>();

}
