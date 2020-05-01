
import sbt._

object BuildUtils {
  def readVersion(name:String): String = {
    val versionFile = new File(s"./$name.version")
    def versionFileError(reason:String) = new RuntimeException(s"unabel to read version file: ${versionFile.getCanonicalPath}; $reason")
    
    IO.readLines(versionFile).map(_.trim).filter{_.nonEmpty} match {
      case Nil => throw versionFileError("at least one version must be specified")
      case version :: Nil =>
        version
      case x => throw versionFileError(s"more than one version specified: ${x.mkString(", ")}")
    }
  }
}
