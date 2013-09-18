import sys
#calculate the total of the name scores in a file
# (sort names alphabetically, sum up score for name * position in list)

def namevalue(name):
  alpha = 'A B C D E F G H I J K L M N O P Q R S T U V W X Y Z'
  letters = alpha.split(' ')
  dict = {}
  for i in range(26):
    dict[letters[i]] = i + 1
  sum = 0
  for i in range(len(name)):
    sum += dict[name[i]]
  return sum
  
def main():
  f = open('names.txt', 'rU')
  names = f.read()
  f.close()
  
  names = names.replace('\"', '')
  namelist = names.split(',')
  
  namelist = sorted(namelist)
  
  sum = 0
  
  for name in namelist:
    sum += namevalue(name) * (namelist.index(name) + 1)


  print sum


if __name__ == '__main__':
  main()