package codigo;

import java.util.Map;
import java.util.WeakHashMap;

public class Programa2{
    
    public static void main(String[] args){ 
    
          // Clave  Valor           // Crearnos una tabla en RAM
        Map<String,String> textos = new WeakHashMap<String,String>();
        //WeakReference
        
        // Pausa de 30 segundos
        //try { // Intentalo 
        //    Thread.sleep(30000); // milisegundos
        //}catch(InterruptedException ex){
        //    Thread.currentThread().interrupt();
        //}
        
        //valor 1... 49999999
        for(int numero=1; numero <5000000; numero++){
            //"CLAVE_"+numero
            //"VALOR_"+numero
            textos.put("CLAVE_"+numero, "VALOR_"+numero);
        }
        
        //System.out.println(textos);
    }
    
}