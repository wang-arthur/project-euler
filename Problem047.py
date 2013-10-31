'''
Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
'''

import math

def num_factors(a):
	total = 0
	for i in range(2, int(math.sqrt(a)) + 1):
		if a % i == 0:
			total += 1
			#hacky break -- we don't care about the # if it's > 4
			if total > 4:
				return -1
			while a % i == 0:
				a /= i
	if a != 1:
		total += 1
	return total

def main():
	 i = 2*3*5*7

	 while True:
	 	if num_factors(i) != 4:
	 		i += 1
	 	elif num_factors(i+1) != 4:
	 		i += 2
	 	elif num_factors(i+2) != 4:
	 		i += 3
	 	elif num_factors(i+3) != 4:
	 		i += 4
	 	else:
	 		break
	 print i

if __name__ == "__main__":
	main()