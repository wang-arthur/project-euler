'''
maximum sum subsequence in a grid of numbers generated by a "lagged fibonacci sequence"

Dynamic Programming approach

apply dynamic programming for horizontal, vertical, diag, and anti-diag max

'''

import copy

# start by generating the grid

A = []

for i in range(2000):
	row = []
	for j in range(2000):
		k = i * 2000 + j + 1
		if k <= 55:
			entry = (100003 - 200003*k + 300007*k*k*k) % 1000000 - 500000
		else:
			# entry = (sk-24 + sk-55 + 1000000) (modulo 1000000) - 500000
			if j >= 24:
				sk24 = row[j-24]
			else:
				sk24 = A[i-1][2000-(24-j)]
			if j >= 55:
				sk55 = row[j-55]
			else:
				sk55 = A[i-1][2000-(55-j)]
			entry = (sk24 + sk55 + 1000000) % 1000000 - 500000
		row.append(entry)
	A.append(row)

def max_horiz(A):
	N = len(A)
	maxsum = 0
	# we really only need to copy the first column of A -- but we'll deep copy it for brevity
	B = copy.deepcopy(A)
	for j in range(N):
		if B[0][j] > maxsum:
			maxsum = B[0][j]
	for i in range(1, N):
		for j in range(N):
			# the greatest horizontal sum ending at B[i][j]
			B[i][j] = max(B[i-1][j] + A[i][j], A[i][j])
			if B[i][j] > maxsum:
				maxsum = B[i][j]
	return maxsum

def max_vert(A):
	N = len(A)
	maxsum = 0
	B = copy.deepcopy(A)
	for i in range(N):
		if B[i][0] > maxsum:
			maxsum = B[i][0]
	for i in range(N):
		for j in range(1, N):
			B[i][j] = max(B[i][j-1] + A[i][j], A[i][j])
			if B[i][j] > maxsum:
				maxsum = B[i][j]
	return maxsum

def max_diag(A):
	N = len(A)
	maxsum = 0
	B = copy.deepcopy(A)
	for k in range(N):
		if B[k][0] > maxsum:
			maxsum = B[k][0]
		if B[0][k] > maxsum:
			maxsum = B[0][k]
	for i in range(1, N):
		for j in range(1, N):
			B[i][j] = max(B[i-1][j-1] + A[i][j], A[i][j])
			if B[i][j] > maxsum:
				maxsum = B[i][j]
	return maxsum


def max_anti_diag(A):
	N = len(A)
	maxsum = 0
	B = copy.deepcopy(A)
	for j in range(N):
		if B[0][j] > maxsum:
			maxsum = B[0][j]
	for i in range(N):
		if B[i][N-1] > maxsum:
			maxsum = B[i][N-1]

	for i in range(1, N):
		for j in range(N-1):
			B[i][j] = max(B[i-1][j+1] + A[i][j], A[i][j])
			if B[i][j] > maxsum:
				maxsum = B[i][j]
	return maxsum

def max_omni_directional(A):
	return max(max_horiz(A), max_vert(A), max_diag(A), max_anti_diag(A))

print max_omni_directional(A)

