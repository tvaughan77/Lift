package vaughan

import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.context.annotation.Configuration
import com.mongodb.Mongo

@Configuration
class MongoConfig extends AbstractMongoConfiguration {

  def getDatabaseName:String = "mydb"

  def mongo:Mongo = new Mongo("localhost")

}