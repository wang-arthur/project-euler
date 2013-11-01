''' cubic permutations
	find the smallest cube for which exactly five permutations of its digits are cube

	This is a heuristic (which happens to work) -- it stops when it finds a cubic permutation group with
	>= 5 elements,
'''

i = 2
cubes = {}

while True:
	j = i * i * i
	permutation_group = "".join(sorted(str(j)))
	if permutation_group in cubes:
		cubes[permutation_group].append(j)
	else:
		cubes[permutation_group] = [j]

	if len(cubes[permutation_group]) == 5:
		print cubes[permutation_group]
		break
	i += 1

