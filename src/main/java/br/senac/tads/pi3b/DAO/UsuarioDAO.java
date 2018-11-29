package br.senac.tads.pi3b.DAO;

import br.senac.tads.pi3b.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    //Conexao do banco
    Connection conexao;

    //Construtor
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        //
        Connection conn = null;
        // Passo 1: Registar Driver JBDC
        Class.forName("com.mysql.jdbc.Driver");
        // Passo 2: Obter a conexão
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/perfumaria",
                "root",
                "");

        return conn;
    }

    


    public static Usuario verificar(String login, String senha) throws SQLException, Exception {
        
        String ret = null;
        String user = null;
        String pass = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
            
        try {
            conn = obterConexao();
            String sql = "SELECT * FROM usuarios WHERE login = '"+login+"'";
            preparedStatement = conn.prepareStatement(sql);
            
            rs = preparedStatement.executeQuery(sql);
            Usuario usuario = new Usuario();
            while (rs.next()) {
                user = rs.getString("login");
                pass = rs.getString("senha");

                if (login.equalsIgnoreCase(user) && senha.equalsIgnoreCase(pass)) {
                    usuario.setId(rs.getLong("ID"));
                    usuario.setNome(rs.getString("NOME"));
                    usuario.setLogin(rs.getString("LOGIN"));
                    usuario.setSenha(rs.getString("SENHA"));
                    return usuario;
                } 
            }
            return usuario;
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
    }

}