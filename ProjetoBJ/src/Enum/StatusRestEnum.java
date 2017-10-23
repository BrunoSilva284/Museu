/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author bruno.a.da.silva
 */
public enum StatusRestEnum {
    NOVA(1),
    EM_ATENDIMENTO(2),
    FINALIZADA(3);
    public int valor;
    StatusRestEnum(int opcao)
    {
        valor = opcao;
    }
    public int getValor()
    {
        return valor;
    }
    
}
