package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Produto;

public class ProdutoDAO {

    public void inserir(Produto p) throws Exception {

        Connection conn = Conexao.getConexao();

        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";

        PreparedStatement st = conn.prepareStatement(sql);

        st.setString(1, p.getNome());
        st.setDouble(2, p.getPreco());

        st.execute();

        st.close();
        conn.close();
    }
}