package br.com.cd2.integrator.module.domazzi.ms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cd2.integrator.module.domazzi.ms.dto.DomazziDTO;
import br.com.cd2.integrator.module.domazzi.ms.model.Domazzi;
import br.com.cd2.integrator.module.domazzi.ms.repository.DomazziRepositoy;

@Service
public class DomazziDAO {

	@Autowired
	DomazziRepositoy repository;
	
	public Boolean saveProducts(String sql) {
		
		try {

			Class.forName("org.postgresql.Driver");
			

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return false;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://179.188.16.145/domazzi", "domazzi",
					"FcZv4P8#6,Ijz:");
			 
			
			
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			pstm.execute();
			pstm.close();
                        System.out.println("produto adicionado ");
                        connection.close();
                        return true;


		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;

		}

	}
		
	
	
	public List<DomazziDTO> findAll() {
		List<DomazziDTO> novoProduto = new ArrayList<>();
		List<Domazzi> domazzi = repository.findAll();
		try {

		for (int i = 0; i < domazzi.size(); i++) {
			DomazziDTO dto = new DomazziDTO();

			dto.setCategoria(domazzi.get(i).getCategoria());
			dto.setCodigo_acesso_principal(domazzi.get(i).getCodigo_acesso_principal());
			dto.setCreated_at(domazzi.get(i).getCreated_at());
			dto.setCusto_ult_compra_cd(domazzi.get(i).getCusto_ult_compra_cd());
			dto.setData_ult_compra(domazzi.get(i).getData_ult_compra());
			dto.setDescricao_domazzi(domazzi.get(i).getDescricao_domazzi());
			dto.setDescricao_produto(domazzi.get(i).getDescricao_produto());
			dto.setDta_ult_saida(domazzi.get(i).getDta_ult_saida());
			dto.setEstoque_12meses(domazzi.get(i).getEstoque_12meses());
			dto.setEstoque_3meses(domazzi.get(i).getEstoque_3meses());
			dto.setEstq_disponivel(domazzi.get(i).getEstq_disponivel());
			dto.setExportador(domazzi.get(i).getExportador());
			dto.setId(domazzi.get(i).getId());
			dto.setId_produto(domazzi.get(i).getId_produto());
			dto.setParceiro(domazzi.get(i).getParceiro());
			dto.setPreco_vda_alvim(domazzi.get(i).getPreco_vda_alvim());
			dto.setQtd_ult_saida(domazzi.get(i).getQtd_ult_saida());
			dto.setReferencia_domazzi(domazzi.get(i).getReferencia_domazzi());
			dto.setUpdated_at(domazzi.get(i).getUpdated_at());
			
			novoProduto.add(dto);
		}
		
			return novoProduto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public DomazziDTO findById(Long id) {
		Domazzi novoProduto = repository.findId(id);;
		
		DomazziDTO dto = new DomazziDTO();
		try {
			dto.setCategoria(novoProduto.getCategoria());
			dto.setCodigo_acesso_principal(novoProduto.getCodigo_acesso_principal());
			dto.setCreated_at(novoProduto.getCreated_at());
			dto.setCusto_ult_compra_cd(novoProduto.getCusto_ult_compra_cd());
			dto.setData_ult_compra(novoProduto.getData_ult_compra());
			dto.setDescricao_domazzi(novoProduto.getDescricao_domazzi());
			dto.setDescricao_produto(novoProduto.getDescricao_produto());
			dto.setDta_ult_saida(novoProduto.getDta_ult_saida());
			dto.setEstoque_12meses(novoProduto.getEstoque_12meses());
			dto.setEstoque_3meses(novoProduto.getEstoque_3meses());
			dto.setEstq_disponivel(novoProduto.getEstq_disponivel());
			dto.setExportador(novoProduto.getExportador());
			dto.setId(novoProduto.getId());
			dto.setId_produto(novoProduto.getId_produto());
			dto.setParceiro(novoProduto.getParceiro());
			dto.setPreco_vda_alvim(novoProduto.getPreco_vda_alvim());
			dto.setQtd_ult_saida(novoProduto.getQtd_ult_saida());
			dto.setReferencia_domazzi(novoProduto.getReferencia_domazzi());
			dto.setUpdated_at(novoProduto.getUpdated_at());
			
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<DomazziDTO> findByName(String name) {
		List<DomazziDTO> novoProduto = new ArrayList<>();
		List<Domazzi> domazzi = repository.findByName(name);
		DomazziDTO dto = new DomazziDTO();
		try {
		for (int i = 0; i < domazzi.size(); i++) {
			dto.setCategoria(domazzi.get(i).getCategoria());
			dto.setCodigo_acesso_principal(domazzi.get(i).getCodigo_acesso_principal());
			dto.setCreated_at(domazzi.get(i).getCreated_at());
			dto.setCusto_ult_compra_cd(domazzi.get(i).getCusto_ult_compra_cd());
			dto.setData_ult_compra(domazzi.get(i).getData_ult_compra());
			dto.setDescricao_domazzi(domazzi.get(i).getDescricao_domazzi());
			dto.setDescricao_produto(domazzi.get(i).getDescricao_produto());
			dto.setDta_ult_saida(domazzi.get(i).getDta_ult_saida());
			dto.setEstoque_12meses(domazzi.get(i).getEstoque_12meses());
			dto.setEstoque_3meses(domazzi.get(i).getEstoque_3meses());
			dto.setEstq_disponivel(domazzi.get(i).getEstq_disponivel());
			dto.setExportador(domazzi.get(i).getExportador());
			dto.setId(domazzi.get(i).getId());
			dto.setId_produto(domazzi.get(i).getId_produto());
			dto.setParceiro(domazzi.get(i).getParceiro());
			dto.setPreco_vda_alvim(domazzi.get(i).getPreco_vda_alvim());
			dto.setQtd_ult_saida(domazzi.get(i).getQtd_ult_saida());
			dto.setReferencia_domazzi(domazzi.get(i).getReferencia_domazzi());
			dto.setUpdated_at(domazzi.get(i).getUpdated_at());
			
			novoProduto.add(dto);
		}
		
			return novoProduto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<DomazziDTO> findByEanAndPartner(Long ean,String partner) {
		List<DomazziDTO> novoProduto = new ArrayList<>();
		List<Domazzi> domazzi = repository.findByEanAndPartner(ean,partner);
		DomazziDTO dto = new DomazziDTO();
		try {
		for (int i = 0; i < domazzi.size(); i++) {
			dto.setCategoria(domazzi.get(i).getCategoria());
			dto.setCodigo_acesso_principal(domazzi.get(i).getCodigo_acesso_principal());
			dto.setCreated_at(domazzi.get(i).getCreated_at());
			dto.setCusto_ult_compra_cd(domazzi.get(i).getCusto_ult_compra_cd());
			dto.setData_ult_compra(domazzi.get(i).getData_ult_compra());
			dto.setDescricao_domazzi(domazzi.get(i).getDescricao_domazzi());
			dto.setDescricao_produto(domazzi.get(i).getDescricao_produto());
			dto.setDta_ult_saida(domazzi.get(i).getDta_ult_saida());
			dto.setEstoque_12meses(domazzi.get(i).getEstoque_12meses());
			dto.setEstoque_3meses(domazzi.get(i).getEstoque_3meses());
			dto.setEstq_disponivel(domazzi.get(i).getEstq_disponivel());
			dto.setExportador(domazzi.get(i).getExportador());
			dto.setId(domazzi.get(i).getId());
			dto.setId_produto(domazzi.get(i).getId_produto());
			dto.setParceiro(domazzi.get(i).getParceiro());
			dto.setPreco_vda_alvim(domazzi.get(i).getPreco_vda_alvim());
			dto.setQtd_ult_saida(domazzi.get(i).getQtd_ult_saida());
			dto.setReferencia_domazzi(domazzi.get(i).getReferencia_domazzi());
			dto.setUpdated_at(domazzi.get(i).getUpdated_at());
			
			novoProduto.add(dto);
		}
		
			return novoProduto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public List<DomazziDTO> findByCategoria(String categoria) {
		List<DomazziDTO> novoProduto = new ArrayList<>();
		List<Domazzi> domazzi = repository.findByCategoria(categoria);
		DomazziDTO dto = new DomazziDTO();
		try {
		for (int i = 0; i < domazzi.size(); i++) {
			dto.setCategoria(domazzi.get(i).getCategoria());
			dto.setCodigo_acesso_principal(domazzi.get(i).getCodigo_acesso_principal());
			dto.setCreated_at(domazzi.get(i).getCreated_at());
			dto.setCusto_ult_compra_cd(domazzi.get(i).getCusto_ult_compra_cd());
			dto.setData_ult_compra(domazzi.get(i).getData_ult_compra());
			dto.setDescricao_domazzi(domazzi.get(i).getDescricao_domazzi());
			dto.setDescricao_produto(domazzi.get(i).getDescricao_produto());
			dto.setDta_ult_saida(domazzi.get(i).getDta_ult_saida());
			dto.setEstoque_12meses(domazzi.get(i).getEstoque_12meses());
			dto.setEstoque_3meses(domazzi.get(i).getEstoque_3meses());
			dto.setEstq_disponivel(domazzi.get(i).getEstq_disponivel());
			dto.setExportador(domazzi.get(i).getExportador());
			dto.setId(domazzi.get(i).getId());
			dto.setId_produto(domazzi.get(i).getId_produto());
			dto.setParceiro(domazzi.get(i).getParceiro());
			dto.setPreco_vda_alvim(domazzi.get(i).getPreco_vda_alvim());
			dto.setQtd_ult_saida(domazzi.get(i).getQtd_ult_saida());
			dto.setReferencia_domazzi(domazzi.get(i).getReferencia_domazzi());
			dto.setUpdated_at(domazzi.get(i).getUpdated_at());
			
			novoProduto.add(dto);
		}
		
			return novoProduto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public Boolean delete(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
