package com.assignment.daofab.component;

import com.assignment.daofab.dao.ITransactionDao;
import com.assignment.daofab.model.ChildTransaction;
import com.assignment.daofab.model.ParentTransaction;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This component is used to load the transaction data from Parent.json and Child.json
 * Json files are stored in "~/resources/json/" directory of the project.
 *
 * @author Harkirat Singh Lamba
 */
@Component
public class DataLoader {

	private final ITransactionDao transactionDao;

	public DataLoader(ITransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@PostConstruct
	private void loadData() {
		try {
			loadParentTransactions();
			loadChildTransactions();
		} catch (IOException e) {
			throw new RuntimeException("Exception loading transactions data.", e);
		}
	}

	private void loadParentTransactions() throws IOException {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("json/Parent.json")) {
			assert inputStream != null;
			String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			ParentTransactionData parentTransactionData = new Gson().fromJson(content, ParentTransactionData.class);
			List<ParentTransaction> parentTransactions = parentTransactionData.getData().stream().sorted(Comparator.comparing(ParentTransaction::getId)).collect(Collectors.toList());
			transactionDao.setParentTransactions(parentTransactions);
		}
	}

	private void loadChildTransactions() throws IOException {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("json/Child.json")) {
			assert inputStream != null;
			String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			ChildTransactionData childTransactionData = new Gson().fromJson(content, ChildTransactionData.class);
			Map<Long, List<ChildTransaction>> childTransactionsMap = childTransactionData.getData().stream().collect(Collectors.groupingBy(ChildTransaction::getParentId));
			transactionDao.setChildTransactionsMap(childTransactionsMap);
		}
	}

	private static class ParentTransactionData {
		private List<ParentTransaction> data;

		public List<ParentTransaction> getData() {
			return data;
		}
	}

	private static class ChildTransactionData {
		private List<ChildTransaction> data;

		public List<ChildTransaction> getData() {
			return data;
		}
	}
}
