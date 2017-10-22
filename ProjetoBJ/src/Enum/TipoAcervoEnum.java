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
public enum TipoAcervoEnum {
    VIRTUAL(1),
    FISICO(2);
    private int valor;
    TipoAcervoEnum(int opcao){
        valor = opcao;
    }
    public int getValor() {
        return valor;
    }
}
