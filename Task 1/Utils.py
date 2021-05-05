import numpy as np

def get_numbers():
    with open('numbers', 'r+b') as file:
        return file.read()


def get_stat(array):
    byte_array = np.frombuffer(array, dtype=np.dtype('uint32').newbyteorder('B'))
    byte_sum, byte_max, byte_min = 0, 0, byte_array[0]

    for item in byte_array:
        if item > byte_max:
            byte_max = item
        if item < byte_min:
            byte_min = item
        byte_sum += item

    return [byte_sum, byte_max, byte_min]