
<%@ page import="es.caixa.Usuario" %>
<%@ page import="es.caixa.GestorUsuarios" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<html>
    <head>
        <title>Mi pagina</title>
        <link rel="stylesheet" href="css/estilos.css">
        

    </head>
    <body>
        <h1>Soy más grande!</h1>
        <h2>Yo más pequeño!</h2>
        
        <jsp:scriptlet>
            // Codigo JAVA
            //int numero1=7;
            //int numero2=12;
            //int suma=numero1+numero2;
            GestorUsuarios miGestor=new GestorUsuarios();

           // Dar de alta 2 usuarios en el gestor de usuarios (datos fijos)
            Usuario ivan=miGestor.newUsuario("Xavi","Colmenero",40,System.currentTimeMillis()+"@gmail.com");
//            ivan.setNombre("Ivan");
//            ivan.setApellidos("Osuna");
            ivan.setEdad(39);
            miGestor.datosUsuarioModificados(ivan);
        
            // Recuperar 1 de ellos e imprimirlo por la consola
            Usuario ivanRecuperado=miGestor.getUsuario(ivan.getId());
            
            
            
        </jsp:scriptlet>
    
        <!-- <p>Resultado de la suma:  </p> -->
        <img src="imagenes/alien.png" height="100"/>
        <p>Usuario:</p>
        <ul>
            <li>Nombre: <jsp:expression>ivanRecuperado.getNombre()</jsp:expression> </li>
            <li>Apellido: <jsp:expression>ivanRecuperado.getApellidos()</jsp:expression> </li>
            <li>Edad: <jsp:expression>ivanRecuperado.getEdad()</jsp:expression> </li>
            <li>Email: <jsp:expression>ivanRecuperado.getEmail()</jsp:expression> </li>
        </ul>
       
        <jsp:scriptlet>
            Properties miConfiguracion = new Properties();
            
            try{
                InputStream miFicheroConfiguracion = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuracion.properties");

                miConfiguracion.load(miFicheroConfiguracion);
                miFicheroConfiguracion.close();            
            }catch(Exception e){
                e.printStackTrace(response.getWriter());
            }
           
        </jsp:scriptlet>

        <p>Empresa: <jsp:expression>miConfiguracion.getProperty("empresa")</jsp:expression></p>
        <!--<img src="imagenes/alien.png"/ height="5"> -->

    </body>
</html>
