package info;

public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private int ano;
    private int quilometragem;
    private Cliente donoVeiculo;

    public Veiculo(
        Long id,
        String marca,
        String modelo,
        String placa,
        String cor,
        int ano,
        int quilometragem,
        Cliente donoVeiculo
    ){
            this.id = id;
            this.marca = marca;
            this.modelo = modelo;
            this.placa = placa;
            this.cor = cor;
            this.ano = ano;
            this.quilometragem = quilometragem;
            this.donoVeiculo = donoVeiculo;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public Cliente getDonoVeiculo() {
        return donoVeiculo;
    }
}
