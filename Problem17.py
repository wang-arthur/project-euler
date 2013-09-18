#count the # of letters used to spell out all, in words, the numbers between 1 and 1000
def numletter(number):
  dict = {}

  dict[0] = 0
  #one -> 3
  dict[1] = 3
  #two -> 3
  dict[2] = 3
  #three -> 5, etc.
  dict[3] = 5
  dict[4] = 4
  dict[5] = 4
  dict[6] = 3
  dict[7] = 5
  dict[8] = 5
  dict[9] = 4
  dict[10] = 3
  dict[11] = 6
  dict[12] = 6
  dict[13] = 8
  dict[14] = 8
  dict[15] = 7
  dict[16] = 7
  dict[17] = 9
  dict[18] = 8
  dict[19] = 8
  
  #twenty -> 6
  dict[20] = 6
  dict[30] = 6
  dict[40] = 5
  dict[50] = 5
  dict[60] = 5
  dict[70] = 7
  dict[80] = 6
  dict[90] = 6
  for i in range(20, 100):
    dict[i] = dict[(i//10) * 10] + dict[i % 10]
  
  for i in range(100, 1000):
    if not (i % 100) == 0:
      # example: one(3) hundred and(10) thirty two(9)
      dict[i] = dict[i/100] + 10 + dict[i%100]
    #example: two(3) hundred(7)
    else: dict[i] = dict[i/100] + 7
  
  
  dict[1000] = 11
  
  return dict[number]
  
sum = 0
for i in range(1001):
  sum += numletter(i)
print sum
  
  ##test
  #print numletter(342)
  #print numletter(42)