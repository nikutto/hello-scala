## Hello scala

This project is to learn scala.

### How to create an initial project

You can create scala project by giter.
Use following command.
`sbt new scala/scala3.g8`

### Basic operation of sbt

Use sbt console
```
$ sbt
sbt:hello-scala> 
```

List tasks
```
sbt:hello-scala> tasks
sbt:hello-scala> tasks -V
```

Help command
```
sbt:hello-scala> help tasks
sbt:hello-scala> help run
```


### How to run this app

```
$ sbt
sbt:hello-scala> run
```

### How to test

```
sbt:hello-scala> test
```
Also, the following command run test with hot reloads.
```
sbt:hello-scala> ~test
```

### How to format

Format
```
sbt:hello-scala> scalafmt
sbt:hello-scala> test:scalafmt
sbt:hello-scala> scalafmtAll
```

Check
```
sbt:hello-scala> scalafmtCheck
sbt:hello-scala> scalafmtCheckAll
```

