import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val log4Cats = (project in file("."))
  .settings(name := "log4cats")
  .aggregate(log4CatsCore.projectRefs *)

lazy val log4CatsCore = (projectMatrix in file("log4cats-core"))
  .settings(name := "log4cats-core")
  .jvmPlatform(
    scalaVersions = Seq(scala.scala3.version),
    settings = libraryDependencies ++= dependencies(typelevel.log4Cats)
  )
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
  .nativePlatform(scalaVersions = Seq(scala.scala3.version))
