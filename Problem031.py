# how many different ways can 2 british pounds be partitioned into coins?
# (1p, 2p, 5p, 10p, 20p, 50p, 100p, and 200p coins)

import sys
from sets import Set

def split(total, denomination):
  if total == 0: return []
  return [total - i * denomination for i in range(total // denomination + 1)]
  


def main():
  zerosum = 0
  
  list200 = split(200, 200)
  for j in list200:
    if j == 0: zerosum+=1
  
  list100 = []
  for k in list200: list100.extend(split(k, 100))
  for j in list100:
    if j == 0: zerosum+=1
    
  list50 = []
  for k in list100: list50.extend(split(k, 50))
  for j in list50:
    if j == 0: zerosum+=1
    
  list20 = []
  for k in list50: list20.extend(split(k, 20))
  for j in list20:
    if j == 0: zerosum+=1
    
  list10 = []
  for k in list20: list10.extend(split(k, 10))
  for j in list10:
    if j == 0: zerosum+=1
    
  list5 = []
  for k in list10: list5.extend(split(k, 5))
  for j in list5:
    if j == 0: zerosum+=1
    
  list2 = []
  for k in list5: list2.extend(split(k, 2))
    
  print len(list2) + zerosum


  

if __name__ == '__main__':
  main()