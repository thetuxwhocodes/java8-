package com.thetuxwhocodes.java8andbeyond.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamStuff {

	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();

		items.add(new Item(1, "ABC", true));
		items.add(new Item(2, "DEF", false));
		items.add(new Item(3, "GHI", true));
		items.add(new Item(4, "JKL", false));

		Map<Integer, Item> map = items.stream().collect(Collectors.toMap(Item::getId, item -> item));
		System.out.println(map);

		Map<Integer, Item> filteredMap = items.stream()
												.filter(Item::isIndicator)
												.collect(Collectors.toMap(Item::getId, item -> item));
		System.out.println(filteredMap);
	}

}

class Item {

	Integer id;
	String name;
	boolean indicator;

	public Item(Integer id, String name, boolean indicator) {
		super();
		this.id = id;
		this.name = name;
		this.indicator = indicator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIndicator() {
		return indicator;
	}

	public void setIndicator(boolean indicator) {
		this.indicator = indicator;
	}

	@Override
	public String toString() {

		return String.format("<Item: %d - %s>", id, name);
	}

}
