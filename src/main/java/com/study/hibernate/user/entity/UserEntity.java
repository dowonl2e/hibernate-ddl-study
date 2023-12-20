package com.study.hibernate.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Comment("사용자")
@Table(name = "tb_user")
public class UserEntity {
  @Id
  @Comment("PK")
  @Column(name = "user_id", nullable = false, length = 30)
  private String userId;
  @Comment("비밀번호")
  @Column(name = "user_pwd", nullable = false, length = 500)
  private String userPwd;
  @Comment("사용자명")
  @Column(name = "user_name", nullable = false, length = 100)
  private String userName;
  @Comment("역할")
  @Column(name = "user_role", nullable = false, length = 10)
  private String userRole;
  @Comment("이메일")
  @Column(name = "email", length = 40)
  private String email;
  @Comment("연락처")
  @Column(name = "celnum", length = 10)
  private String celnum;
  @Comment("성별")
  @Column(name = "gender")
  private String gender;
  @Comment("사용여부")
  @Column(name = "use_yn", nullable = false, length = 1)
  private String useYn;
  @Comment("가입자")
  @Column(name = "inpt_id", length = 30)
  private String inptId;
  @Comment("가입일")
  @Column(name = "inpt_dt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime inptDt = LocalDateTime.now();
  @Comment("수정자")
  @Column(name = "updt_id", length = 30)
  private String updtId;
  @Comment("수정일")
  @Column(name = "updt_dt", columnDefinition = "DATETIME")
  private LocalDateTime updtDt;
  @Comment("마지막로그인일")
  @Column(name = "last_login_dt", columnDefinition = "DATETIME")
  private LocalDateTime lastLoginDt;
}
