package DeepTure.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class Modelo {
    
    private DataSource origenData;
    public static boolean entra=false;

    public Modelo(DataSource origenData) {
        this.origenData = origenData;
    }    

    boolean agregarUsuario(Usuario nuevoUsuario)throws Exception{
        Connection cn=null;
        Statement st=null;
        boolean seCreo=false;
        try{
            //obtener la conexion
            cn=origenData.getConnection();
            st=cn.createStatement();
            //Crear la instruccion sql y crear la consulta preparada(satement)
            String sql="INSERT INTO USUARIO VALUES('"+nuevoUsuario.getNombre()+"','"+nuevoUsuario.getApellidoP()+"','"+nuevoUsuario.getApellidoM()+"','"+nuevoUsuario.getCurp()+"','"+nuevoUsuario.getFecha()+"','"+nuevoUsuario.getDireccion()+"','"+nuevoUsuario.getCp()+"','"+nuevoUsuario.getTel()+"','"+nuevoUsuario.getUser()+"','"+nuevoUsuario.getPassword()+"')";
            //ejecutar las instruccion sql
            st.executeUpdate(sql);
            seCreo=true;
        }catch(Exception e){
            e.printStackTrace();
            seCreo=false;
        }finally{
            cn.close();
            st.close();
        }
        if(seCreo){
            return true;
        }else{
            return false;
        }
        
    }

    List<Usuario> iniciarSesion(Usuario comprobarExistencia) throws SQLException {
        List<Usuario> datos=new ArrayList();
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        Usuario datosUsuario=null;
        try{
        //establecer la conexion con la BBDD
            cn=origenData.getConnection();
        //crear sql que busque el producto
            String sql="SELECT * FROM USUARIO WHERE USUARIO=? AND contrasena=?";
        //crear la consulta preparada
            st=cn.prepareStatement(sql);
        //establecer los parametros
            st.setString(1,comprobarExistencia.getUser());
            st.setString(2, comprobarExistencia.getPassword());
        //ejecutar la consulta
            rs=st.executeQuery();
        //obtener los datos de respuesta
            if(rs.next()){
                do{
                    entra=true;
                    String nombre=rs.getString("nombre");
                    String apellidoP=rs.getString("apellidop");
                    String apellidoM=rs.getString("apellidom");
                    String curp=rs.getString("curp");
                    String fecha=rs.getString("fecha");
                    String direccion=rs.getString("direccion");
                    String cp=rs.getString("cp");
                    String tel=rs.getString("telefono");
                    String user=rs.getString("usuario");
                    String password=rs.getString("contrasena");
                    if(user.equalsIgnoreCase(comprobarExistencia.getUser())){
                        datosUsuario=new Usuario(nombre,apellidoP,apellidoM,curp,fecha,direccion,cp,tel,user,password);
                        datos.add(datosUsuario);
                        break;
                    }
                }while(rs.next());
            }else{
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            cn.close();
            st.close();
        }
        return datos;
    }

    void closeEntrada() {
        if(entra){
            entra=false;
        }else{
            entra = false;
        }
    }

    void borrarUsuario(Usuario borrarCuenta)throws Exception {
        Connection cn=null;
        Statement st=null;
        try{
            //establecer conexion con la bbdd
            cn=origenData.getConnection();
            st=cn.createStatement();
            //sentencia sql
            String sql="DELETE FROM USUARIO WHERE USUARIO='"+borrarCuenta.getUser()+"' AND contrasena='"+borrarCuenta.getPassword()+"'";
            st.executeUpdate(sql);
        }finally{
            cn.close();
            st.close();
        }
    }
    
    void userUpdate(Usuario userUpdate)throws Exception {
        Connection cn=null;
        Statement st=null;
        try{
            //establecemos la conexion
            cn=origenData.getConnection();
            st=cn.createStatement();
            //creamos la sentencia sql
            String sql="UPDATE USUARIO SET NOMBRE='"+userUpdate.getNombre()+"',APELLIDOP='"+userUpdate.getApellidoP()+"',APELLIDOM='"+userUpdate.getApellidoM()+"',CURP='"+userUpdate.getCurp()+"',Fecha='"+userUpdate.getFecha()+"',DIRECCION='"+userUpdate.getDireccion()+"',CP='"+userUpdate.getCp()+"',TELEFONO='"+userUpdate.getTel()+"',USUARIO='"+userUpdate.getUser()+"',CONTRASENA='"+userUpdate.getPassword()+"' WHERE contrasena='"+userUpdate.getPassword()+"'";
            st.executeUpdate(sql);
        }finally{
            cn.close();
            st.close();
        }
    }
    
}
