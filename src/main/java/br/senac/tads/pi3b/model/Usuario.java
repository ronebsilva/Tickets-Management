package br.senac.tads.pi3b.model;

public class Usuario {
    //Construtor
    private Long id;
    private String login;
    private String nome;
    private String senha;
    private String ativo;    
    //Construtor
    public Usuario() {
    }
    //Construtor

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(String login, String nome, String senha, String ativo) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }
    //Construtor
    public Usuario(Long id, String login, String nome, String senha, String ativo) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }
    //Metodo - GET
    public Long getId() {
        return id;
    }
    //Metodo - SET
    public void setId(Long id) {
        this.id = id;
    }   
    //Metodo - GET
    public String getLogin() {
        return login;
    }
    //Metodo - SET
    public void setLogin(String login) {
        this.login = login;
    }
    //Metodo - GET
    public String getNome() {
        return nome;
    }
    //Metodo - SET
    public void setNome(String nome) {
        this.nome = nome;
    }
    //Metodo - GET
    public String getSenha() {
        return senha;
    }
    //Metodo - SET
    public void setSenha(String senha) {
        this.senha = senha;
    }
    //Metodo - GET
    public String getAtivo() {
        return ativo;
    }
    //Metodo - SET
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }    
}