package entities.domain;

import java.time.LocalDate;

public class Installment {

	private LocalDate dueDate;
	private Double amount;
	
	public Installment(LocalDate dueDate, double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	public String toString() {
		return dueDate + " - " + String.format("%.2f", amount);
	}
}
