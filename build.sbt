name := "kamon_test"

version := "1.0"

lazy val `kamon_test` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(jdbc, cache, ws, anorm)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

libraryDependencies ++= Seq(
  "io.kamon" %% "kamon-core" % "0.5.2",
  "io.kamon" %% "kamon-play-23" % "0.5.2",
  "io.kamon" %% "kamon-log-reporter" % "0.5.2",
  "io.kamon" %% "kamon-statsd" % "0.5.2",
  "io.kamon" %% "kamon-system-metrics" % "0.5.2"
)

javaOptions += "-Dkamon.auto-start=true"