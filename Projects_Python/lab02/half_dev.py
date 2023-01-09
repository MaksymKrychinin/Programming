import math

import numpy as np


def f(x):
    return 3 ** x - 7 * (x ** 2) + 2


def half_dev(a, b, e, roundTo):
    while (b - a > e):
        c = (a + b) / 2
        if (f(b) * f(c) < 0):
            a = c
        else:
            b = c
    return round(c,roundTo)


print("half_dev")
print(half_dev(0.6, 1, 10**(-6),6))


def df(x):
    return (3 ** x) * math.log(3) - 14 * x


def newton(x, e, roundTo):
    t = f(x) / df(x)
    while (math.fabs(t) > e):
        t = f(x) / df(x)
        x -= t
    return round(x,roundTo)


print("Newton")
print(newton(0.6, 10**(-6), 6))


def forX(a, b):
    return a - f(a) * (b - a) / (f(b) - f(a))


def horda(a, b, e, roundTo):
    if f(a) * f(forX(a, b)) <= 0:
        b = forX(a, b)
    else:
        a = forX(a, b)
    while (math.fabs(f(forX(a, b))) > e):
        if f(a) * f(forX(a, b)) <= 0:
            b = forX(a, b)
        else:
            a = forX(a, b)
    return round(forX(a, b),roundTo)


print("horda")
print(horda(0.6, 1, 10**(-6),6))

def simple_iterator(xFrom, xTo, e, roundTo):
    x = np.arange(xFrom, xTo, e)
    for i in x:
        y = f(i)
        if (round(y, 5) == 0):
            return (round(i, roundTo))


print("simple iterator")
print(simple_iterator(0.6, 0.9, 10**(-6), 6))
