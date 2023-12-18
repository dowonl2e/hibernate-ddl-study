package com.study.hibernate.vender.entity;

import com.study.hibernate.catalog.entity.Catalog;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "vender_tb")
public class Vender {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vender_no", nullable = false, columnDefinition = "BIGINT COMMENT '제조사PK'")
  private Long venderNo;
  @Column(name = "vender_nm", nullable = false, columnDefinition = "VARCHAR(120) COMMENT '제조사명'")
  private String venderNm;
  @Column(name = "business_nm", columnDefinition = "VARCHAR(120) COMMENT '사업자명'")
  private String businessNm;
  @Column(name = "agent_cel", columnDefinition = "VARCHAR(50) COMMENT '대표자_연락처'")
  private String agentCel;
  @Column(name = "vat_cd", columnDefinition = "VARCHAR(20) COMMENT '부가세적용률'")
  private String vatCd;
  @Column(name = "melt_cd", columnDefinition = "VARCHAR(20) COMMENT '매입해라'")
  private String meltCd;
  @Column(name = "vender_fax", columnDefinition = "VARCHAR(50) COMMENT '팩스번호'")
  private String venderFax;
  @Column(name = "vender_cel1", columnDefinition = "VARCHAR(50) COMMENT '연락처1'")
  private String venderCel1;
  @Column(name = "vender_cel2", columnDefinition = "VARCHAR(50) COMMENT '연락처2'")
  private String venderCel2;
  @Column(name = "manager_nm", columnDefinition = "VARCHAR(120) COMMENT '담당자명'")
  private String managerNm;
  @Column(name = "manager_cel", columnDefinition = "VARCHAR(50) COMMENT '담당자_연락처'")
  private String managerCel;
  @Column(name = "manager_email", columnDefinition = "VARCHAR(120) COMMENT '담당자_이메일'")
  private String managerEmail;
  @Column(name = "etc", columnDefinition = "VARCHAR(2000) COMMENT '비고'")
  private String etc;
  @Column(name = "commerce", columnDefinition = "VARCHAR(300) COMMENT '통상처'")
  private String commerce;
  @ColumnDefault("'N'")
  @Column(name = "del_yn", nullable = false, columnDefinition = "VARCHAR(4) COMMENT '삭제여부'")
  private String delYn;
  @Column(name = "inpt_id", nullable = false, columnDefinition = "VARCHAR(30) COMMENT '등록자'")
  private String inptId;
  @Column(name = "inpt_dt", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '등록일'")
  private LocalDateTime inptDt = LocalDateTime.now();
  @Column(name = "updt_id", columnDefinition = "VARCHAR(30) COMMENT '수정자'")
  private String updtId;
  @Column(name = "updt_dt", columnDefinition = "DATETIME COMMENT '수정일'")
  private LocalDateTime updtDt;

  @OneToMany(mappedBy = "vender")
  private List<Catalog> catalogs = new ArrayList<>();


}
