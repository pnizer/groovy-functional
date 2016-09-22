import groovy.transform.TailRecursive
 
@TailRecursive
long sizeOfList(list, counter = 0) {
    if (list.size() == 0) {
        counter
    } else {
       sizeOfList(list.tail(), counter + 1)
    }
}
 
// Without @TailRecursive a StackOverFlowError
// is thrown.
println(sizeOfList(1..10000))

@TailRecursive
def filtrarRec(lista, p, acc=[]) {
   if (lista.size() == 0) return acc
   if (p(lista.head()))
      filtrarRec(lista.tail(), p, acc + lista.head())
   else
      filtrarRec(lista.tail(), p, acc)
}

filtrarRecClosure = { lista, p, acc=[] ->
   if (lista.size() == 0) return acc

   if (p(lista.head()))
     filtrarRecClosure.trampoline(lista.tail(), p, acc + lista.head())
   else
     filtrarRecClosure.trampoline(lista.tail(), p, acc)
}.trampoline()

def filtrarImp(lista, p) {
   def novaLista = []
   lista.forEach {
      if (p(it)) {
         novaLista << it
      }
   }
   novaLista
}

println filtrarRec(1..20, { it % 2 == 0 })
println filtrarImp(1..20, { it % 2 == 0 })
println filtrarRecClosure(1..20, { it % 2 == 0})

