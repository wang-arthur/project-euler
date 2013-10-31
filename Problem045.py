'''

Use recursive definitions of t/p/h numbers:
Tn = n + T(n-1)
Pn = 3n - 2 + T(n-1)
Hn = 4n-3 + H(n-1)

while the three aren't equal, repeatedly increment the smallest of the three
'''



def main():
	t = 40755 + 286
	t_index = 286

	p = 40755
	p_index = 165

	h = 40755
	h_index = 143

	while not (t == p and p == h):
		if t <= p and t <= h:
			t_index += 1
			t += t_index
		elif p <= t and p <= h:
			p_index += 1
			p += (3*p_index - 2)
		elif h <= t and h <= p:
			h_index += 1
			h += 4*h_index - 3

	print t
	# 1533776805

if __name__ == '__main__':
  main()