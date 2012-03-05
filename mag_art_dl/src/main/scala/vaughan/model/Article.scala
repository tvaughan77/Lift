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
