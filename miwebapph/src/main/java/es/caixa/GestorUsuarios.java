package es.caixa;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GestorUsuarios{
    
//    private Map<String,Usuario> tablaUsuarios = new HashMap<String,Usuario>();
    
    public Usuario getUsuario(Integer id){
        try{
            Session miSesion=HibernateUtil.getSession();
            Transaction t = miSesion.beginTransaction();
            Usuario recuperado=miSesion.get(Usuario.class, id);
            t.commit();
            miSesion.close();
            return recuperado;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Usuario newUsuario(String nombre, String apellidos, Integer edad, String email){
        try{
            Usuario nuevoUsuario=new Usuario(nombre, apellidos, edad, email);
            
            Session miSesion=HibernateUtil.getSession();
            Transaction t = miSesion.beginTransaction();
            miSesion.save(nuevoUsuario);
            t.commit();
            miSesion.close();
            return nuevoUsuario;
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void datosUsuarioModificados(Usuario modificado){
        try{
            Session miSesion=HibernateUtil.getSession();
            Transaction t = miSesion.beginTransaction();
            miSesion.update(modificado);
            t.commit();
            miSesion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void borrarUsuario(Usuario paraBorrar){
        try{
            Session miSesion=HibernateUtil.getSession();
            Transaction t = miSesion.beginTransaction();
            miSesion.delete(paraBorrar);
            t.commit();
            miSesion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
}