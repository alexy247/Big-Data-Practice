import Utils
import time

def get_stat():
    array = Utils.get_numbers()
    print(Utils.get_stat(array))

# ~ 125.2

# [1073774560370619071, 4294967289, 5]
# --- 118.9814338684082 seconds ---

# [1073774560370619071, 4294967289, 5]
# --- 119.46302604675293 seconds ---

# [1073774560370619071, 4294967289, 5]
# --- 137.4039442539215 seconds ---

if __name__ == '__main__':
    start_time = time.time()
    get_stat()
    print("--- %s seconds ---" % (time.time() - start_time))