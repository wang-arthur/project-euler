'''
count reduced fractions n/d where d <= 1000000


This problem is equivalent to:
sum i = 2 -> 1000000 (phi(i))

because the number of reduced proper fractions
with denominator d is exactly phi(d), the # of
natural numbers n < d with coprime(n, d)

slow solution ~2 minutes

faster?

'''

# prime divisors of d
def divisors(d):
	div = []
	for i in range(2, int(d ** .5) + 1):
		if d % i == 0:
			j = d/i
			div.append(i)
			while d % i == 0:
				d /= i
		if d == 1:
			break
	if d != 1:
		div.append(d)
	return div


# from euler theorem, phi(d) = d * product(1 - 1/p) over primes p dividing d
def phi(d):
	product = d
	for p in divisors(d):
		product = product * (p - 1) / p
	return product


count = 0
for i in range(2, 1000001):
	count += phi(i)
print "count = " + str(count)