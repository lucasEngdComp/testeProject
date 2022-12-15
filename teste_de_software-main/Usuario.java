public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String pegarExcecao() {
        if (this.nome == null) {
            return "Nome inválido";
        }
        if (this.email == null) {
            return "Email inválido";
        }
        if (this.senha == null) {
            return "Senha inválida";
        }

        return null;
    }

    public boolean haExcecao() {
        return this.pegarExcecao() != null;
    }
}
