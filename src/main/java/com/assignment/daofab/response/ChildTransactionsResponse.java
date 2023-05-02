package com.assignment.daofab.response;

import java.util.Objects;

/**
 * Used a Builder Design Pattern to create a ChildTransactionsResponse.
 *
 * @author Harkirat Singh Lamba
 */
public class ChildTransactionsResponse implements Comparable<ChildTransactionsResponse> {
	long id;
	String sender;
	String receiver;
	long totalAmount;
	long paidAmount;

	public Long getId() {
		return id;
	}

	public String getSender() {
		return sender;
	}

	public ChildTransactionsResponse setSender(String sender) {
		this.sender = sender;
		return this;
	}

	public String getReceiver() {
		return receiver;
	}

	public ChildTransactionsResponse setReceiver(String receiver) {
		this.receiver = receiver;
		return this;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public ChildTransactionsResponse setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public long getPaidAmount() {
		return paidAmount;
	}

	public ChildTransactionsResponse setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
		return this;
	}

	public ChildTransactionsResponse setChildId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChildTransactionsResponse other = (ChildTransactionsResponse) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(ChildTransactionsResponse o) {
		return this.getId().compareTo(o.getId());
	}
}
