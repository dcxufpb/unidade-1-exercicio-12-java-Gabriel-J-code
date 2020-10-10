package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class TestDepartamento {

    private void rodarTestarRetorno(String expected, Departamento departamento){

		// action
		String retorno = departamento.dadosDepartamento();

		// assertion
		assertEquals(expected, retorno);
	} 

    private void verificarCampoObrigatorio(String mensagemEsperada, Departamento departamento) {
		try {
			departamento.dadosDepartamento();
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
    }

    
    String NOME_DEPARTAMENTO = "Depart 1";
    String SIGLA = "D1";
    String LOCALIZACAO = "Local1";
    String NOME_COORDENADOR = "Coorde1";
    String CPF_COORDENADOR = "123456";
    int IDADE_COORDENADOR = 30;

    private String BREAK = System.lineSeparator();

    private String TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO = "Depart 1 (D1)" + BREAK +
    "Localizado em Local1" + BREAK + 
    "Coordernado por Coorde1 (30 anos), CPF: 123456" + BREAK;

    public void DepartamentoCompleto(){
        Departamento departamentoCompleto = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO, new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, IDADE_COORDENADOR));
        rodarTestarRetorno(TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO,departamentoCompleto);
    }

    private String TEXTO_ESPERADO_DEPARTAMENTO_SEM_SIGLA = "Depart 1" + BREAK +
    "Localizado em Local1" + BREAK +
    "Coordernado por Coorde1 (30 anos), CPF: 123456" + BREAK;

    @Test
    public void DepartamentoSemSigla(){
    Departamento departamentoSemSigla = new Departamento(NOME_DEPARTAMENTO, "", LOCALIZACAO, new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, IDADE_COORDENADOR));
    rodarTestarRetorno(TEXTO_ESPERADO_DEPARTAMENTO_SEM_SIGLA, departamentoSemSigla);

    departamentoSemSigla = new Departamento(NOME_DEPARTAMENTO, null, LOCALIZACAO, new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, IDADE_COORDENADOR));
    rodarTestarRetorno(TEXTO_ESPERADO_DEPARTAMENTO_SEM_SIGLA, departamentoSemSigla);
    }

    @Test
    public void DepartamentoSemNome(){
    Departamento departamentoSemNome= new Departamento("", SIGLA, LOCALIZACAO, new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo nome do departamento é obrigatório",        departamentoSemNome);

    departamentoSemNome= new Departamento(null, SIGLA, LOCALIZACAO, new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo nome do departamento é obrigatório",        departamentoSemNome);
    }

    @Test
    public void DepartamentoSemLocalização(){
    Departamento departamentoSemLocalizacao = new Departamento(NOME_DEPARTAMENTO, SIGLA, "", new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo localizacao do departamento é obrigatório",        departamentoSemLocalizacao);

    departamentoSemLocalizacao = new Departamento(NOME_DEPARTAMENTO, SIGLA, null, new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo localizacao do departamento é obrigatório",        departamentoSemLocalizacao);
    }

    @Test
    public void CoordenadorSemNome(){
    Departamento coordenadorSemNome = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO, new Coordenador("",CPF_COORDENADOR, IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo nome do coordenador é obrigatório",        coordenadorSemNome);

    coordenadorSemNome = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO, new Coordenador(null,CPF_COORDENADOR, IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo nome do coordenador é obrigatório",        coordenadorSemNome);
    }

    @Test
    public void CoordenadorSemCPF(){
    Departamento coordenadorSemCPF = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO, new Coordenador(NOME_COORDENADOR,"", IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo CPF do coordenador é obrigatório",        coordenadorSemCPF);

    coordenadorSemCPF = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO, new Coordenador(NOME_COORDENADOR,null, IDADE_COORDENADOR));
    verificarCampoObrigatorio("O campo CPF do coordenador é obrigatório",        coordenadorSemCPF);
    }

    @Test
    public void CoordenadorSemIdade(){
    Departamento coordenadorSemIdade = new Departamento(NOME_DEPARTAMENTO, SIGLA, LOCALIZACAO, new Coordenador(NOME_COORDENADOR,CPF_COORDENADOR, 0));
    verificarCampoObrigatorio("O campo idade do coordenador é obrigatório",   coordenadorSemIdade);    
    }
}
