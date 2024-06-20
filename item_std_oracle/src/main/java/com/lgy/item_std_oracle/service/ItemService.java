package com.lgy.item_std_oracle.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.item_std_oracle.dao.ItemDAO;

public interface ItemService {
	public ArrayList<ItemDAO> list();
	public void insert(HashMap<String, String> param);
}