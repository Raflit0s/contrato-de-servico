package teste14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.domain.Contract;
import entities.domain.Installment;
import service.ContractService;
import service.PaypalService;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (dd/MM/yyyy): ");
		String input = sc.nextLine();
		LocalDate date = LocalDate.parse(input, fmt);
		System.out.print("Valor do contrato: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		Integer months = sc.nextInt();
		
		Contract con = new Contract(number, date, totalValue);
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(con, months);
		
		System.out.println("Parcelas:");
		for(Installment x:con.getInstallments()) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
