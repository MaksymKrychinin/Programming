import numpy as np
from matplotlib import pyplot as plt

x = np.arange(-5,5,0.1)
y1 = 3**x
y2 = (x**2) + 0.5
plt.plot(x, y1, x, y2)
plt.show()