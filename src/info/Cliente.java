package info;


import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private Long id;
    private Usuario usuario;
    private String cpf;
    private String telefone;
    private List<Veiculo> veiculos; // Um cliente pode adicionar vários veículos

    public Cliente(Long id, Usuario usuario, String cpf, String telefone) {
        this.id = id;
        this.usuario = usuario;
        this.cpf = cpf;
        this.telefone = telefone;
        this.veiculos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }
}

