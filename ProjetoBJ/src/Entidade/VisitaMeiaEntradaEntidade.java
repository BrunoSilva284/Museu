/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

/**
 *
 * @author bruno.a.da.silva
 */
public class VisitaMeiaEntradaEntidade extends VisitaEntidade{
    
    @Override
    public void setValorEntrada(double valorEntrada){
        super.setValorEntrada(valorEntrada*0.5);
    }
}
