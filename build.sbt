import play.Project._

name := "homefood"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
  )     

playJavaSettings
