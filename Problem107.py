'''
Using network.txt (right click and 'Save Link/Target As...'), a 6K text file c
ontaining a network with forty vertices, and given in matrix form, find the maximum
 saving which can be achieved by removing redundant edges whilst ensuring that the network 
 remains connected.

 This is a minimum spanning tree problem -- implement Prim's algorithm to solve
'''

class Edge(object):
	def __init__(self, v, w, weight):
		self.v = v
		self.w = w
		self.weight = weight
	def either(self):
		return self.v
	def other(self, vertex):
		if vertex == self.v:
			return self.w
		elif vertex == self.w:
			return self.v
		else:
			raise Exception("illegal endpoint")

	def __cmp__(self, other):
		if self.weight < other.weight:
			return -1
		elif self.weight > other.weight:
			return +1
		else:
			return 0

class EdgeWeightedGraph(object):

	def __init__(self):
		self.adj = {}
		self.E = 0
		self.V = 0
		
	def addEdge(self, v, w, weight):
		edge = Edge(v, w, weight)
		if v not in self.adj:
			self.adj[v] = [edge]
			if w in self.adj:
				self.adj[w].append(edge)
				self.V += 1
			else:
				self.adj[w] = [edge]
				self.V += 2
		else:
			self.adj[v].append(edge)
			if w in self.adj:
				self.adj[w].append(edge)
			else:
				self.adj[w] = [edge]
				self.V += 1
		self.E += 1

class IndexPQ(object):
	def __init__(self, NMAX):
		# keys[i] = priority of index i
		self.keys = {}
		# binary heap pq[i] = index of entry in ith position in heap
		self.pq = [0 for i in range(NMAX + 1)]
		# inverse of pq, qp[i] = position of index i in heap
		self.qp = {}
		self.N = 0

	def isEmpty(self):
		return self.N == 0

	def contains(self, i):
		return i in self.qp

	def size(self):
		return self.N

	def insert(self, i, key):
		if self.contains(i):
			raise ValueError("index is already in the priority queue")
		self.N += 1
		self.qp[i] = self.N
		self.pq[self.N] = i
		self.keys[i] = key
		self.swim(self.N)

	def minIndex(self):
		if self.N==0:
			raise Exception("PQ underflow")
		return self.pq[1]

	def minKey(self):
		if self.N==0:
			raise Exception("PQ underflow")
		return self.keys[self.pq[1]]

	def delMin(self):
		if self.N==0:
			raise Exception("PQ underflow")
		max = self.pq[1]
		self.exch(1, self.N)
		self.N -= 1
		self.sink(1)
		# better to delete entry or set to -1?
		del self.qp[max]
		del self.keys[self.pq[self.N+1]]
		self.pq[self.N+1] = -1
		return max

	def keyOf(self, i):
		if not self.contains(i):
			raise ValueError("index is not in the PQ")
		else:
			return self.keys[i]

	def changeKey(self, i, key):
		if not self.contains(i):
			raise ValueError("index is not in the PQ")
		self.keys[i] = key
		self.swim(self.qp[i])
		self.sink(self.qp[i])

	''' helper functions '''
	def less(self, i, j):
		return self.keys[self.pq[i]] < self.keys[self.pq[j]]

	def exch(self, i, j):
		swap = self.pq[i]
		self.pq[i] = self.pq[j]
		self.pq[j] = swap
		self.qp[self.pq[i]] = i
		self.qp[self.pq[j]] = j

	''' heap helper functions'''
	def swim(self, k):
		while k > 1 and self.less(k, k/2):
			self.exch(k, k/2)
			k /= 2
	def sink(self, k):
		while 2*k <= self.N:
			j = 2*k
			if j < self.N and self.less(j+1, j):
				j += 1
			if not self.less(j, k):
				break
			self.exch(k, j)
			k = j


class Prim(object):
	def __init__(self, G):

		self.weight = 0
		marked = []
		distTo = {v: float('inf') for v in G.adj.keys()}

		pq = IndexPQ(G.V)
		s = G.adj.keys()[0]
		distTo[s] = 0
		pq.insert(s, 0.0)

		while not pq.isEmpty():
			self.weight += pq.minKey()
			v = pq.delMin()
			marked.append(v)

			for edge in G.adj[v]:
				w = edge.other(v)

				if w in marked:
					continue
				if edge.weight < distTo[w]:
					#edge is the new best connection to w
					''' we don't need the list of edges on the mst, only the weight
					edgeTo[w] = edge
					'''
					distTo[w] = edge.weight

					if pq.contains(w):
						pq.changeKey(w, distTo[w])
					else:
						pq.insert(w, distTo[w])

def main():

	f = open('network.txt', 'rU')
	G = EdgeWeightedGraph()

	original = 0

	for i in range(40):
		row = f.readline().split(",")
		for j in range(i, 40):
			if row[j] != "-" and row[j] != "-\n":
				G.addEdge(i, j, int(row[j]))
				original += int(row[j])

	prim = Prim(G)

	print original - prim.weight





if __name__ == '__main__':
	main()
