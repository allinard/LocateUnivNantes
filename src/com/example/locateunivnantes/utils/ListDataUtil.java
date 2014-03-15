package com.example.locateunivnantes.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListDataUtil {

	public static void prepareListData(List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {

		// Adding child data
		listDataHeader.add("Bât. 14");
		listDataHeader.add("Bât. 15");
		listDataHeader.add("Bât. 26");

		// Adding child data
		List<String> bat14 = new ArrayList<String>();
		bat14.add("i01");
		bat14.add("i02");
		bat14.add("i03");
		bat14.add("i11");
		bat14.add("i12");
		bat14.add("i19");
		bat14.add("i21");
		bat14.add("i22");
		bat14.add("i23");

		List<String> bat15 = new ArrayList<String>();
		bat15.add("42");
		bat15.add("43");
		bat15.add("46");
		bat15.add("49");

		List<String> bat26 = new ArrayList<String>();
		bat26.add("100");
		bat26.add("101");
		bat26.add("102");
		bat26.add("103");
		bat26.add("110");
		bat26.add("111");
		bat26.add("112");
		bat26.add("113");
		bat26.add("201");
		bat26.add("202");
		bat26.add("203");
		bat26.add("204");
		bat26.add("205");

		listDataChild.put(listDataHeader.get(0), bat14); // Header, Child data
		listDataChild.put(listDataHeader.get(1), bat15);
		listDataChild.put(listDataHeader.get(2), bat26);
	}
}
