/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dto;

/**
 *
 * @author aluno
 */
public class VendaDTO {
    
    private int mes;
    
    private double valor;

    public int getMes() {
        return mes;
    }

    public double getValor() {
        return valor;
    }
    
    public VendaDTO(int mes, double valor){
        
        this.mes = mes;
        this.valor = valor;
        
    }
    
}
