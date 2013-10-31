import sys

#def is_pandigital(a):
#  return len(str(a)) == 10 and len(set(str(a))) == 10
'''
lastx = [[] for i in range(11)]
lastx[3] = lastthree
divisor = [0, 0, 0, 17, 13, 11, 7, 5, 3, 2]

for x in range(4, 10):
  lastx[x] = [10**x * i + j for i in range(10) for j in lastx[x-1] if distinct_digits(10**x * i + j) and ((10**x * i + j)/ 10**(x-1)) % divisor[x] == 0]

lastx[10] =  [1000000000 * i + j for i in range(1, 10) for j in lastx[9] if distinct_digits(1000000000* i + j)]
print sum(lastx[10])

'''

def distinct_digits(a):
  return len(set(str(a))) == len(str(a))


def main():
  lastthree = [17 * i for i in range(999/17) if distinct_digits(17*i)] 


  lastfour = [1000 * i + j for i in range(10) for j in lastthree if distinct_digits(1000*i + j) and ((1000 * i + j)/ 10) % 13 == 0]

  lastfive = [10000 * i + j for i in range(10) for j in lastfour if distinct_digits(10000*i + j) and ((10000 * i + j)/100) % 11 == 0]

  lastsix = [100000 * i + j for i in range(10) for j in lastfive if distinct_digits(100000*i + j) and ((100000 * i + j)/1000) % 7 == 0]

  lastseven = [1000000 * i + j for i in range(10) for j in lastsix if distinct_digits(1000000*i + j) and ((1000000 * i + j)/10000) % 5 == 0]

  lasteight = [10000000 * i + j for i in range(10) for j in lastseven if distinct_digits(10000000*i + j) and ((10000000 * i + j)/100000) % 3 == 0]

  lastnine = [100000000 * i + j for i in range(10) for j in lasteight if distinct_digits(100000000*i + j) and ((100000000 * i + j)/1000000) % 2 == 0]

  lastten = [1000000000* i + j for i in range(1, 10) for j in lastnine if distinct_digits(1000000000* i + j)]

  print sum(lastten)

if __name__ == '__main__':
  main()