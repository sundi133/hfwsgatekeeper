import play.Project._

name := "homefood"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "redis.clients" % "jedis" % "2.6.0",
  "com.typesafe.play" %% "play-cache" % "2.2.0" 
  ,"org.postgresql" % "postgresql" % "9.3-1100-jdbc4"
  ,"org.apache.commons" % "commons-dbcp2" % "2.0"
  ,"commons-dbcp" % "commons-dbcp" % "1.4"
  ,"org.elasticsearch" % "elasticsearch" % "1.0.3"
  ,"org.jsoup" % "jsoup" % "1.7.2"
  ,"com.google.code.gson" % "gson" % "2.2.1"
  )     

playJavaSettings
