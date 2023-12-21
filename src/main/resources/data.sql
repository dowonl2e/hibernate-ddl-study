-- 카다로그 테스트 데이터 추가
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명1');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명2');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명3');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명4');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명5');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명6');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명7');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명8');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명9');
INSERT INTO tb_catalog (inpt_dt, del_yn, inpt_id, model_id) values (now(), 'N', 'admin', '모델명10');

-- 거래처 테스트 데이터 추가
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처1');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처2');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처3');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처4');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처5');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처6');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처7');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처8');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처9');
INSERT INTO tb_vender (inpt_dt, del_yn, inpt_id, vender_nm) values (now(), 'N', 'admin', '거래처10');

-- 주문 테스트 데이터 추가
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명1', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명2', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명3', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명4', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명5', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명6', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명7', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명8', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명9', 'N', now(), 'admin');
INSERT INTO tb_order (model_id, del_yn, inpt_dt, inpt_id) values ('모델명10', 'N', now(), 'admin');

