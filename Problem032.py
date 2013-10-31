import sys
from sets import Set

def isPandigital(a, b):
  s = str(a) + str(b) + str(a * b)
  if len(s) != 9:
    return False
  digits = []
  for i in range(len(s)):
    if s[i] in digits:
      return False
    elif s[i] == "0":
      return False
    else:
      digits.append(s[i])
  return True


def main():
  sum = 0
  
  products = Set([])
  # pandigital products are: _ x _ _ _ _ = _ _ _ _ or _ _ x _ _ _ = _ _ _ _
  for i in range(2, 100):
    if i > 9:
      lower = 123
    else: 
      lower = 1234
    # upper bound -- product must be at most 4 digits 
    for j in range(lower, 10000 / i + 1):
      if isPandigital(i, j):
        products.add(i * j)
  for k in products:
    sum += k
  print sum

if __name__ == '__main__':
  main()