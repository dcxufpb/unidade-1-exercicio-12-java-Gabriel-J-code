package com.example.project;

public class Departamento {

    private String nome;
    private String sigla;
    private String localizacao;
    private Coordenador coordenador;
    
    public Departamento(String nome, String sigla, String localizacao, Coordenador coordenador){
        this.nome = nome;
        this.sigla = sigla;
        this.localizacao = localizacao;
         this.coordenador = coordenador;
    }

    public String dadosDepartamento(){
        this.validarDados();

        String _sigla = "";
        if (!isEmpty(this.sigla)){
            _sigla = " ("+this.sigla+")";
        }

        String BREAK = System.lineSeparator();
        
        String dados = this.nome + _sigla + BREAK;
        dados += "Localizado em " + this.localizacao + BREAK;
        dados += "Coordernado por " + this.coordenador.dadosCoodernador() + BREAK;
        return dados;
    }

    private void validarDados(){
        if (isEmpty(this.nome)){
            throw new RuntimeException("O campo nome do departamento é obrigatório");
        }		
        if (isEmpty(this.localizacao)){
            throw new RuntimeException("O campo localizacao do departamento é obrigatório");
        }               
    }

    private static boolean isEmpty(String s){
        if (s == null) return true;
        if (s.equals("")) return true;
        return false;
    }
}

