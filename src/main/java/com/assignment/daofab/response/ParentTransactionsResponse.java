package com.assignment.daofab.response;

import java.util.Objects;

/**
 * Used a Builder Design Pattern to create a ParentTransactionsResponse.
 *
 * @author Harkirat Singh Lamba
 */
public class ParentTransactionsResponse implements Comparable<ParentTransactionsResponse> {
	long id;
	String sender;
	String receiver;
	long totalAmount;
	long totalPaidAmount;

	public Long getId() {
		return id;
	}

	public String getSender() {
		return sender;
	}

	public ParentTransactionsResponse setSender(String sender) {
		this.sender = sender;
		return this;
	}

	public String getReceiver() {
		return receiver;
	}

	public ParentTransactionsResponse setReceiver(String receiver) {
		this.receiver = receiver;
		return this;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public ParentTransactionsResponse setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public long getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public ParentTransactionsResponse setTotalPaidAmount(long totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
		return this;
	}

	public ParentTransactionsResponse setParentId(long id) {
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
		ParentTransactionsResponse other = (ParentTransactionsResponse) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(ParentTransactionsResponse o) {
		return this.getId().compareTo(o.getId());
	}
}
