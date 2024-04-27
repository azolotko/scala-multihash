lazy val root = (project in file("."))
  .settings(
    organization := "nl.zolotko",
    name         := "multihash",
    version      := "0.1.0",
    scalaVersion := "3.4.1",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"    % "2.10.0",
      "org.specs2"    %% "specs2-core"  % "5.5.1" % "test",
      "org.specs2"    %% "specs2-junit" % "5.5.1" % "test"
    ),

    // Maven settings
    publishMavenStyle      := true,
    Test / publishArtifact := false,
    publishTo              := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    pomIncludeRepository   := { _ => false },
    licenses               := Seq("MIT" -> url("https://raw.githubusercontent.com/azolotko/scala-multihash/master/LICENSE")),
    homepage               := Some(url("https://github.com/azolotko/scala-multihash")),
    pomExtra               :=
      <scm>
        <url>git@github.com/azolotko/scala-multihash.git</url>
        <connection>scm:git:git@github.com/azolotko/scala-multihash.git</connection>
      </scm>
        <developers>
          <developer>
            <id>yusefnapora</id>
            <name>Yusef Napora</name>
            <url>http://napora.org</url>
          </developer>
        </developers>
  )
