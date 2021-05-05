import numpy as np

#  эксперементальным путем выяснила, что 1000 чисел где-то 4.0K, 10 000 = 40K, 250 000 000 = 954M, тоесть нужно 500000000
count = 500000000
# необходимо указать, иначе будут значения 0 и 1
max_value = np.iinfo(np.uint32).max

def generate(count):
  arr = np.random.randint(2, max_value, size=count, dtype=np.dtype('uint32').newbyteorder('B')).byteswap()

  with open('numbers', 'wb') as f:
    f.write(arr.data)

generate(count)