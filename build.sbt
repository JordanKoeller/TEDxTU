name := """TEDxTrinityUniversity"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.jcenterRepo
resolvers += Resolver.sonatypeRepo("snapshots")
//resolvers += "Kaliber Internal Repository" at "https://jars.kaliber.io/artifactory/libs-release-local"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
                guice,
                "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
                "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
                "com.typesafe.play" %% "play-slick" % "3.0.0",
                "com.typesafe.slick" %% "slick-codegen" % "3.2.1",
                "com.mohiva" %% "play-silhouette" % "5.0.3",
                "com.mohiva" %% "play-silhouette-password-bcrypt" % "5.0.3",
                "com.mohiva" %% "play-silhouette-crypto-jca" % "5.0.3",
                "com.mohiva" %% "play-silhouette-persistence" % "5.0.3",
                "com.mohiva" %% "play-silhouette-testkit" % "5.0.3" % "test",
                "net.codingwell" %% "scala-guice" % "4.1.1",
                "com.iheart" %% "ficus" % "1.4.1",
                "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1",
                "com.typesafe.play" %% "play-mailer" % "6.0.1",
                "com.typesafe.play" %% "play-mailer-guice" % "6.0.1"
//                "net.kaliber" %% "play-s3" % "9.0.0"

        )

