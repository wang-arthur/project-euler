'''
How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime fourth power?


Approach:
establish bounds for i, j, k in i^4 + j^3 + k^2, calculate the possibilities, and count distinct sums.


largest prime for which p**4 < 50000000: 83
largest prime for which p**3 < 50000000: 367
largest prime for which p**2 < 50000000: 7071

'''


def count_power_triples(n):
	x = int(n**.5)
	sieve = {i : True for i in range(2, x+1)}
	for i in range(2, x/2+1):
		if sieve[i]:
			j = i + i
			while j < x+1:
				sieve[j] = False
				j += i

	primes_to_fourth = [i for i in sieve if i <= int(n ** .25) and sieve[i]]
	primes_to_cube = [i for i in sieve if i <= int(n ** (1.0/3)) and sieve[i]]
	primes_to_square = [i for i in sieve if i <= int(n**.5) and sieve[i]]

	sum_list = []
	for i in primes_to_fourth:
		fourth = i*i*i*i
		for j in primes_to_cube:
			cube = j*j*j
			if fourth + cube >= n:
				break
			for k in primes_to_square:
				power_sum = fourth + cube + k*k
				if power_sum >= n:
					break
				sum_list.append(power_sum)
	return len(set(sum_list))

print count_power_triples(50000000)