organization  := "edu.luc.etl"

version       := "0.0.3"

scalaVersion  := "2.11.12"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
)

libraryDependencies ++= {
  val akkaV = "2.5.32"
  val sprayV = "1.3.4"
  val sprayJsonV = "1.3.3"
  val scalazV = "7.2.8"
  val specs2V = "2.5"
  Seq(
    "org.scalaz"          %%  "scalaz-core"   % scalazV,
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-httpx"   % sprayV,
    "io.spray"            %%  "spray-json"    % sprayJsonV,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % specs2V % "test"
  )
}

Revolver.settings

enablePlugins(JavaAppPackaging)

coverageExcludedPackages := """.*\.Boot;.*\.PrimeNumberServiceActor"""

test in assembly := {}
