package hitbra.hackathon.warmup.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Document(collection = "veiculos")
public class Veiculo {

    //region Declarações das variaveis
    @NotNull (message = "Marca não pode ser nula")
    private String marca;

    @NotNull (message = "Modelo não pode ser nulo")
    private String modelo;

    @NotNull (message = "Ano não pode ser nulo")
    private Integer ano;

    @NotNull (message = "Valor não pode ser nulo")
    private Double valor;


    @NotNull (message = "Local não pode ser nulo")
    private String local;

    @NotNull (message = "Placa não pode ser nula")
    private String placa;

    @NotNull (message = "Código fipe não pode ser nulo")
    private String codigoFipe;


    private String precoFipe;

    @NotNull (message = "Id fipe não pode ser nulo")
    private String idFipe;


    private boolean disponivel;

    @Id
    public String id;

    //endregion


    //region getters and setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getIdFipe() {
        return idFipe;
    }

    public void setIdFipe(String idFipe) {
        this.idFipe = idFipe;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getPrecoFipe() {
        return precoFipe;
    }

    public void setPrecoFipe(String precoFipe) {
        this.precoFipe = precoFipe;
    }
//endregion
}
