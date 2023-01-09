import random
import time

array11R = []
array12R = []
array13R = []
array11 = list(range(0, 1000))
array12 = list(range(0, 10000))
array13 = list(range(0, 100000))
for i in range(0, 1000):
    array11R.append(random.random())
for i in range(0, 10000):
    array12R.append(random.random())
for i in range(0, 100000):
    array13R.append(random.random())
array21R = array11R.copy()
array22R = array12R.copy()
array23R = array13R.copy()
array31R = array11R.copy()
array32R = array12R.copy()
array33R = array13R.copy()
array21 = array11.copy()
array22 = array12.copy()
array23 = array13.copy()
array31 = array11.copy()
array32 = array12.copy()
array33 = array13.copy()

class Bubble:
    def sort(self, arrayCloned):
        n = len(arrayCloned)
        for i in range(n - 1):
            for j in range(0, n - i - 1):
                if arrayCloned[j] > arrayCloned[j + 1]:
                    arrayCloned[j], arrayCloned[j + 1] = arrayCloned[j + 1], arrayCloned[j]

class Selection:
    def sort(self, arrayCloned):
        for i in range(len(arrayCloned)):
            min_index = i
            for j in range(i + 1, len(arrayCloned)):
                if arrayCloned[min_index] > arrayCloned[j]:
                    min_index = j
            arrayCloned[i], arrayCloned[min_index] = arrayCloned[min_index], arrayCloned[i]
class Insertion:
    def sort(self, arrayCloned):
        for i in range(1, len(arrayCloned)):
            tmp = arrayCloned[i]
            j = i - 1
            while j >= 0 and tmp < arrayCloned[j]:
                arrayCloned[j + 1] = arrayCloned[j]
                j -= 1
            arrayCloned[j + 1] = tmp

Sort=Bubble()
start_time = time.time()
Sort.sort(array11)
print("Bubble sort, array 1: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array12)
print("Bubble sort, array 2: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array13)
print("Bubble sort, array 3: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array11R)
print("Bubble sort, array 1Random: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array12R)
print("Bubble sort, array 2Random: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array13R)
print("Bubble sort, array 3Random: %s seconds" % (time.time() - start_time))

Sort=Selection()
start_time = time.time()
Sort.sort(array21)
print("Selection sort, array 1: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array22)
print("Selection sort, array 2: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array23)
print("Selection sort, array 3: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array21R)
print("Selection sort, array 1Random: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array22R)
print("Selection sort, array 2Random: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array23R)
print("Selection sort, array 3Random: %s seconds" % (time.time() - start_time))

Sort=Insertion()
start_time = time.time()
Sort.sort(array31)
print("Insertion sort, array 1: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array32)
print("Insertion sort, array 2: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array33)
print("Insertion sort, array 3: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array31R)
print("Insertion sort, array 1Random: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array32R)
print("Insertion sort, array 2Random: %s seconds" % (time.time() - start_time))
start_time = time.time()
Sort.sort(array33R)
print("Insertion sort, array 3Random: %s seconds" % (time.time() - start_time))