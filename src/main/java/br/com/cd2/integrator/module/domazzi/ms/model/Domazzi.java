package br.com.cd2.integrator.module.domazzi.ms.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
public class Domazzi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long codigo_acesso_principal;
	private Long id_produto;
	private Long id_familia;
	private String descricao_produto;
	private Long id_produto_base;
	private Long id_fornecedor;
	private String nomerazao;
	private String nomecomercial;
	private String cnpj;
	private String digitocnpj;
	private String tipo;
	private String status_fornecedor;
	private Timestamp data_atualizacao;
	private String principal;
	private String status;
	private Timestamp data_exclusao;
	private String usa_afv;
	private String estoque_3meses;
	private String estoque_12meses;
	private String estq_disponivel;
	private Float custo_ult_compra_cd;
	private Float preco_vda_alvim;
	private Timestamp data_ult_compra;
	private String qtd_ult_compra;
	private Timestamp dta_ult_saida;
	private String qtd_ult_saida;
	private String parceiro;
	private String referencia_domazzi;
	private String descricao_domazzi;
	private String exportador;
	private String categoria;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Timestamp deleted_at;
	private String loja;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getId_familia() {
		return id_familia;
	}
	public void setId_familia(Long id_familia) {
		this.id_familia = id_familia;
	}
	public String getDescricao_produto() {
		return descricao_produto;
	}
	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	public Long getId_produto_base() {
		return id_produto_base;
	}
	public void setId_produto_base(Long id_produto_base) {
		this.id_produto_base = id_produto_base;
	}
	public Long getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(Long id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	public String getNomerazao() {
		return nomerazao;
	}
	public void setNomerazao(String nomerazao) {
		this.nomerazao = nomerazao;
	}
	public String getNomecomercial() {
		return nomecomercial;
	}
	public void setNomecomercial(String nomecomercial) {
		this.nomecomercial = nomecomercial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getDigitocnpj() {
		return digitocnpj;
	}
	public void setDigitocnpj(String digitocnpj) {
		this.digitocnpj = digitocnpj;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus_fornecedor() {
		return status_fornecedor;
	}
	public void setStatus_fornecedor(String status_fornecedor) {
		this.status_fornecedor = status_fornecedor;
	}
	public Timestamp getData_atualizacao() {
		return data_atualizacao;
	}
	public void setData_atualizacao(Timestamp data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getData_exclusao() {
		return data_exclusao;
	}
	public void setData_exclusao(Timestamp data_exclusao) {
		this.data_exclusao = data_exclusao;
	}
	public String getUsa_afv() {
		return usa_afv;
	}
	public void setUsa_afv(String usa_afv) {
		this.usa_afv = usa_afv;
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
	public String getEstq_disponivel() {
		return estq_disponivel;
	}
	public void setEstq_disponivel(String estq_disponivel) {
		this.estq_disponivel = estq_disponivel;
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
	public Timestamp getData_ult_compra() {
		return data_ult_compra;
	}
	public void setData_ult_compra(Timestamp data_ult_compra) {
		this.data_ult_compra = data_ult_compra;
	}
	public String getQtd_ult_compra() {
		return qtd_ult_compra;
	}
	public void setQtd_ult_compra(String qtd_ult_compra) {
		this.qtd_ult_compra = qtd_ult_compra;
	}
	public Timestamp getDta_ult_saida() {
		return dta_ult_saida;
	}
	public void setDta_ult_saida(Timestamp dta_ult_saida) {
		this.dta_ult_saida = dta_ult_saida;
	}
	public String getQtd_ult_saida() {
		return qtd_ult_saida;
	}
	public void setQtd_ult_saida(String qtd_ult_saida) {
		this.qtd_ult_saida = qtd_ult_saida;
	}
	public String getParceiro() {
		return parceiro;
	}
	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
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
	public Timestamp getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}
	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	
	
	
	
	
	
}
