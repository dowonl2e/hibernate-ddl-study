package com.study.hibernate.stock.entity;

import com.study.hibernate.catalog.entity.Catalog;
import com.study.hibernate.customer.entity.Customer;
import com.study.hibernate.vender.entity.Vender;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("재고")
@Table(name = "tb_stock")
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  @Column(name = "stock_no", nullable = false)
  private Long stockNo;
  @Comment("등록일_수동")
  @Column(name = "reg_dt", columnDefinition = "DATETIME ")
  private LocalDateTime regDt;
  @Comment("재고구분")
  @Column(name = "stock_type_cd", length = 10)
  private String stockTypeCd;
  @Comment("매장구분")
  @Column(name = "store_cd", length = 10)
  private String storeCd;
  @Comment("실제 구매 순금 시세/g")
  @Column(name = "real_pch_gold_price")
  private Integer realPchGoldPrice;
  @Comment("카다로그번호FK")
  @Column(name = "catalog_no")
  private Long catalogNo;
  @Comment("모델ID")
  @Column(name = "model_id", length = 100)
  private String modelId;
  @Comment("거래처번호FK")
  @Column(name = "vender_no")
  private Long venderNo;
  @Comment("거래처명")
  @Column(name = "vender_nm", length = 120)
  private String venderNm;
  @Comment("재질")
  @Column(name = "material_cd", length = 10)
  private String materialCd;
  @Comment("색상")
  @Column(name = "color_cd", length = 10)
  private String colorCd;
  @Comment("메인스톤")
  @Column(name = "main_stone_type", length = 60)
  private String mainStoneType;
  @Comment("보조스톤")
  @Column(name = "sub_stone_type", length = 60)
  private String subStoneType;
  @Comment("사이즈")
  @Column(name = "size", length = 60)
  private String size;
  @Comment("기타설명")
  @Column(name = "stock_desc", length = 2000)
  private String stockDesc;
  @Comment("수량")
  @ColumnDefault("1")
  @Column(name = "quantity")
  private Integer quantity;
  @Comment("개당중량(g)_중량")
  @Column(name = "per_weight_gram")
  private Double perWeightGram;
  @Comment("개당구매가(금값포함)_기본")
  @Column(name = "per_price_basic")
  private Integer perPriceBasic;
  @Comment("개당구매가(금값포함)_실질")
  @Column(name = "per_price_add")
  private Integer perPriceAdd;
  @Comment("개당구매가(금값포함)_실질")
  @Column(name = "per_price_main")
  private Integer perPriceMain;
  @Comment("개당구매가(금값포함)_실질")
  @Column(name = "per_price_sub")
  private Integer perPriceSub;
  @Comment("개당구매가(금값포함)_실질")
  @Column(name = "per_price_gold_real")
  private Integer perPriceGoldReal;
  @Comment("배수")
  @Column(name = "multiple_cnt")
  private Integer multipleCnt;
  @Comment("판매여부")
  @ColumnDefault("'N'")
  @Column(name = "sale_yn", nullable = false, length = 4)
  private String saleYn;
  @Comment("판매일")
  @Column(name = "sale_dt", columnDefinition = "DATETIME")
  private LocalDateTime saleDt;
  @Comment("판매금액")
  @Column(name = "sale_price")
  private Integer salePrice;
  @Comment("결제구분")
  @Column(name = "rec_pay_type_cd", length = 10)
  private String recPayTypeCd;
  @Comment("카드금액")
  @Column(name = "card_price")
  private Integer cardPrice;
  @Comment("현금금액")
  @Column(name = "cash_price")
  private Integer cashPrice;
  @Comment("고금금액")
  @Column(name = "maint_price")
  private Integer maintPrice;
  @Comment("포인트금액")
  @Column(name = "pnt_price")
  private Integer pntPrice;
  @Comment("기타금액")
  @Column(name = "etc_price")
  private Integer etcPrice;
  @Comment("획득포인트")
  @Column(name = "accu_pnt")
  private Integer accuPnt;
  @Comment("고객번호")
  @Column(name = "customer_no")
  private Long customerNo;
  @Comment("고객명")
  @Column(name = "customer_nm")
  private String customerNm;
  @Comment("주문여부")
  @ColumnDefault("'N'")
  @Column(name = "order_yn", nullable = false, length = 4)
  private String orderYn;
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
   * 재고, 카다로그 FK
   * Stock : Catalog = N : 1
   * - 카다로그번호(catalog_no) FK
   */
  @ManyToOne
  @JoinColumn(
      name = "catalog_no", referencedColumnName = "catalog_no"
      , insertable = false, updatable = false
  )
  private Catalog catalog;

  /**
   * 재고, 거래처 FK
   * Stock : Vender = N : 1
   * - 거래처번호(vender_no) FK
   */
  @ManyToOne
  @JoinColumn(
      name = "vender_no", referencedColumnName = "vender_no"
      , insertable = false, updatable = false
  )
  private Vender vender;

  /**
   * 재고, 고객 FK
   * Stock : Customer = N : 1
   * - 고객번호(customer_no) FK
   */
  @ManyToOne
  @JoinColumn(
      name = "customer_no", referencedColumnName = "customer_no"
      , insertable = false, updatable = false
  )
  private Customer customer;
}
