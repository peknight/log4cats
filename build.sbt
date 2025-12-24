import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val log4Cats = (project in file("."))
  .settings(name := "log4cats")
  .aggregate(
    log4CatsCore.jvm,
    log4CatsCore.js,
    log4CatsCore.native,
  )

lazy val log4CatsCore = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("log4cats-core"))
  .settings(name := "log4cats-core")
  .jvmSettings(libraryDependencies ++= dependencies(typelevel.log4Cats))

