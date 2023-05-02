package com.assignment.daofab.service;

import com.assignment.daofab.exception.ChildTransactionFetchingException;
import com.assignment.daofab.exception.InvalidParentIdException;
import com.assignment.daofab.exception.ParentTransactionFetchingException;
import com.assignment.daofab.response.ChildTransactionsResponse;
import com.assignment.daofab.response.ParentTransactionsResponse;

import java.util.Set;

/**
 * @author Harkirat Singh Lamba
 */
public interface ITransactionService {

	Set<ParentTransactionsResponse> getParentTransactions(int page, int size) throws ParentTransactionFetchingException;

	Set<ChildTransactionsResponse> getChildTransactions(long parentId) throws InvalidParentIdException, ChildTransactionFetchingException;

}
