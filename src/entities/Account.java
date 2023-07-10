package entities;

import enumType.TypeAccount;

public class Account {

	private String name;
	private Integer numberAccount;
	private Integer numberAgency;
	private Double balance;
	private TypeAccount type;

	public Account() {
	}

	public Account(String name, Integer numberAccount, Integer numberAgency, Double balance, TypeAccount type) {
		this.name = name;
		this.numberAccount = numberAccount;
		this.numberAgency = numberAgency;
		this.balance = balance;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Integer numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Integer getNumberAgency() {
		return numberAgency;
	}

	public void setNumberAgency(Integer numberAgency) {
		this.numberAgency = numberAgency;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public TypeAccount getType() {
		return type;
	}

	public void setType(TypeAccount type) {
		this.type = type;
	}

	public String open() {
		return "Nome: " + name + ", Número da Conta: " + numberAccount + ", Número da Agência: " + numberAgency
				+ ", Tipo de Conta: " + type;
	}
	
	public void addBalance(double amount) {
		balance += amount;	
	}
	
	public void removeBalance(double amount) {
		balance -= amount;
	}
}
