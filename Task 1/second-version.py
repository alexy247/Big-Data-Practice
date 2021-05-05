import mmap
import os
import Utils
import time
from multiprocessing import Pool

numbers_byte_size = os.path.getsize('numbers')
number_byte_size = 4
max_threads = 2 * os.cpu_count()
chunk_byte_size = number_byte_size * ((numbers_byte_size // max_threads) // number_byte_size)
chunks = [[chunk_byte_size * i, chunk_byte_size * (i + 1)] for i in range(max_threads)]
chunks[-1][1] = None

def get_stat():
    with open('numbers', 'r+b') as f:
        # memory-map the file, size 0 means whole file
        with mmap.mmap(f.fileno(), 0) as mm:
            with Pool(max_threads) as pool:
                results = pool.map(Utils.get_stat, [mm[chunk[0]: chunk[1]] for chunk in chunks])
            mm.close()

        res_sum, res_max, res_min = 0, 0, results[0][2]
        for res in results:
            if res[1] > res_max:
                res_max = res[1]
            if res[2] < res_min:
                res_min = res[2]
            res_sum += res[0]

        print([res_sum, res_max, res_min])

# Эксперементы с количеством потоков os.cpu_count() ~ 74s

# [1073774560370619071, 4294967289, 5]
# --- 69.17487406730652 seconds ---

# [1073774560370619071, 4294967289, 5]
# --- 69.36997294425964 seconds ---

# [1073774560370619071, 4294967289, 5]
# --- 83.55734872817993 seconds ---

# Эксперементы с количеством потоков 2 * os.cpu_count() ~ 71s

# [1073774560370619071, 4294967289, 5]
# --- 75.52136421203613 seconds ---

# [1073774560370619071, 4294967289, 5]
# --- 71.17386984825134 seconds ---

# [1073774560370619071, 4294967289, 5]
# --- 66.37156510353088 seconds ---


if __name__ == '__main__':
    start_time = time.time()
    get_stat()
    print("--- %s seconds ---" % (time.time() - start_time))