import os
import json
from multiprocessing import Pool

max_threads = os.cpu_count()

def processText(jsonStr):
    wordcount = {}
    description = json.loads(jsonStr)["description"]
    words = description.lower().replace('.', '').replace(',', '').replace(' - ', '').replace('- ', '').replace(' -', '').split()
    for word in words:
        if word in wordcount:    
            wordcount[word] += 1
        else:
            wordcount[word] = 1
    return wordcount

def addDict(main, adding):
    for key in adding:
        if (key not in main):
            main[key] = adding[key]
        else:
            main[key] += adding[key]
    return main


def get_stat():
    final = {}
    with open('gp.jsonl', 'r') as f:
        lines = f.readlines()
        with Pool(max_threads) as pool:
            results = pool.map(processText, lines, chunksize=max_threads)

        for res in results:
            final = addDict(final, res)
        # return sorted(final)
        return final['the']

if __name__ == '__main__':
    print(get_stat())
