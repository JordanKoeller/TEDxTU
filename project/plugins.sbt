// Comment to get more information during initialization
logLevel := Level.Warn

// Resolvers
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"

// Sbt plugins
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.3")

//addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.20")

//addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.3")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
