'''
Problem 92

A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

EVERY starting number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?

'''


def square_digit(n):
	sum = 0
	while n > 0:
		d = n % 10
		sum += d * d
		n /= 10
	return sum

# we'll cache smaller subproblems to speed up the count.
# At a certain point, square_digit(n) < n for all n > d for some value d,
# so we can just look up the smaller subproblem in the cache.
# cache[85] = True means 85's square digit chain lands on 89

cache = {}
count = 0

for i in range(1, 10000000):
	j = i
	while j != 89 and j != 1 and j not in cache:
		j = square_digit(j)

	if j == 89:
		count += 1
		cache[i] = True
	elif j == 1:
		cache[i] = False
	#otherwise, j must be in the cache
	else:
		if cache[j] == True:
			count += 1
			cache[i] = True
		else:
			cache[i] = False
print "count = " + str(count)