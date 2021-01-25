package main

import (
	"fmt"
	"strings"
)

func substringIndex(chars []string, pat []string) int {
	if len(chars) < len(pat) {
		return -1
	}
	for i:=0; i < len(chars); i++ {
		matching := false
		for j:=0; j < len(pat); j++ {
			if pat[j] == chars[i+j] {
				matching = true
			} else {
				matching = false
				break
			}
		}
		if matching {
			return i
		}
	}
	return -1
}

func kmp(pat []string, chars []string) int {
	lps := make([]int, len(pat))
	i := 0
	j := 1
	lps[0] = 0
	for j < len(pat) {
		if pat[i] == pat[j] {
			lps[j] = lps[j-1] + 1
			i++
		} else {
			lps[j] = 0
		}
		j++
	}
	fmt.Printf("lps table %v\n", lps)

	for i:=0; i < len(chars); i++ {
		matching := false
		for j:=0; j < len(pat); j++ {
			if pat[j] == chars[i+j] {
				matching = true
			} else {
				matching = false
				i = i + lps[j]
				break
			}
		}
		if matching {
			return i
		}
	}
	return -1
}

func main() {
	chars := "abcdaedabcdddabcda"
	pat := "dd"
	fmt.Printf("pattern found at index %d\n", substringIndex(strings.Split(chars, ""), strings.Split(pat, "")))
	fmt.Printf("kmp %d\n", kmp(strings.Split(pat, ""), strings.Split(chars, "")))
}
