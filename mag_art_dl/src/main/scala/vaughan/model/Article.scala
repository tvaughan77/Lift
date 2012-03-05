package vaughan.model

import java.util.Date;

/**
 * <p>Represents an article I found in a magazine that I clipped for saving.</p>
 * 
 * <p>TODO:<br/>
 *    Change the type of categories to a List of enumerated values<br/>
 *    Change the type of notes to a List of strings<br/>
 *    Consider making the publication an enumeration too
 * </p>
 * @author tom.vaughan
 * @since 2012/03/05
 */
class Article(val publication: String,
              val edition: Date,
              val page: Int,
              val title: String,
              val desc: String,
              val notes: String,
              val categories: List[String]) {

}

object Article {
    
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
}
