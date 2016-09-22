
ehPar = { 
  println "${it} ehPar?"
  it % 2 == 0 
}

ehMaior = { valor ->
  { x -> 
    println "${x} eh maior do que ${valor}?"
     x > valor
   }
}

ehMaiorDoQue20 = ehMaior(20)

result = (1..100)
   .findAll(ehPar)
   .findAll(ehMaiorDoQue20)

println(result[0..4])

