'''
counting fractions in a range

how many reduced fractions n/d lie between 1/3 and 1/2, where d <= 12000?

'''

'''
def lcm(a, b):
	A = a
	B = b
	while A != B:
		if A < B:
			A += a
		else:
			B += b
	return A
'''
# a fraction n/d is reduced if lcm(n, d) == n * d

#euclid's algorithm to find gcd
# assume b > a
def coprime(a, b):
	remainder = b % a
	while remainder != 0:
		b = a
		a = remainder
		remainder = b % a
	return a == 1


count = 0

for d in range(4, 12001):
	if d % 100 == 0:
		print d

	n = d/3 + 1
	while 2 * n < d:
		if coprime(n, d):
			count += 1
		n += 1

print "count = " + str(count)