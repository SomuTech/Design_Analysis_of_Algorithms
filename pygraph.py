import matplotlib.pyplot as plt
import numpy as np

#average case
x = np.array([5618700,3366399,1629201,291700,282500])
y = np.array([737001,264301,110899,103901,110900])
plt.subplot(1, 5, 1)
plt.plot(x)
plt.plot(y)
plt.title("average case")

#worst case
x = np.array([3274500,3388401,276600,290900,282400])
y = np.array([172900,212099,68100,65100,72001])

plt.subplot(1, 5, 3)
plt.plot(x)
plt.plot(y)
plt.title("worst case")
#best case
x = np.array([3457100,1741900,275900,290800,281500])
y = np.array([180000,101400,61900,61600,68700])

plt.subplot(1, 5, 5)
plt.plot(x)
plt.plot(y)
plt.title("best case")
plt.show()