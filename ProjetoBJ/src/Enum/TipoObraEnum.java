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
public enum TipoObraEnum {
        QUADRO(1), ESCULTURA(2),DOCUMENTO(3);
        
    private int valor;
    TipoObraEnum(int opcao){
        valor = opcao;
    }
    public int getValor() {
        return valor;
    }
}
