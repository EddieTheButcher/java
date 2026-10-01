package info;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private ProfileUsuario profile;
    private boolean ativo;

    public Usuario(Long id, String nome, String email, String senha , ProfileUsuario profile) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.profile = profile;
        this.ativo = false;
    } 

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    // Descobre o perfil do Usuário
    public ProfileUsuario getProfile() {
        return profile;
    }

    // Verifica se a conta está ativa
    public boolean isAtivo() {
        return ativo;
    }

    // Ativa a conta
    public void ativarConta() {
        this.ativo = true;
    }
}

