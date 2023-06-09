package com.assignment.daofab.exception;

/**
 * @author Harkirat Singh Lamba
 */
public class ParentTransactionFetchingException extends Exception {

    private static final long serialVersionUID = 1L;

    public ParentTransactionFetchingException() {
        super("Exception fetching parent transactions.");
    }

    public ParentTransactionFetchingException(String message) {
        super(message);
    }
}
