package com.study.hibernate.order.entity;

import com.study.hibernate.customer.entity.Customer;
import com.study.hibernate.vender.entity.Vender;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("주문")
@Table(name = "order_tb")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "order_no", nullable = false)
  private Long orderNo;
  @Comment("주문구분(CUSTOMER:고객주문 / READMADE:기성주문)")
  @Column(name = "order_type", length = 10)
  private String orderType;
  @Comment("매장코드")
  @Column(name = "store_cd", length = 20)
  private String storeCd;
  @Comment("접수일")
  @Column(name = "receipt_dt", columnDefinition = "DATETIME")
  private LocalDateTime receiptDt;
  @Comment("주문예상일")
  @Column(name = "expected_ord_dt", columnDefinition = "DATETIME")
  private LocalDateTime expectedOrdDt;
  @Comment("고객번호FK")
  @Column(name = "customer_no")
  private Long customerNo;
  @Comment("고객명")
  @Column(name = "customer_nm", length = 80)
  private String customerNm;
  @Comment("고객연락처")
  @Column(name = "customer_cel", length = 50)
  private String customerCel;
  @Comment("주문단계")
  @ColumnDefault("'A'")
  @Column(name = "order_step", length = 4)
  private String orderStep;
  @Comment("시리얼ID")
  @Column(name = "serial_id", length = 60)
  private String serialId;
  @Comment("카다로그번호FK")
  @Column(name = "catalog_no")
  private Long catalogNo;
  @Comment("모델번호")
  @Column(name = "model_id", length = 100)
  private String modelId;
  @Comment("거래처번호FK")
  @Column(name = "vender_no")
  private Long venderNo;
  @Comment("거래처명")
  @Column(name = "vender_nm", length = 120)
  private String venderNm;
  @Comment("재질코드")
  @Column(name = "material_cd", length = 20)
  private String materialCd;
  @Comment("색상코드")
  @Column(name = "color_cd", length = 20)
  private String colorCd;
  @Comment("수량")
  @ColumnDefault("1")
  @Column(name = "quantity")
  private Integer quantity;
  @Comment("메인스톤")
  @Column(name = "main_stone_type", length = 60)
  private String mainStoneType;
  @Comment("보조스톤")
  @Column(name = "sub_stone_type", length = 60)
  private String subStoneType;
  @Comment("사이즈")
  @Column(name = "size", length = 60)
  private String size;
  @Comment("재고번호FK")
  @Column(name = "stock_no")
  private Long stockNo;
  @Comment("주문설명")
  @Column(name = "order_desc", length = 2000)
  private String orderDesc;
  @Comment("삭제여부")
  @ColumnDefault("'N'")
  @Column(name = "del_yn", length = 4, nullable = false)
  private String delYn = "N";
  @Comment("등록자")
  @Column(name = "inpt_id", length = 30, nullable = false)
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
   * Order : Customer = N:1
   * - 고객번호(customer_no) FK
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "customer_no", referencedColumnName = "customer_no"
      , insertable = false, updatable = false
  )
  private Customer customer;

  /**
   * Order : Vender = N:1
   * - 거레처번호(vender_no) FK
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "vender_no", referencedColumnName = "vender_no"
      , insertable = false, updatable = false
  )
  private Vender vender;
}
