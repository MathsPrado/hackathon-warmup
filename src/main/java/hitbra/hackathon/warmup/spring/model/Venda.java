package hitbra.hackathon.warmup.spring.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "vendas")

public class Venda {

    //region Declarações das variaveis

    @NotNull(message = "Nome do comprador não pode ser nulo")
    private String nomeComprador;

    @Pattern(regexp="\\d{11}", message="CPF necessita de 11 Digitos")
    @NotNull(message = "CPF do Comprador não pode ser nulo")
    private String cpfComprador;

    @NotNull(message = "Endereço do Comprador não pode ser nulo")
    private String endCOmprador;

    @NotNull(message = "Nome do vendedor não pode ser nulo")
    private String nomeVendedor;

    @Pattern(regexp="\\d{11}", message="CPF necessita de 11 Digitos")
    //@Size(min=11, max = 11, message="CPF necessita de 11 Digitos")
    @NotNull(message = "CPF do Vendedor não pode ser nulo")
    private String cpfVendedor;


    @NotNull(message = "Endereço do Vendedor não pode ser nulo")
    private String endVendor;

    @NotNull(message = "Placa não pode ser nula")
    private String placa;

    @NotNull(message = "Valor não pode ser nulo")
    private Double valor;

    @NotNull(message = "Data não pode ser nula")
    private String data;

    @NotNull(message = "Comprovante não pode ser nulo")
    private String comprovante;

    @Id
    public String id;


    //endregion


    //region Getter and setters
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

    //endregion
}
