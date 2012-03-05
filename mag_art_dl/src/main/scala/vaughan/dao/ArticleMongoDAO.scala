package vaughan.dao

import vaughan.model.Article

/**
 * <p>A Mongo-backed DAO for Article objects</p>
 * @author tom.vaughan
 */
object ArticleMongoDAO extends ArticleDAO {
  
  val format = new java.text.SimpleDateFormat("yyyy-MM-dd")
  
  val mockArticle1 = new Article("Cruising World", 
                                 format.parse("2012-02-01"),
                                 23,
                                 "How to foo your bar",
                                 "Describes what foos are best in bolstering your bar",
                                 "",
                                 List("foo","bar"))
  
  
  val mockArticle2 = new Article("Sailing World", 
                                 format.parse("2011-12-15"),
                                 7,
                                 "Lorem Ipsum",
                                 "Whatever description you want goes here",
                                 "These are my notes for this artcle",
                                 List("bar","baz"))
  
  
  def findAll(): List[Article] = {
    List(mockArticle1, mockArticle2)
  }
}
