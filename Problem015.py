# How many routes are there from the top left to the bottom right corner of a 20x20 grid?
# (moving only right and down)

# this problem reduces to the question: count the permutations of the string: RRRR...(20x)DDDDD...(20x)
# using basic combinatorics, the count is 40!/(20!*20!)

# we just need a simple script to calculate that expression.

product = 1
for i in range(21, 41):
	product *= i
for i in range(1, 21):
	product /= i

print product