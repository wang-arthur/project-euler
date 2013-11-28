'''
Non-bouncy numbers

An increasing number is a positive integer such that each digit is >= the digit to the left
a decreasing number is a positive integer with each digit <= the digit to its left.

A bouncy number is one that's neither increasing nor decreasing.

How many numbers below a googol (10^100) are not bouncy?

Dynamic programming approach.

Procedure for calculating the # of increasing positive integers below 10^j

A[j][i] represents the number of increasing numbers ending in i under 10^j

base case:
A[0][i] = []
A[1][i] = [1 for i in range(10)]
A[1][0] = 0

to calculate the number of increasing numbers under 10^(j+1) and over 10^j,
for each j-digit increasing number with final digit i, we could append any digit x,
i <= x <= 9 to produce a unique incrasing number with (j+1) digits.

for i in range(10):
	for k in range(i, 10):
		A[j+1][i] += A[j][i]

'''


# calculate the number of increasing numbers below 10^j
def increasing(j):
	A = []
	A.append([])
	A1 = [1 for i in range(10)]
	A1[0] = 0
	A.append(A1)

	for k in range(1, j):
		next = [0 for i in range(10)]
		for i in range(10):
			for l in range(i, 10):
				next[l] += A[-1][i]
		A.append(next)
	total = 0
	for nums in A:
		total += sum(nums)
	return total

# calculate number of decreasing numbers below 10^j
def decreasing(j):
	A = []
	A.append([])
	A1 = [1 for i in range(10)]
	A1[0] = 0
	A.append(A1)

	for k in range(1, j):
		next = [0 for i in range(10)]
		for i in range(10):
			for l in range(i+1):
				next[l] += A[-1][i]
		A.append(next)
	total = 0
	for nums in A:
		total += sum(nums)
	return total

# calculate number of integers that are both increasing and decreasing below 10^j (to eliminate the double count)
# 1..9, 11, 22, 33, etc.
def both(j):
	return 9*j

def nonbouncy(j):
	return increasing(j) + decreasing(j) - both(j)