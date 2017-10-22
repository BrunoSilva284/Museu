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
public class EstudanteEntidade extends VisitanteEntidade {
    
    private String documentoEscolar;
    
    public String getDocumentoEscolar() {
        return documentoEscolar;
    }
    
    public void setDocumentoEscolar(String doc) {
        this.documentoEscolar = doc;
    }
}
