package vaughan.dao

/**
 * Stolen from:
 * @see http://www.infoq.com/articles/scala_and_spring
 */
trait GenericDAO[T] {
      def findAll():List[T]
      def save(entity:T):T 
      def remove(entity:T):Unit
      def findById(id:Serializable):T
}
