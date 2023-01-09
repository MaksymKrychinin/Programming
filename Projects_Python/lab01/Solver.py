import math
from operator import xor
import random
import matplotlib.pyplot as plt
import numpy as np


def ex1n1(a, b):
    return a * b


def ex1n2(a, b):
    return 2 * (a + b)


def ex2(a, b):
    return math.sqrt(a * b)


def ex3n1(x1, y1, x2, y2):
    return (abs(y2 - y1)) * (abs(x2 - x1))


def ex3n2(x1, y1, x2, y2):
    return 2 * (abs(y2 - y1) + abs(x2 - x1))


def ex4(a):
    return a % 2 == 0;


def ex5n1(a, b, c):
    return (a < b & b < c)


def ex5n2(a, b, c):
    return (a > 0 or b > 0 or c > 0)

def ex5n3(a, b, c):
    return bool(xor(xor(a > 0, b > 0), c > 0) and (not (a > 0 and b > 0 and c > 0)))


def ex6(matrix):
    x = []
    y = []
    for i in matrix:
        x.append(np.mean(i))
    for j in matrix:
        y.append(np.std(j))
    plt.plot(x, y, color="r")
    plt.xlabel("середні значення")
    plt.ylabel("стандартне відхилення")
    plt.show()


def ex7(x, y):
    return not ((x + y) % 2 == 0)


def ex8(x1, y1, x2, y2):
    return (x1 == x2 or y1 == y2) or (abs(x1 - x2) == abs(y1 - y2))


def ex9(A, B):
    print(abs(B - A) + 1)
    while A <= B:
        print(A)
        A += 1


def ex10(N):
    f = str()
    while N > 0:
        f += str(N % 10)
        N = N // 10
    return f


def ex11(array):
    all = 0
    arrayToReturn=[]
    for i in array:
        all += i
    average = all / len(array)
    for i in array:
        if i > average:
            arrayToReturn.append(i-18)
        else:
            arrayToReturn.append(i)
    return arrayToReturn


def ex12(matrix):
    plt.hist(matrix)
    plt.show()


def ex13(N):
    n = 0
    for i in range(2, N):
        if (N % i == 0):
            n += 1
    if (n <= 0):
        return True
    else:
        return False


def random_matrix():
    return np.random.rand(50,50)
