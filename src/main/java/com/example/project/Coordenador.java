package com.example.project;

public class Coordenador {

    private String nome;
    private String cpf;
    private int idade;

    public Coordenador(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

	public String dadosCoodernador(){
		this.validarDados();		
				
		return String.format("%s (%d anos), CPF: %s",this.nome,this.idade,this.cpf);
	}

	private void validarDados(){
		if (isEmpty(this.nome)){
			throw new RuntimeException("O campo nome do coordenador é obrigatório");
		}		
		if (isEmpty(this.cpf)){
			throw new RuntimeException("O campo CPF do coordenador é obrigatório");
		}
		if (this.idade <= 0){
			throw new RuntimeException("O campo idade do coordenador é obrigatório");
		}		
    }

    private static boolean isEmpty(String s){
		if (s == null) return true;
		if (s.equals("")) return true;
		return false;
	}
}
