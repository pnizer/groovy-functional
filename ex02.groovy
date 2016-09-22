
fibonacciGenerator = {
  def a = 0, b = 1
  return {
     def tmp = a
     a = b
     b += tmp
  }
}

fibonacci = fibonacciGenerator()
println fibonacci()
println fibonacci()
println fibonacci()
println fibonacci()
println fibonacci()
println fibonacci()
println fibonacci()
println fibonacci()
println fibonacci()

