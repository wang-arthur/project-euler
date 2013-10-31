'''
A row measuring seven units in length has red blocks with a minimum length of three units placed on it, 
such that any two red blocks (which are allowed to be different lengths) are separated by at least one black square. 
There are exactly seventeen ways of doing this.

How many ways can a row measuring fifty units in length be filled?
'''

def slowcount(N):
	# start with block length 3
	blocks = ["000", "111"]

	for i in range(3, N):
		newblocks = []
		for block in blocks:
			if block[-1] == "1":
				if block + "1" not in newblocks:
					newblocks.append(block + "1")
			if block + "0" not in newblocks:
				newblocks.append(block + "0")

			if block[0] == "1":
				if "1" + block not in newblocks:
					newblocks.append("1" + block)
			if "0" + block not in newblocks:
				newblocks.append("0" + block)
			# flip three ending zeroes into a new red block
			if block[0:4] == "000":
				if "111" + block[2:] not in newblocks:
					newblocks.append("111" + block[2:])
			if block[-3:] == "000":
				if block[:-2] + "111" not in newblocks:
					newblocks.append(block[:-2] + "111")

		blocks = newblocks
	if N <= 0:
		return 0
	if N <= 2:
		return 1
	return len(blocks)
				


cache = {}

def count(N):
	if N <= 0:
		return 0
	if N <= 2:
		return 1
	if N == 3:
		return 2

	if N in cache:
		return cache[N]
	sum = 0
	sum += count(N-1)
	for i in range(1, N-3):
		sum += count(i)
	sum += 2

	if N not in cache:
		cache[N] = sum
	return sum


