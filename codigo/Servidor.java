package codigo;

import java.util.List;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class Servidor { // Definir mi tipo de dato nuevo
    
    // Propiedades
    public int numeroDeCpus;
    public int memoria;
    public int numeroDeDiscos;
    public String nombre;
    public List<String> ips;
    
    
    // Funciones
    
    void imprimete(){
        System.out.println(this.nombre);
        System.out.println(this.numeroDeCpus);
        System.out.println(this.numeroDeDiscos);
        System.out.println(this.memoria);
        System.out.println(this.ips);
        
        for(String unaIP : this.ips){
            boolean resultadoPing=this.enviarPing( unaIP );
            System.out.println("Prueba de ping: " + unaIP + " -> " + resultadoPing);
        }
    }
    boolean enviarPing (String ipAddress) {
        try{ // Intentalo
            // Construir una IP desde el texto
            InetAddress ipa = InetAddress.getByName(ipAddress);
            // Hazle ping
            return ipa.isReachable(5000);
        }catch(UnknownHostException uhe){
            // Si la ip no tiene un formato válido
            uhe.printStackTrace();
            return false;
        }catch(IOException ioe){
            // Si no tengo red, o tengo problemas de comunicaciones
            ioe.printStackTrace();
            return false;
        }
    }
}


/*

    
    // Operaciones/Funciones
    
    // Contructores
    
    
    
    
*/
//Sesión


/*
3 //Numero: +-* cuadrado absoluto  |-4| = 4   raiz cuadrado, redondeo
Ivan //Texto: concatenar, tranformar a Mayusculas / Minusculas, recortarlo,
true //Valor lógico
*/
/*
enteros,
textos,
logicos, 
decimales,
fecha
fecha/hora
hora

cuenta corriente: saldo, ingreso, cargo
empleado: darle vacaciones, conocer edad, pagarle
*/