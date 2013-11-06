'''

A rectangular grid measuring 3 by 2 contains eighteen rectangles.

Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the grid with the nearest solution.

O(a*b) for computing the # of rectangles in a a x b grid, but we can make the search space pretty narrow
'''


def count_rectangles(A, B):
	count = 0
	for i in range(A):
		for j in range(B):
			count += (A - i) * (B - j)
	return count

# use two guesses to bound our search:
# first guess: 1 x 2000: count is 2001000
# second guess 53 x 53: count is 2047761
# we can search using a double loop
# outer loop ranges i: 1->53
# inner loop ranges j: i-> j' (where j' is the index for which (i-1, j') produced the rectangle with the closest to 2000000)

hi = 2000
closest = 2000000
area = 0

for i in range(1, 53):
	print i
	# binary search to find the closest j
	# lower bound is i, upper bound is the nearest value of j in the previous iteration.
	# for example, we know that 1 x 2000 is the closest pair for i=1
	# when we search for 2 x j, we binary search on j in the range (1, 2000)
	lo = i
	
	# linear search for closest rectangle count
	# binary search on j would be faster, but linear search is fast enough
	for j in range(lo, hi):
		diff = abs(count_rectangles(i, j) - 2000000)
		if diff < closest:
			closest = diff
			area = i * j
			# new upper bound
			next_hi = j
	hi = next_hi

print "answer = %d * %d = " %(a, b) + str(area)