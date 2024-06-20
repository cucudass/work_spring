package com.lgy.item_std_oracle.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface ItemDAO {
	public ArrayList<ItemDAO> list();
	public void insert(HashMap<String, String> param);
}