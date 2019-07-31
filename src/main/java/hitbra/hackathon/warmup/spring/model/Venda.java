package hitbra.hackathon.warmup.spring.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "vendas")

public class Venda {

    @NotNull(message = "Nome do comprador não pode ser nulo")
    private String nomeComprador;
    private String cpfComprador;
    private String endCOmprador;

    private String nomeVendedor;
    private String cpfVendedor;
    private String endVendor;

    private String placa;
    private Double valor;
    private String data;
    private String comprovante;

    @Id
    public String id;

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public String getCpfComprador() {
        return cpfComprador;
    }

    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    public String getEndCOmprador() {
        return endCOmprador;
    }

    public void setEndCOmprador(String endCOmprador) {
        this.endCOmprador = endCOmprador;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(String cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public String getEndVendor() {
        return endVendor;
    }

    public void setEndVendor(String endVendor) {
        this.endVendor = endVendor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComprovante() {
        return comprovante;
    }

    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }
}
