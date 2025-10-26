package CRUD;


import com.mongodb.client.*;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@Path("/magasin")
public class GestionMongo {

    private static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private static MongoDatabase database = mongoClient.getDatabase("Articles");
    private static MongoCollection<Document> collection = database.getCollection("Articlesdb");

    @PUT
    @Consumes("application/xml")
    @Path("/article")
    public String ajouterArticle(Article article) {
        Document doc = new Document("id", article.getId())
                .append("nom", article.getNom())
                .append("fabriquant", article.getFabriquant())
                .append("prix", article.getPrix())
                .append("quantite", article.getQuantite());
        collection.insertOne(doc);
        return "Article ajouté.";
    }

    @GET
    @Produces("application/xml")
    @Path("/article")
    public List<Article> listerArticles() {
        List<Article> articleList = new ArrayList<>();
        for (Document doc : collection.find()) {
            articleList.add(new Article(
                    doc.getString("id"),
                    doc.getString("nom"),
                    doc.getString("fabriquant"),
                    doc.getDouble("prix"),
                    doc.getInteger("quantite")
            ));
        }
        return articleList;
    }

    @POST
    @Consumes("application/xml")
    @Path("/article/{id}")
    public String updateArticle(@PathParam("id") String id, Article article) {
        // Search for the article in MongoDB using the provided 'id'
        Document existingArticle = collection.find(new Document("id", id)).first();

        if (existingArticle != null) {
            // Update article details if the article exists
            collection.updateOne(
                    new Document("id", id),
                    new Document("$set", new Document("nom", article.getNom())
                            .append("fabriquant", article.getFabriquant())
                            .append("prix", article.getPrix())
                            .append("quantite", article.getQuantite()))
            );
            return "Article updated.";
        } else {
            return "Article not found.";
        }
    }

    @DELETE
    @Consumes("application/xml")
    @Path("/article/{id}")
    public String deleteArticle(@PathParam("id") String id) {
        // Find and delete the article using the provided 'id'
        Document existingArticle = collection.find(new Document("id", id)).first();

        if (existingArticle != null) {
            collection.deleteOne(new Document("id", id));
            return "Article deleted.";
        } else {
            return "Article not found.";
        }
    }
}

