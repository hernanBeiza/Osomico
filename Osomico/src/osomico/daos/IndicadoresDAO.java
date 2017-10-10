/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osomico.daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import osomico.models.IndicadorModel;

/**
 *
 * @author hernanBeiza
 * https://code.google.com/archive/p/json-simple/downloads
 */
public class IndicadoresDAO {
    
    public IndicadoresDAODelegate delegate;

    public interface IndicadoresDAODelegate {
        //Acá hay que agregar los otros modelos una vez que estén listos
        void onIndicadoresDAODAOComplete(IndicadorModel dolarModel);
        void onIndicadoresDAOError(String error);
    }

    public IndicadoresDAODelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(IndicadoresDAODelegate delegate) {
        this.delegate = delegate;
    }
    
    public void cargar(){
        JSONParser parser = new JSONParser();
        String miURL = "http://mindicador.cl/api";
        
        try {
            URL oracle = new URL(miURL); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONObject rootObject = (JSONObject) parser.parse(inputLine);
                //1.- Obtengo el dolar desde el JSON
                JSONObject dolarJSON = (JSONObject)rootObject.get("dolar");
                //System.out.println(dolarJSON);
                //2.- Instancio una clase modelo
                IndicadorModel model = new IndicadorModel();
                model.setCodigo(dolarJSON.get("codigo").toString());
                model.setUnidadMedida(dolarJSON.get("unidad_medida").toString());
                float valor = Float.valueOf(dolarJSON.get("valor").toString());
                model.setValor(valor);
                model.setNombre(dolarJSON.get("nombre").toString());
                //{"fecha":"2017-10-06T04:00:00.000Z","codigo":"dolar","unidad_medida":"Pesos","valor":628.84,"nombre":"Dólar observado"}
                //System.out.println(dolar.toString());
                                
                //Ahora haz lo mismo con los otros indicadores.
                //1.- Obtienes del JSOn cada indicador
                //2.- Haz una clase modelo para cada uno
                //3.- Y retorna. Agrega al delegado de más arriba



                //3.- Retorno. Acá hay que agregar los otros modelos una vez que estén listos 
                delegate.onIndicadoresDAODAOComplete(model);

            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }  
    }

    
}
