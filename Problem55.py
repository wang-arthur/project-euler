'''
How many Lychrel numbers are there below ten-thousand?

A Lychrel number is one that never forms a palindrome through the
repeated process of reversing its digits and adding the number to its reversal.

because Lychrel #s haven't been proven, for this problem, it's assumed that
if no palindrome appears within 50 iterations, the # is Lychrel
'''

import sys

def is_palindrome(a):
  return a == reverse(a)
  
def reverse(a):
  stra = str(a)
  newstr = ''
  for i in range(len(stra)):
    newstr = stra[i] + newstr
  return int(newstr)
  
def reverse_sum(a):
  return a + reverse(a)
  
def is_lychrel(a):
  b = a
  for i in range(50):
    b = reverse_sum(b)
    if is_palindrome(b):
      return False
  return True
  
def main():
  numlych = 0
  for i in range(10000):
    if is_lychrel(i):
      numlych += 1
  print numlych

if __name__ == '__main__':
  main()