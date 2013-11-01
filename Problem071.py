'''
By listing the set of reduced proper fractions for d <= 1,000,000 in ascending order of size,
find the numerator of the fraction immediately to the left of 3/7.

'''


closest = (2, 5)

for d in range(8, 1000001):
	n = d * 3 / 7
	if n * 7 == 3 * d:
		continue
	# is n/d closer than the previous pair n'/d' pair?
	# in other words is 3/7 - n/d < 3/7 - n'/d'?
	# or, (3d - 7n) * 7d' < (3d' - 7n') * 7d
	if (3 * d - 7 * n) * 7 * closest[1] < (3 * closest[1] - 7 * closest[0]) * 7 * d:
		closest = (n, d)

print closest[0]