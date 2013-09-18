#Find the smallest positive integer, x, such that 
#2x, 3x, 4x, 5x, and 6x, contain the same digits.
import sys

def digitset(a):
  b = a
  c = len(str(b))
  digits = []
  for i in range(c):
    digits.append(b % 10)
    b /= 10
  return digits

def pmultiples(a):

  digits1 = sorted(digitset(a))
  digits2 = sorted(digitset(2 * a))
  digits3 = sorted(digitset(3 * a))
  digits4 = sorted(digitset(4 * a))
  digits5 = sorted(digitset(5 * a))
  digits6 = sorted(digitset(6 * a))
  
  if digits1 == digits2 and digits2 == digits3 and digits3 == digits4 and digits4 == digits5 and digits5 == digits6:
    return True
    
  return False
  
def main():
  a = 1
  while not pmultiples(a):
    a += 1
    
  print a


if __name__ == '__main__':
  main()