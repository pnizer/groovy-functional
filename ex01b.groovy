
def quicksort(arr, ini=0, fim=arr.size()-1) {
    def i = ini
    def j = fim

    def p = arr[(i+j) >> 1]
    while( i <= j ) {
        while( arr[i] < p ) i++
        while( arr[j] > p ) j--
        if( i <= j ) {
            def t = arr[i]
            arr[i++] = arr[j]
            arr[j--] = t
        }
    }
    if( ini < j ) quicksort(arr, ini, j )
    if( i < fim ) quicksort(arr, i, fim )

    return arr
}

def quicksortFn(list) {
   if (list.size() <= 1) return list
   
   def head = list.head()
   def tail = list.tail()
   def lessThan = tail.findAll { it < head }
   def notLessThan = tail.findAll { it >= head }
   quicksortFn(lessThan) + head + quicksortFn(notLessThan)
}


println quicksort([4,2,100,1,6,3,76,1,65,0,-1,64,32])
println quicksortFn([4,2,100,1,6,3,76,1,65,0,-1,64,32])
