package principal;

public class Datos {
    // ECONOMÍA
    private int reservas;  // Millones de dólares
    private int deudaExterna;  // Millones de dólares
    private int valorDolar;  // Relación Peso-Dólar
    
    // POLÍTICA
    private int imagenPublica;  // 0-100 (100 = amado, 0 = odiado)
    private int popularidadCongreso;  // 0-100 (Qué tan aliados son los diputados)
    
    // PROTESTAS Y ESTABILIDAD
    private int descontentoSocial;  // 0-100 (100 = golpe de estado)
    private int nivelCorrupcion;  // 0-100 (100 = impunidad total)
    
    // INGRESOS GIJOS
    private int ingresoExportaciones;  // Exportaciones
    private int ingresoInversiones;  // Inversión extranjera
    
    // GASTOS FIJOS
    private int gastoImportaciones;  // Importaciones
    private int pagoDeuda;  // Pago de intereses
    
    
    // TIEMPO
    private int semana;
    private int mes;
    private int año;

    // Constructor
    public Datos() {
        this.reservas = 30000;
        this.deudaExterna = 44000;
        this.valorDolar = 1000;
        this.imagenPublica = 50;
        this.popularidadCongreso = 50;
        this.descontentoSocial = 10;
        this.nivelCorrupcion = 10;
        this.ingresoExportaciones = 1000;
        this.ingresoInversiones = 500;
        this.gastoImportaciones = 1200;
        this.pagoDeuda = 800;
        this.semana = 1;
        this.mes = 1;
        this.año = 2024;
    }

    // Métodos para modificar valores
    public void modificarReservas(int cantidad) {
        this.reservas += cantidad;
        if (this.reservas < 0) this.reservas = 0;
    }

    public void modificarImagenPublica(int cambio) {
        this.imagenPublica = Math.max(0, Math.min(100, this.imagenPublica + cambio));
    }
    
    public void modificarDeudaExterna(int cantidad) {
        this.deudaExterna = Math.max(0, Math.min(100, this.deudaExterna + cantidad));
    }
    
    public void modificarPopularidadcongreso(int valor) {
        this.popularidadCongreso = Math.max(0, Math.min(100, this.popularidadCongreso + valor));
    }
    
    public void modificarDescontentoSocial(int porcentaje) {
        this.descontentoSocial = Math.max(0, Math.min(100, this.descontentoSocial + porcentaje));
    }
    
    public void modificarNivelDeCorrupcion(int porcentaje) {
        this.nivelCorrupcion = Math.max(0, Math.min(100, this.nivelCorrupcion + porcentaje));
    }
    
    public int variacionSemanal() {
    	return (ingresoExportaciones + ingresoInversiones - gastoImportaciones - pagoDeuda);
    }

    // Método para mostrar el estado actual del país
    public String mostrarEstado() {
        return "Reservas: " + reservas + "M | Dólar: $" + valorDolar + " | Imagen Pública: " + imagenPublica + "%";
    }

    // Getters y Setters
    public int getReservas() { return reservas; }
    public int getImagenPublica() { return imagenPublica; }
    public int getDeudaExterna() { return deudaExterna; }
    public int getIngresoExportaciones() { return ingresoExportaciones; }
	public int getIngresoInversiones() { return ingresoInversiones; }
	public int getGastoImportaciones() { return gastoImportaciones; }
	public int getPagoDeuda() { return pagoDeuda; }
	public int getSemana() { return semana; }
	public int getMes() { return mes; }
	public int getAño() { return año; }
	
	public void setSemana(int semana) { this.semana = semana; }
	public void setMes(int mes) { this.mes = mes; }
	public void setAño(int año) { this.año = año; }
	public void setIngresoExportaciones(int ingresoExportaciones) { this.ingresoExportaciones = ingresoExportaciones; }
	public void setIngresoInversiones(int ingresoInversiones) { this.ingresoInversiones = ingresoInversiones; }
	public void setGastoImportaciones(int gastoImportaciones) { this.gastoImportaciones = gastoImportaciones; }
	public void setPagoDeuda(int pagoDeuda) { this.pagoDeuda = pagoDeuda; }

}
