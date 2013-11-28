'''
Non-bouncy numbers

non-bouncy numbers are increasing or decreasing numbers

How many numbers below a googol (10^100) are not bouncy?
try a dynamic programming approach.

(we can't simply reverse increasing numbers to find decreasing numbers -- leading zeros)

procedure for calculating the # of increasing positive integers below 10^j

A[i][j] represents the number of increasing numbers ending in i
A[i][0] = []
A[i][1] = [1 for i in range(10)]
A[0][1] = 0

for i in range(10):
	for k in range(i, 10):
		A[i][j+1] += A[i][j]
A[i][j] 

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
def both(j):
	return 9*j

def nonbouncy(j):
	return increasing(j) + decreasing(j) - both(j)