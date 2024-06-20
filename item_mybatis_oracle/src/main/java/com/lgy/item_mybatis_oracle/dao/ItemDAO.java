package com.lgy.item_mybatis_oracle.dao;

import java.util.ArrayList;

public interface ItemDAO {
	public ArrayList<ItemDAO> list();
	public void insert(String name, int price, String description);
}