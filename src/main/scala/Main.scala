@main def hello: Unit =
  println("Hello. What's your name?")
  print("Your name: ")
  val name = io.StdIn.readLine()
  println(s"Welcome, $name.")

  println("We'll echo your input. If you want to end, send EOF signal.")
  for (line <- io.Source.stdin.getLines()) println(line)

  println("Bye!")
