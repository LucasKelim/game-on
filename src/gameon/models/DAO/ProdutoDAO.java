package gameon.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import gameon.models.DTO.Produto;
import gameon.models.DTO.Cliente;
import gameon.models.DTO.Usuario;
import gameon.models.valuesobjects.Email;
import gameon.utils.Conexao;

public class ProdutoDAO {
    final String NOMEDATABELA = "produto";
    
    public boolean inserir(Produto produto) {
        try {
            Connection conn = Conexao.conectar();
            
            // Primeiro insere na tabela usuario (dados da classe pai)
            String sqlUsuario = "INSERT INTO usuario (nome, descricao, preco, estoque, status, admin, criadoEm) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement psProduto = conn.prepareStatement(sqlUsuario);
            psProduto.setString(1, produto.getNome());
            psProduto.setString(2, produto.getDescricao());
            psProduto.setDouble(3, produto.getPreco());
            psProduto.setInt(4, produto.getEstoque());
            psProduto.setBoolean(5, produto.getStatus());
            psProduto.setInt(6, produto.getAdmin().getId());
            
            if (produto.getCriadoEm() != null) {
                psProduto.setTimestamp(7, Timestamp.valueOf(produto.getCriadoEm()));
            } else {
                psProduto.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            }
            
            psProduto.executeUpdate();
            
            // Pega o ID gerado para o usuário
            ResultSet rs = psProduto.getGeneratedKeys();
            int usuarioId = 0;
            if (rs.next()) {
                usuarioId = rs.getInt(1);
            }
            rs.close();
            psProduto.close();
            
            // Agora insere na tabela cliente (dados específicos)
            String sqlCliente = "INSERT INTO " + NOMEDATABELA + " (usuario_id, cpf, telefone, assasCliente) VALUES (?, ?, ?, ?);";
            PreparedStatement psCliente = conn.prepareStatement(sqlCliente);
            psCliente.setInt(1, usuarioId);
            psCliente.setString(2, cliente.getCpf());
            psCliente.setString(3, cliente.getTelefone());
            psCliente.setString(4, cliente.getAssasCliente());
            psCliente.executeUpdate();
            
            psCliente.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterar(Produto produto) {
        try {
            Connection conn = Conexao.conectar();
            
            // Atualiza a tabela usuario
            String sqlUsuario = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?;";
            PreparedStatement psProduto = conn.prepareStatement(sqlUsuario);
            psProduto.setString(1, produto.getNome());
            psProduto.setString(2, produto.getEmail());
            psProduto.setString(3, produto.getSenha());
            psProduto.setInt(4, produto.getId());
            psProduto.executeUpdate();
            psProduto.close();           
            
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean excluir(Produto produto) {
        try {
            Connection conn = Conexao.conectar();
            
            // Primeiro exclui da tabela cliente
            String sqlCliente = "DELETE FROM " + NOMEDATABELA + " WHERE usuario_id = ?;";
            PreparedStatement psCliente = conn.prepareStatement(sqlCliente);
            psCliente.setInt(1, cliente.getId());
            psCliente.executeUpdate();
            psCliente.close();
            
            // Depois exclui da tabela usuario
            String sqlUsuario = "DELETE FROM usuario WHERE id = ?;";
            PreparedStatement psUsuario = conn.prepareStatement(sqlUsuario);
            psUsuario.setInt(1, cliente.getId());
            psUsuario.executeUpdate();
            psUsuario.close();
            
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Cliente procurarPorId(int id) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT u.*, c.cpf, c.telefone, c.assasCliente " +
                        "FROM usuario u " +
                        "INNER JOIN cliente c ON u.id = c.usuario_id " +
                        "WHERE u.id = ? AND u.tipo = 'CLIENTE';";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Cliente obj = montarCliente(rs);
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Cliente procurarPorCpf(String cpf) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT u.*, c.cpf, c.telefone, c.assasCliente " +
                        "FROM usuario u " +
                        "INNER JOIN cliente c ON u.id = c.usuario_id " +
                        "WHERE c.cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Cliente obj = montarCliente(rs);
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Cliente procurarPorEmail(String email) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT u.*, c.cpf, c.telefone, c.assasCliente " +
                        "FROM usuario u " +
                        "INNER JOIN cliente c ON u.id = c.usuario_id " +
                        "WHERE u.email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Cliente obj = montarCliente(rs);
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean existe(Cliente cliente) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public List<Cliente> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT u.*, c.cpf, c.telefone, c.assasCliente " +
                        "FROM usuario u " +
                        "INNER JOIN cliente c ON u.id = c.usuario_id " +
                        "WHERE u.tipo = 'CLIENTE';";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Cliente> montarLista(ResultSet rs) {
        List<Cliente> listObj = new ArrayList<Cliente>();
        try {
            while (rs.next()) {
                Cliente obj = montarCliente(rs);
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Método auxiliar para montar um Cliente a partir do ResultSet
    private Cliente montarCliente(ResultSet rs) {
        try {
            Cliente cliente = new Cliente();
            
            // Dados da classe Usuario (pai)
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            
            Email email = new Email(rs.getString("email"));
            cliente.setEmail(email);
            
            cliente.setSenha(rs.getString("senha"));
            
            Timestamp timestamp = rs.getTimestamp("criadoEm");
            if (timestamp != null) {
                cliente.setCriadoEm(timestamp.toLocalDateTime());
            }
            
            // Dados específicos da classe Cliente (filho)
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setAssasCliente(rs.getString("assasCliente"));
            
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}