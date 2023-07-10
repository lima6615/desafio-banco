package aplicattion;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import enumType.TypeAccount;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Account> list = new ArrayList<>();
		TypeAccount type = null;

		System.out.println("******* Criar Sua Conta *******");
		System.out.print("Informe seu nome: ");
		String name = sc.nextLine();
		System.out.print("Numero de conta: ");
		Integer numberAccount = sc.nextInt();
		System.out.print("Numero da agencia: ");
		Integer numberAgency = sc.nextInt();

		try {
			System.out.print("Tipo de conta (CONTA_CORRENTE, CONTA_POUPANÇA, CONTA_SALARIO, CONTA_ENCERRADA): ");
			type = TypeAccount.valueOf(sc.next().toUpperCase());

		} catch (IllegalArgumentException e) {
			System.out.println();
			System.out.println("Tipo de conta não encontrada, por favor tente novamente!");
			System.exit(0);
		}

		Double balance = 0.0;
		if (type != TypeAccount.CONTA_ENCERRADA && type != TypeAccount.ENCERRADA) {
			System.out.print("Deseja creditar saldo na conta (SIM ou NAO) ?  ");
			sc.nextLine();
			String test = sc.nextLine().toUpperCase();

			if (!test.equals("NAO")) {
				System.out.print("Valor a ser creditado: ");
				balance = sc.nextDouble();
			}
		}

		Account acc = new Account(name, numberAccount, numberAgency, balance, type);
		list.add(acc);

		if (type.equals(TypeAccount.CONTA_ENCERRADA) || type.equals(TypeAccount.ENCERRADA)) {
			System.out.println();
			System.out.println(acc.open());
			System.out.println("Valor Saldo R$ " + String.format("%.2f", acc.getBalance()));
			System.exit(0);
		}

		System.out.println("---------------------------------------");
		System.out.println();
		System.out.println("Login de Acesso: ");
		System.out.print("Conta: ");
		numberAccount = sc.nextInt();
		System.out.print("Agencia: ");
		numberAgency = sc.nextInt();

		for (Account c : list) {

			if (numberAgency.equals(c.getNumberAgency()) && numberAccount.equals(c.getNumberAccount())) {
				System.out.println();
				System.out.println("Bem vindo em sua conta! ");
				System.out.println(c.open());
				System.out.println("Saldo R$ " + String.format("%.2f", c.getBalance()));

				int numero;
				do {

					System.out.println();
					System.out.println(" 1 - Fazer um Deposito.");
					System.out.println(" 2 - Fazer um Saquer.");
					System.out.println(" 3 - Sair da Conta.");

					System.out.println();
					System.out.print("Escolhar uma das opções: ");
					numero = sc.nextInt();

					switch (numero) {

					case 1: {
						System.out.print("Informe valor de deposito R$ ");
						double amount = sc.nextDouble();
						c.addBalance(amount);
						System.out.printf("SALDO ATUALIZADO: %.2f", c.getBalance());
						System.out.println();
						break;
					}

					case 2: {
						System.out.print("Informe valor de saquer R$ ");
						double amount = sc.nextDouble();
						c.removeBalance(amount);
						System.out.printf("SALDO ATUALIZADO: %.2f", c.getBalance());
						System.out.println();
						break;
					}

					case 3: {
						System.out.println("Login encerrado com sucesso!!");
						break;
					}

					default:
						System.out.println("Opção informada não encontrada por favor tente novamente.");
					}

				} while (numero != 3);

			} else {
				System.out.println();
				System.out.println("Agencia ou conta informada não existe no sistema!");
			}

			sc.close();
		}
	}
}
