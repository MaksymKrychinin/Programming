import numpy as np


def f(x):
    return 3 ** x - 7 * (x ** 2) + 2


def finder(xFrom, xTo, e, roundTo):
    xFrom=(xFrom+xTo)/2
    x = np.arange(xFrom, xTo, e)
    for i in x:
        y = f(i)
        if (round(y, 1) == 0):
            return (round(i, roundTo))


print(finder(0, 1, 0.001, 1))