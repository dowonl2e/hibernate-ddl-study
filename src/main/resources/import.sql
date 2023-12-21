--카다로그(tb_catalog) Full Text Index
CREATE FULLTEXT INDEX catalog_ft_idx1 ON tb_catalog (model_id, model_nm);

--재고(tb_stock) Full Text Index
CREATE FULLTEXT INDEX stock_ft_idx1 ON tb_stock (customer_nm, model_id);

--주문(tb_order) Full Text Index
CREATE FULLTEXT INDEX order_ft_idx1 ON tb_order (customer_nm, model_id, vender_nm);

--금/현금 Full Text Index
CREATE FULLTEXT INDEX cash_ft_idx1 ON tb_cash (vender_nm, history_desc);


