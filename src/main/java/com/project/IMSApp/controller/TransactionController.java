package com.project.IMSApp.controller;

import com.project.IMSApp.dto.TransactionRequest;
import com.project.IMSApp.dto.TransactionDto;
import com.project.IMSApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN', 'OWNER','STAFF')")
	public ResponseEntity<?> createTransaction(@RequestBody TransactionRequest request) {
		System.out.println("=== TRANSACTION CONTROLLER: CREATE ===");
		System.out.println("Request received:");
		System.out.println("  userId: " + request.getUserId());
		System.out.println("  productId: " + request.getProductId());
		System.out.println("  supplierId: " + request.getSupplierId());
		System.out.println("  quantity: " + request.getQuantity());
		System.out.println("  type: " + request.getType());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Authenticated user: " + auth.getName());
		System.out.println("Authorities: " + auth.getAuthorities());

		try {
			TransactionDto created = transactionService.createTransaction(request);
			System.out.println(" Transaction created successfully");
			return ResponseEntity.ok(created);
		} catch (Exception e) {
			System.out.println(" Error creating transaction: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error: " + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'STAFF')")
	public ResponseEntity<TransactionDto> getTransaction(@PathVariable Long id) {
		TransactionDto transaction = transactionService.getTransactionById(id);
		return ResponseEntity.ok(transaction);
	}

	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
	public ResponseEntity<List<TransactionDto>> getAllTransactions() {
		List<TransactionDto> transactions = transactionService.getAllTransactions();
		return ResponseEntity.ok(transactions);
	}
}