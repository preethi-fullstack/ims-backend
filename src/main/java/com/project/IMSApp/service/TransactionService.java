
package com.project.IMSApp.service;

import com.project.IMSApp.dto.TransactionRequest;
import com.project.IMSApp.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionRequest request);
    TransactionDto getTransactionById(Long id);
    List<TransactionDto> getAllTransactions();
}
