package app;

import static spark.Spark.*;

import dao.ProdutoDAO;
import model.Produto;

public class Aplicacao {

    public static void main(String[] args) {

        port(4567);

        // liberar pasta public
        staticFiles.location("/public");

        ProdutoDAO dao = new ProdutoDAO();

        // redireciona para o HTML
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        // salvar produto
        post("/produto", (req, res) -> {

            String nome = req.queryParams("nome");
            double preco = Double.parseDouble(req.queryParams("preco"));

            Produto p = new Produto(nome, preco);
            dao.inserir(p);

            return "<h2 style='color:green; text-align:center;'>Produto salvo com sucesso! ✨</h2>" +
                   "<br><a href='/'>Voltar</a>";
        });
    }
}