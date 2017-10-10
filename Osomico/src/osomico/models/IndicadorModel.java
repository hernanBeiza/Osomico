/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osomico.models;

/**
 *
 * @author hernanBeiza
 */
public class IndicadorModel {
    private String codigo;
    private String unidadMedida;
    private float valor;
    private String nombre;
    
    //{"fecha":"2017-10-06T04:00:00.000Z","codigo":"dolar","unidad_medida":"Pesos","valor":628.84,"nombre":"Dólar observado"}

    public IndicadorModel() {
    }

    public IndicadorModel(String codigo, String unidadMedida, float valor, String nombre) {
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DolarModel{" + "codigo=" + codigo + ", unidadMedida=" + unidadMedida + ", valor=" + valor + ", nombre=" + nombre + '}';
    }
    
    
    
}
