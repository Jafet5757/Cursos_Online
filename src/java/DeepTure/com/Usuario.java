package DeepTure.com;

/**
 *
 * @author JAFET
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String curp;
    private String fecha;
    private String direccion;
    private String cp;
    private String tel;
    private String user;
    private String password;
    
    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Usuario(int id, String nombre, String apellidoP, String apellidoM, String curp, String fecha, String direccion, String cp, String tel, String user, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.fecha = fecha;
        this.direccion = direccion;
        this.cp = cp;
        this.tel = tel;
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=, nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", curp=" + curp + ", fecha=" + fecha + ", direccion=" + direccion + ", cp=" + cp + ", tel=" + tel + ", user=" + user + ", password=" + password + '}';
    }

    public Usuario(String nombre, String apellidoP, String apellidoM, String curp, String fecha, String direccion, String cp, String tel, String user, String password) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.fecha = fecha;
        this.direccion = direccion;
        this.cp = cp;
        this.tel = tel;
        this.user = user;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
