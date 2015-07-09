package com.amos.service;

public interface ShopInfoMapper {

	public ShopInfo findByShopid(Integer shopid);
		
	public void insertShopInfo(ShopInfo info);
}
