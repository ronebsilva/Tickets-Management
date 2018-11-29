/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.senac.tads.pi3b.model.Ticket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbezerra
 */
public class TicketDAO {

    Connection conexao;

    public TicketDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        //
        Connection conn = null;
        // Passo 1: Registar Driver JBDC
        Class.forName("com.mysql.jdbc.Driver");
        // Passo 2: Obter a conexão
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gestao_tickets",
                "root",
                "");

        return conn;
    }

    public List<Ticket> listarTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            connection = obterConexao();
            String sql = "SELECT * FROM TICKETS";
            java.sql.Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Ticket ticket = new Ticket();

                long codigo = rs.getLong("Id");
                String titulo = rs.getString("Titulo");
                String descricao = rs.getString("Descricao");
                Date dataAbertura = rs.getDate("DataAbertura");

                ticket.setId(codigo);
                ticket.setTitulo(titulo);
                ticket.setDescricao(descricao);
                ticket.setDataAbertura(dataAbertura);

                tickets.add(ticket);
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        
        }
        return tickets;
    }
    //Insere um produto na tabela "produto" do banco de dados

    public static void inserir(Ticket ticket)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "INSERT INTO TICKETS (Titulo, Descricao, DataAbertura) "
                + "VALUES (?, ?, NOW())";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"

            preparedStatement.setString(1, ticket.getTitulo());
            preparedStatement.setString(2, ticket.getDescricao());

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }

    

    public static void alterar(Ticket ticket) throws SQLException, Exception{
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            String sql = "UPDATE TICKETS "
                + " SET Titulo = ?, descricao = ?"
                + " WHERE id = ?";
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            //Comando do banco            

             
            //Setando valores
            preparedStatement.setString(1, ticket.getTitulo());
            preparedStatement.setString(2, ticket.getDescricao());
            preparedStatement.setLong(3, ticket.getId());
           
            preparedStatement.executeUpdate();
            
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }


    }   
    
    public static void remove(long codigo) throws SQLException, Exception {
        
        String sql = "DELETE FROM PRODUTO_CATEGORIA WHERE ID_PRODUTO = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try 
        {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, codigo);
            preparedStatement.execute();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) 
            {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) 
            {
                connection.close();
            }
            remove1(codigo);
        }
    }
    public static  void remove1(long codigo) throws SQLException, Exception 
    {
        String sql = "DELETE FROM PRODUTO WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        
        try 
        {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, codigo);
            preparedStatement.execute();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) 
            {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) 
            {
                connection.close();
            }
        }
    }
}
