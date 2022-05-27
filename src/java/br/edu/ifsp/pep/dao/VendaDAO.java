/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.dto.VendaDTO;
import br.edu.ifsp.pep.model.Venda;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author aluno
 */
@Stateless
public class VendaDAO  extends AbstractDAO<Venda>{
    
    public List<Venda> findAll(){
        
        return getEntityManager().createQuery("SELECT v FROM Venda v", Venda.class)
                .getResultList();
        
    }
    
    public List<Object[]> findByMes(){
        
        return getEntityManager()
                .createQuery("SELECT SQL('EXTRACT(MONTH FROM ?)', v.data) "
                        + "AS mes, SUM(v.valor) FROM Venda v GROUP BY mes ORDER BY mes")
                .getResultList();
        
    }
    
    public List<VendaDTO> findByMesDTO(){
        
        return getEntityManager()
                .createQuery("SELECT NEW br.edu.ifsp.pep.dto.VendaDTO("
                        + "FUNC('MONTH', v.data), SUM(v.valor)) "
                        + "FROM Venda v GROUP BY FUNC('MONTH', v.data) "
                        + "ORDER BY 1", VendaDTO.class)
                .getResultList();
        
    }
    
    // SELECT SQL('EXTRACT(MONTH FROM ?)', v.data) AS mes, SUM(v.valor) FROM Venda v GROUP BY mes ORDER BY mes
}
