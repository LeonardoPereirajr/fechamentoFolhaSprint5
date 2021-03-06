package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiltroTest {	

	Folha folha0 = new Folha(0, "data1");
	Folha folha1 = new Folha(1, "data2");
	Folha folha2 = new Folha(2, "data3");
	ColaboradorFolha colaborador0 = new ColaboradorFolha("Jorge", 0, "email1", 500.0); 
	ColaboradorFolha colaborador1 = new ColaboradorFolha("Jorge2", 1, "email2", 500.0); 
	CadastroColaborador cadastro = new CadastroColaborador(); 
	    
	@Test
	public void testFiltroUsuarioId() { 
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		ColaboradorFolha c = Filtro.filtro(0, cadastro);
		assertEquals(0, c.getId());
		
	}
	
	@Test
	public void testFiltroUsuarioInexistenteId() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		ColaboradorFolha c = Filtro.filtro(5, cadastro);
		assertEquals(null, c);
	}
	
	@Test
	public void testFiltroFolhaId() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, 1);
		assertEquals(1, f.getId());		
	}
	
	@Test
	public void testFiltroFolhaInexistenteId() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, 6);
		assertEquals(null, f);		
	}
	
	@Test
	public void testUsuarioFolhaTrue() {
		CadastroColaborador cadastroteste = new CadastroColaborador();
		ColaboradorFolha colaboradorteste0 = new ColaboradorFolha("Jorge", 0, "email1", 500.0); 
		ColaboradorFolha colaboradorteste1 = new ColaboradorFolha("Jorge2", 1, "email2", 500.0);
		cadastroteste.addColaboradores(colaboradorteste0);
		cadastroteste.addColaboradores(colaboradorteste1);		
		Folha folhateste0 = new Folha(0, "data");
		Folha folhateste1 = new Folha(1, "data");
		colaboradorteste0.addTotalFolhas(folhateste0);
		colaboradorteste0.addTotalFolhas(folhateste1);
		ColaboradorFolha c = Filtro.filtro(0, cadastroteste);	
		Folha f = Filtro.filtro(c, 0);
		assertEquals(folhateste0, f);
	}
	
	@Test
	public void testUsuarioFolhaFalse() {
		CadastroColaborador cadastroteste = new CadastroColaborador();
		ColaboradorFolha colaboradorteste0 = new ColaboradorFolha("Jorge", 0, "email1", 500.0); 
		ColaboradorFolha colaboradorteste1 = new ColaboradorFolha("Jorge2", 1, "email2", 500.0);
		cadastroteste.addColaboradores(colaboradorteste0);
		cadastroteste.addColaboradores(colaboradorteste1);		
		Folha folhateste0 = new Folha(0, "data");
		Folha folhateste1 = new Folha(1, "data");
		colaboradorteste0.addTotalFolhas(folhateste0);
		colaboradorteste0.addTotalFolhas(folhateste1);
		ColaboradorFolha c = Filtro.filtro(0, cadastroteste);	
		Folha f = Filtro.filtro(c, 6);
		assertEquals(null, f);
	}
	
	@Test
	public void testFiltroUsuarioEmail() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		ColaboradorFolha c = Filtro.filtro("email1", cadastro);
		assertEquals("email1", c.getEmail());
		
	}
	
	@Test
	public void testFiltroUsuarioInexistenteEmail() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		ColaboradorFolha c = Filtro.filtro("email3", cadastro);
		assertEquals(null, c);
	}
	
	@Test
	public void testFiltroFolhaData() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, "data2");
		assertEquals("data2", f.getDataEmissao());		
	}
	
	@Test
	public void testFiltroFolhaInexistenteData() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, "data4");
		assertEquals(null, f);		
	}
	
}