package main

import (
  "fmt"
  "os"
  "strconv"
)

func main() {
  primesTo, err := strconv.Atoi(os.Args[1])
  if err != nil { 
    fmt.Printf("Bad input.")
    os.Exit(1) 
  }
  if(primesTo == 0 || primesTo == 1) {
    os.Exit(0)
  }
  primeMatrix := make([]int, primesTo + 1)
  primeMatrix[0], primeMatrix[1] = -1, -1
  for i := 2; i <= primesTo; i++ {
    primeMatrix[i] = i
  }
  for p :=2; p <= primesTo; {
    for i := 2; p*i <= primesTo; i++ {
      primeMatrix[p*i] = -1
    }
    p++
    for p <= primesTo && primeMatrix[p] == -1 { p++ }
  }
  for i := 0; i <= primesTo; i++ {
    if primeMatrix[i] != -1 {
      fmt.Println(primeMatrix[i])
    }
  } 
}
