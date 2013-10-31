import sys


def count(p):
  count = 0
  # upper bound -- maximum length for shortest side of a right triangle
  for a in range(1, int(1/(2+2**.5) * p) + 1):
    # loose upper/lower bounds for b
    b = a
    while b < p-a:
      if (p - a - b) * (p - a - b) == a * a + b * b:
        count += 1
        break
      b += 1
  return count

def main():
  maxcount = 0
  maxp = 0
  for p in range(1001):
    c = count(p)
    if c > maxcount:
      maxcount = c
      maxp = p
  print maxp


if __name__ == '__main__':
  main()