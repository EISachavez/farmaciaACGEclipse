package farmaciaACGeclipse.dto;

public class PedidoDTO {
	private String nombreMedicamento;
    private String tipoMedicamento;
    private String cantidadMedicamento;
    private String distribuidor;
    private String sucursalPrincipal;
    private String sucursalSecundaria;

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public String getCantidadMedicamento() {
        return cantidadMedicamento;
    }

    public void setCantidadMedicamento(String cantidadMedicamento) {
        this.cantidadMedicamento = cantidadMedicamento;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getSucursalPrincipal() {
        return sucursalPrincipal;
    }

    public void setSucursalPrincipal(String sucursalPrincipal) {
        this.sucursalPrincipal = sucursalPrincipal;
    }

    public String getSucursalSecundaria() {
        return sucursalSecundaria;
    }

    public void setSucursalSecundaria(String sucursalSecundaria) {
        this.sucursalSecundaria = sucursalSecundaria;
    }

    public void pedidoToString(){
        System.out.println("nombreMedicamento: " + this.nombreMedicamento);
        System.out.println("tipoMedicamento: " + this.tipoMedicamento);
        System.out.println("cantidadMedicamento: " + this.cantidadMedicamento);
        System.out.println("distribuidor: " + this.distribuidor);
        System.out.println("sucursalPrincipal: " + this.sucursalPrincipal);
        System.out.println("sucursalSecundaria: " + this.sucursalSecundaria);
    }
}
