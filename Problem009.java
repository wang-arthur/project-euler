// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

/*
 * solved arithmetically without code
 * Euclid's formula generates all pythagorean triples:
 * a = k(m^2 - n^2), b = k* (2mn), c = k*m^2+n^2)
 * 
 * (m > n, m, n coprime)
 * => a+b+c = 2k(m^2 + mn) = 1000
 * m^2 + mn = 500/k
 * with k=1, we factor 500 to find the only (m, n) pair
 * to satisfy our conditions, m=20, n=5
 * a = 20^2-5^2 = 375
 * b = 2*20*5 = 200
 * c = 20^2+5^2 = 425
 * 
 * abc = 375*200*425 = 31875000
 */