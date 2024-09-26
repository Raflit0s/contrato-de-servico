package service;

import java.time.LocalDate;

import entities.domain.Contract;
import entities.domain.Installment;

public class ContractService {
	private OnlinePaymentService ops;

	public ContractService() {
	}
	
	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract, Integer months) {
		
		for(int i=1; i<=months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			Double amount1 = contract.getTotalValue() / months;
			Double amount2 = ops.interest(amount1, i);
			Double amount3 = ops.paymentFee(amount2);
			Installment install = new Installment(dueDate, amount3);
			contract.getInstallments().add(install);
		}
	}
}
