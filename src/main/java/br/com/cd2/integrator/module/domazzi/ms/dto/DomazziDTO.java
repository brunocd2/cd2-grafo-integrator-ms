package br.com.cd2.integrator.module.domazzi.ms.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

public class DomazziDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String referencia_domazzi;
	private String descricao_domazzi;
	private Long codigo_acesso_principal;
	private Long id_produto;
	private String descricao_produto;
	private String exportador;
	private String categoria;
	private Timestamp data_ult_compra;
	private String estq_disponivel;
	private String parceiro;
	private Float custo_ult_compra_cd;
	private Float preco_vda_alvim;
	private String qtd_ult_saida;
	private String estoque_3meses;
	private String estoque_12meses;
	private Timestamp dta_ult_saida;
	private Timestamp created_at;
	private Timestamp updated_at;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReferencia_domazzi() {
		return referencia_domazzi;
	}
	public void setReferencia_domazzi(String referencia_domazzi) {
		this.referencia_domazzi = referencia_domazzi;
	}
	public String getDescricao_domazzi() {
		return descricao_domazzi;
	}
	public void setDescricao_domazzi(String descricao_domazzi) {
		this.descricao_domazzi = descricao_domazzi;
	}
	public Long getCodigo_acesso_principal() {
		return codigo_acesso_principal;
	}
	public void setCodigo_acesso_principal(Long codigo_acesso_principal) {
		this.codigo_acesso_principal = codigo_acesso_principal;
	}
	public Long getId_produto() {
		return id_produto;
	}
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	public String getDescricao_produto() {
		return descricao_produto;
	}
	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	public String getExportador() {
		return exportador;
	}
	public void setExportador(String exportador) {
		this.exportador = exportador;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Timestamp getData_ult_compra() {
		return data_ult_compra;
	}
	public void setData_ult_compra(Timestamp data_ult_compra) {
		this.data_ult_compra = data_ult_compra;
	}
	public String getEstq_disponivel() {
		return estq_disponivel;
	}
	public void setEstq_disponivel(String estq_disponivel) {
		this.estq_disponivel = estq_disponivel;
	}
	public String getParceiro() {
		return parceiro;
	}
	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}
	public Float getCusto_ult_compra_cd() {
		return custo_ult_compra_cd;
	}
	public void setCusto_ult_compra_cd(Float custo_ult_compra_cd) {
		this.custo_ult_compra_cd = custo_ult_compra_cd;
	}
	public Float getPreco_vda_alvim() {
		return preco_vda_alvim;
	}
	public void setPreco_vda_alvim(Float preco_vda_alvim) {
		this.preco_vda_alvim = preco_vda_alvim;
	}
	public String getQtd_ult_saida() {
		return qtd_ult_saida;
	}
	public void setQtd_ult_saida(String qtd_ult_saida) {
		this.qtd_ult_saida = qtd_ult_saida;
	}
	public String getEstoque_3meses() {
		return estoque_3meses;
	}
	public void setEstoque_3meses(String estoque_3meses) {
		this.estoque_3meses = estoque_3meses;
	}
	public String getEstoque_12meses() {
		return estoque_12meses;
	}
	public void setEstoque_12meses(String estoque_12meses) {
		this.estoque_12meses = estoque_12meses;
	}
	public Timestamp getDta_ult_saida() {
		return dta_ult_saida;
	}
	public void setDta_ult_saida(Timestamp dta_ult_saida) {
		this.dta_ult_saida = dta_ult_saida;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	
	
	
}
