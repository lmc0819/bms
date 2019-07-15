package com.book.entity;

public class BookCount {
	private long count;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public BookCount(long count) {
		super();
		this.count = count;
	}

	public BookCount() {
		super();
	}

	@Override
	public String toString() {
		return "BookCount [count=" + count + "]";
	}

}
