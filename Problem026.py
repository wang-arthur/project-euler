# find the value of d (<1000) for which 1/d contains the longest recurring cycle
# in its decimal fraction

import sys

def period(d):
  #d = divisor
  dividends = []
  dividend = 1
  
  while dividend not in dividends:
    dividends.append(dividend)
    if not dividend == 0:
      while dividend // d == 0:
        dividend *= 10
    dividend = dividend % d
  
  return len(dividends) - dividends.index(dividend)
  
def main():
  max = 0
  
  for d in range(1, 1000):
    if period(d) > max:
      max = period(d)
      maxd = d
  
  print maxd
  
  #print period(17)

if __name__ == '__main__':
  main()