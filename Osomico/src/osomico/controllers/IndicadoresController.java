/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osomico.controllers;

import osomico.daos.IndicadoresDAO;
import osomico.models.IndicadorModel;
import osomico.views.PrincipalFrame;

/**
 *
 * @author hernanBeiza
 */
public class IndicadoresController implements IndicadoresDAO.IndicadoresDAODelegate{

    private PrincipalFrame elFrame;
    /**
     * Pide los datos al DAO y los pinta en el frame correspondiente pasado por param
     * @param frame JFrame en dónde se pintarán los datos desde la API
     */
    public void cargar(PrincipalFrame frame){
        this.elFrame = frame;
        IndicadoresDAO dao = new IndicadoresDAO();
        dao.setDelegate(this);
        dao.cargar();
        //Ahora está conectado con el dao y recibirá los datos cargados, parseados e instanciadoes en el DAO
    }

    @Override
    public void onIndicadoresDAODAOComplete(IndicadorModel dolarModel) {
        System.out.println(dolarModel.toString());
        this.elFrame.mostrarDolar(dolarModel);
        //Acá le paso los datos al MainFrame
    }

    @Override
    public void onIndicadoresDAOError(String error) {
        throw new UnsupportedOperationException("Error de algún tipo relacionado con IndicadoresDAO");
    }
    
    
}
