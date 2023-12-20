package com.study.hibernate.code.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Comment("코드")
@Table(
    name = "tb_code",
    indexes = @Index(name = "tb_code_idx1", columnList = "up_cd_id")
)
public class Code {
  @Id
  @Comment("PK")
  @Column(name = "cd_id", length = 10, nullable = false)
  private String cdId;
  @Comment("코드명")
  @Column(name = "cd_nm", length = 100, nullable = false)
  private String cdNm;
  @Comment("순번")
  @ColumnDefault("1")
  @Column(name = "cd_ord", nullable = false)
  private Integer cdOrd;
  @Comment("상위코드")
  @ColumnDefault("'00'")
  @Column(name = "up_cd_id", length = 20, nullable = false)
  private String upCdId;
  @Comment("뎁스")
  @ColumnDefault("1")
  @Column(name = "cd_depth", nullable = false)
  private Integer cdDepth;
  @Comment("코드내용")
  @Column(name = "cd_desc", length = 2000)
  private String cdDesc;
  @Comment("사용여부")
  @ColumnDefault("'Y'")
  @Column(name = "use_yn", length = 1)
  private String useYn;
  @Comment("등록자")
  @Column(name = "inpt_id", length = 30, nullable = false)
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
}
