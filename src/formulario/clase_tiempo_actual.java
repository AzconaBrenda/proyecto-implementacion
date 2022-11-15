/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author A19B45923
 */
public class clase_tiempo_actual {
    
    
    Calendar fecha = new GregorianCalendar();
    
    String anho = Integer.toString(fecha.get(Calendar.YEAR));
    String mes = Integer.toString(fecha.get(Calendar.MONTH));
    String dia = Integer.toString(fecha.get(Calendar.DATE));
    
    
    String fechacomp = anho+"/"+mes+"/"+dia;  
}
