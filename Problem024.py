'''
What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

we can solve this problem recursively by successively finding the leading digit

for example, if we wanted to find the 5th permutation of (0, 1, 2),
we know that there are 3! total, and 2! with each leading digit.
the 5th permutation will be in the 3rd bucket (leading digit 2)
=> our problem reduces to finding the 5%2! = 1st permutation of (0, 1)
'''
def factorial(n):
	product = 1
	for i in range(1, n+1):
		product *= i
	return product

# digits is the sorted list of digits in the permutation
def nthpermutation(digits, n):
	# base case
	if len(digits) == 1:
		return str(digits[0])
	# first we determine the first digit of the desired permutation
	# there are d, (d-1)! buckets
	index = (n-1) / factorial(len(digits) - 1)
	leadingdigit = digits[index]
	# now we're trying to find the n%(d-1)th permutation of the remaining digits
	new_n = n % factorial(len(digits)-1)
	digits.remove(leadingdigit)
	# recurse
	return str(leadingdigit) + nthpermutation(digits, new_n)

print nthpermutation([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], 1000000)